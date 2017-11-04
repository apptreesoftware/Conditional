package orozco.condition.conditions;


import orozco.condition.Condition;
import orozco.condition.functional.interfaces.ConditionSupplier;

public class BasicCondition<T> implements Condition<T> {
    ConditionSupplier<T> basicCondition;

    public BasicCondition() {
    }

    public BasicCondition(ConditionSupplier<T> conditionSupplier) {
        basicCondition = conditionSupplier;
    }

    public static <T> BasicCondition<T> withCondition(ConditionSupplier<T> conditionSupplier) {
        return new BasicCondition<>(conditionSupplier);
    }

    public static Condition defaultCondition() {
        return new DefaultCondition();
    }

    @Override
    public boolean evaluate(T t) {
        return basicCondition.supply(t);
    }
}
