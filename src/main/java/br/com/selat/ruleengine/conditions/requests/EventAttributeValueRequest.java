package br.com.selat.ruleengine.conditions.requests;

import br.com.selat.ruleengine.model.Event;

public class EventAttributeValueRequest {

    private Event event;
    private String attributeName;
    private String attributeValue;

    public EventAttributeValueRequest event(Event event){
        this.event = event;
        return this;
    }

    public EventAttributeValueRequest attributeName(String id){
        this.attributeName = id;
        return this;
    }

    public EventAttributeValueRequest attributeValue(String attributeValue){
        this.attributeValue = attributeValue;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }
}
