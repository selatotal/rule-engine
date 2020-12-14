package br.com.selat.ruleengine.actions;

import br.com.selat.ruleengine.actions.requests.CreateOccurrenceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class CreateOccurrenceAction implements Consumer<Object> {

    private static final Logger logger = LoggerFactory.getLogger(CreateOccurrenceAction.class);

    @Override
    public void accept(Object input) {
        if (!(input instanceof CreateOccurrenceRequest)){
            throw new IllegalArgumentException("Invalid input");
        }
        logger.info("Occurrence created");
    }
}
