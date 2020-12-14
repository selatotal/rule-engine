package br.com.selat.ruleengine.conditions.requests;

import br.com.selat.ruleengine.model.Event;

public class EventAttributeIsNotEmptyRequest {
    private Event event;
    private String attributeName;

    public Event getEvent() {
        return event;
    }

    public EventAttributeIsNotEmptyRequest attribute(String attribute) {
        this.attributeName = attribute;
        return this;
    }

    public EventAttributeIsNotEmptyRequest event(Event event) {
        this.event = event;
        return this;
    }

    public String getAttributeName() {
        return attributeName;
    }

}
