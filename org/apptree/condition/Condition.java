package apptree.condition;

import java.util.Collection;

public interface Condition<T> extends Messager {
    boolean evaluate(T t);


    default boolean evaluateClause(T t, Condition<T> left, Condition<T> right, Operator operator) {
        switch (operator) {
            case AND:
                return left.evaluate(t) && right.evaluate(t);
            case OR:
                return left.evaluate(t) || right.evaluate(t);
            default:
                return false;
        }
    }


    default boolean evaluateStatement(T t, Collection<Condition<T>> conditions) {
        for (Condition condition : conditions) {
            if (!condition.evaluate(t)) return false;
        }
        return true;
    }
}
