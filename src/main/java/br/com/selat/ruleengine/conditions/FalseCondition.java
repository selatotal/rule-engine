package br.com.selat.ruleengine.conditions;

import java.util.function.Predicate;

public class FalseCondition implements Predicate<Object> {

    @Override
    public boolean test(Object input) {
        return false;
    }
}
