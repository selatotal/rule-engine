package br.com.selat.ruleengine.actions.requests;

import br.com.selat.ruleengine.model.Event;

public class CreateOccurrenceRequest {

    private Event event;

    public CreateOccurrenceRequest event(Event event){
        this.event = event;
        return this;
    }

    public Event getEvent() {
        return event;
    }
}
