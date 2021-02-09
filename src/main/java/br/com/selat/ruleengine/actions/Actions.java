package br.com.selat.ruleengine.actions;

import java.util.function.Consumer;

public enum Actions {
    STOP_PROCESS(t -> {}),
    CREATE_OCCURRENCE(new CreateOccurrenceAction());

    Consumer<Object> function;

    Actions(Consumer<Object> function){
        this.function = function;
    }

    public void accept(Object input){
        this.function.accept(input);
    }
}
