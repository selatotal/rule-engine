package br.com.selat.ruleengine.rules;

import br.com.selat.ruleengine.actions.Actions;
import br.com.selat.ruleengine.conditions.Conditions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RuleItem {

    private RuleType ruleType;
    private List<Conditions> conditions;
    private List<Actions> actions;
    private List<String> attributeNames;
    private List<String> attributeValues;

    public RuleItem(RuleType ruleType) {
        this.ruleType = ruleType;
        this.conditions = new LinkedList<>();
        this.actions = new ArrayList<>();
        this.attributeNames = new ArrayList<>();
        this.attributeValues = new ArrayList<>();
    }

    public void addCondition(Conditions condition, String attributeName, String attributeValue){
        conditions.add(condition);
        attributeNames.add(attributeName);
        attributeValues.add(attributeValue);
    }

    public void addAction(Actions action){
        actions.add(action);
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public List<Conditions> getConditions() {
        return conditions;
    }

    public List<Actions> getActions() {
        return actions;
    }

    public List<String> getAttributeNames() {
        return attributeNames;
    }

    public List<String> getAttributeValues() {
        return attributeValues;
    }
}
