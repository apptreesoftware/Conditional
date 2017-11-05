package apptree.condition.conditions;


import apptree.condition.Condition;

public class DefaultCondition implements Condition {
    @Override
    public boolean evaluate(Object o) {
        return true;
    }
}
