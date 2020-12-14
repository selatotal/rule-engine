package br.com.selat.ruleengine.conditions;

import java.util.function.Predicate;

public enum Conditions {

    TRUE(new TrueCondition()),
    FALSE(new FalseCondition()),
    EVENT_ATTRIBUTE_IS_NOT_EMPTY(new EventAttributeIsNotEmptyCondition()),
    EVENT_ATTRIBUTE_VALUE(new EventAttributeValueCondition());

    Predicate <Object> function;

    Conditions(Predicate<Object> function){
        this.function = function;
    }

    public Boolean apply(Object parameters){
        return this.function.test(parameters);
    }
}
