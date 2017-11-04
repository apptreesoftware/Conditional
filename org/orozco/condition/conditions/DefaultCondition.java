package orozco.condition.conditions;


import orozco.condition.Condition;

public class DefaultCondition implements Condition {
    @Override
    public boolean evaluate(Object o) {
        return true;
    }
}
