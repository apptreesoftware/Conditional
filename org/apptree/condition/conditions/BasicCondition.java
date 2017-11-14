package apptree.condition.conditions;


import apptree.condition.Condition;

import java.util.HashMap;
import java.util.Map;

public class BasicCondition<T> implements Condition<T> {
    private Condition<T> basicCondition;
    private String message;

    public BasicCondition() {
    }

    public BasicCondition(Condition<T> conditionSupplier) {
        basicCondition = conditionSupplier;
    }

    public BasicCondition(Condition<T> conditionSupplier, String message) {
        basicCondition = conditionSupplier;
        this.message = message;
    }

    public static <T> BasicCondition<T> withCondition(Condition<T> conditionSupplier) {
        return new BasicCondition<>(conditionSupplier);
    }

    public static <T> BasicCondition<T> withCondition(Condition<T> conditionSupplier, String errorMessage) {
        return new BasicCondition<>(conditionSupplier, errorMessage);
    }

    public static Condition defaultCondition() {
        return new DefaultCondition();
    }

    @Override
    public boolean evaluate(T t) {
        return basicCondition.evaluate(t);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
