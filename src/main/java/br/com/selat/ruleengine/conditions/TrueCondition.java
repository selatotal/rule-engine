package br.com.selat.ruleengine.conditions;

import java.util.function.Predicate;

public class TrueCondition implements Predicate<Object> {

    @Override
    public boolean test(Object input) {
        return true;
    }
}
