package br.com.selat.ruleengine;

import br.com.selat.ruleengine.actions.Actions;
import br.com.selat.ruleengine.conditions.Conditions;
import br.com.selat.ruleengine.model.Event;
import br.com.selat.ruleengine.rules.Rule;
import br.com.selat.ruleengine.rules.RuleItem;
import br.com.selat.ruleengine.rules.RuleType;

public class Main {

    public static void main(String[] args) {

        // Define some rules
        Rule rule = new Rule();

        RuleItem ruleItem1 = new RuleItem(RuleType.ARRIVAL);
        ruleItem1.addCondition(Conditions.TRUE, null, null);
        rule.getRuleItems().add(ruleItem1);

        RuleItem ruleItem2 = new RuleItem(RuleType.ARRIVAL);
        ruleItem2.addCondition(Conditions.FALSE, null, null);
        rule.getRuleItems().add(ruleItem2);

        RuleItem ruleItem3 = new RuleItem(RuleType.ARRIVAL);
        ruleItem3.addCondition(Conditions.EVENT_ATTRIBUTE_VALUE, "id", "1234");
        ruleItem3.addAction(Actions.CREATE_OCCURRENCE);
        rule.getRuleItems().add(ruleItem3);

        RuleItem ruleItem4 = new RuleItem(RuleType.ARRIVAL);
        ruleItem4.addCondition(Conditions.EVENT_ATTRIBUTE_IS_NOT_EMPTY, "id", null);
        ruleItem4.addAction(Actions.CREATE_OCCURRENCE);
        rule.getRuleItems().add(ruleItem4);

        RuleItem ruleItem5 = new RuleItem(RuleType.ARRIVAL);
        ruleItem5.addCondition(Conditions.EVENT_ATTRIBUTE_IS_NOT_EMPTY, "id", null);
        ruleItem5.addCondition(Conditions.EVENT_ATTRIBUTE_VALUE, "id", "1234");
        ruleItem5.addAction(Actions.CREATE_OCCURRENCE);
        rule.getRuleItems().add(ruleItem5);

        Event event = new Event("1234");

        rule.process(RuleType.ARRIVAL, event);
    }
}
