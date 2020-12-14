package br.com.selat.ruleengine.rules;

import br.com.selat.ruleengine.actions.Actions;
import br.com.selat.ruleengine.actions.requests.CreateOccurrenceRequest;
import br.com.selat.ruleengine.conditions.Conditions;
import br.com.selat.ruleengine.conditions.requests.EventAttributeIsNotEmptyRequest;
import br.com.selat.ruleengine.conditions.requests.EventAttributeValueRequest;
import br.com.selat.ruleengine.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class Rule {

    private static final Logger logger = LoggerFactory.getLogger(Rule.class);

    private List<RuleItem> ruleItems;

    public Rule() {
        this.ruleItems = new LinkedList<>();
    }

    public Rule(List<RuleItem> ruleItems) {
        this.ruleItems = ruleItems;
    }

    public List<RuleItem> getRuleItems() {
        return ruleItems;
    }

    public void setRuleItems(List<RuleItem> ruleItems) {
        this.ruleItems = ruleItems;
    }

    public void process(RuleType ruleType, Event event){

        for(RuleItem ruleItem : ruleItems){
            if (ruleType == ruleItem.getRuleType() && (checkConditions(event, ruleItem))){
                logger.info("action will be processed");
                executeActions(event, ruleItem);
            } else {
                logger.info("action will not be processed");
            }
        }
    }

    private boolean checkConditions(Event event, RuleItem ruleItem){
        return checkConditions(event, ruleItem, 0);
    }

    private boolean checkConditions(Event event, RuleItem ruleItem, int position){
        if (position >= ruleItem.getConditions().size()){
            return true;
        }
        Conditions condition = ruleItem.getConditions().get(position);
        String attributeName = ruleItem.getAttributeNames().get(position);
        String attributeValue = ruleItem.getAttributeValues().get(position);
        if (condition == Conditions.TRUE || condition == Conditions.FALSE){
            return condition.apply(null) && checkConditions(event, ruleItem, position+1);
        } else if (condition == Conditions.EVENT_ATTRIBUTE_IS_NOT_EMPTY){
            return condition.apply(new EventAttributeIsNotEmptyRequest().event(event).attribute(attributeName)) && checkConditions(event, ruleItem, position+1);
        } else if (condition == Conditions.EVENT_ATTRIBUTE_VALUE){
            return condition.apply(new EventAttributeValueRequest().event(event).attributeName(attributeName).attributeValue(attributeValue)) && checkConditions(event, ruleItem, position+1);
        } else {
            return false;
        }
    }

    private void executeActions(Event event, RuleItem ruleItem){
        executeActions(event, ruleItem, 0);
    }

    private void executeActions(Event event, RuleItem ruleItem, int position){
        if (position >= ruleItem.getActions().size()){
            return;
        }
        Actions action = ruleItem.getActions().get(position);
        if (action == Actions.CREATE_OCCURRENCE){
            action.accept(new CreateOccurrenceRequest().event(event));
        }
        executeActions(event, ruleItem, position+1);
    }

}

