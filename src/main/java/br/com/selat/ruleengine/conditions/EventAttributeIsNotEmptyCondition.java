package br.com.selat.ruleengine.conditions;

import br.com.selat.ruleengine.conditions.requests.EventAttributeIsNotEmptyRequest;
import br.com.selat.ruleengine.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class EventAttributeIsNotEmptyCondition implements Predicate<Object> {

    private static final Logger logger = LoggerFactory.getLogger(EventAttributeIsNotEmptyCondition.class);

    @Override
    public boolean test(Object input) {
        if (!(input instanceof EventAttributeIsNotEmptyRequest)){
            return false;
        }
        EventAttributeIsNotEmptyRequest request = (EventAttributeIsNotEmptyRequest) input;
        if (request.getEvent() == null || isBlank(request.getAttributeName())){
            return Boolean.FALSE;
        }
        try {
            Field f = Event.class.getDeclaredField(request.getAttributeName());
            f.setAccessible(true);
            String value = f.get(request.getEvent()).toString();
            if (value != null){
                return !isBlank(value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.error("Field {} not found", request.getAttributeName());
        }
        return Boolean.FALSE;
    }
}
