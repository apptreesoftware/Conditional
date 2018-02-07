package apptree.condition;

import apptree.condition.messenger.Messenger;

import java.util.Collection;

public interface Condition<T> {
    boolean evaluate(T t, Messenger messenger);


    default boolean evaluateClause(T t, Condition<T> left, Condition<T> right, Operator operator, Messenger messenger) {
        switch (operator) {
            case AND:
                return left.evaluate(t, messenger) && right.evaluate(t, messenger);
            case OR:
                return left.evaluate(t, messenger) || right.evaluate(t, messenger);
            default:
                return false;
        }
    }


    default boolean evaluateStatement(T t, Collection<Condition<T>> conditions, Messenger messenger) {
        boolean success = true;
        for (Condition condition : conditions) {
            if (!condition.evaluate(t, messenger)) success =  false;
        }
        return success;
    }
}
