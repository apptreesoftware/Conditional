package apptree.condition.conditions;


import apptree.condition.Condition;
import apptree.condition.messenger.Messenger;

public class DefaultCondition implements Condition {

    @Override
    public boolean evaluate(Object o, Messenger messenger) {
        return true;
    }
}
