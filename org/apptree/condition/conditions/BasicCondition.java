package apptree.condition.conditions;


import apptree.condition.functional.interfaces.ConditionSupplier;
import apptree.condition.Condition;

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
