package apptree.condition;


import apptree.condition.conditions.BasicCondition;
import apptree.condition.functional.interfaces.ConditionSupplier;

import java.util.ArrayList;
import java.util.List;

public class Conditional<T> implements Condition<T> {
    private List<Condition<T>> conditions;

    Conditional() {

    }

    public static <T> ConditionBuilder<T> start(ConditionSupplier<T> conditionSupplier) {
        return new ConditionBuilder<>(new BasicCondition<>(conditionSupplier));
    }


    public static <T> ConditionBuilder<T> create(Condition<T> condition) {
        return new ConditionBuilder<>(condition);
    }


    public void clearConditions() {
        conditions = null;
    }

    List<Condition<T>> getConditions() {
        if (conditions == null) {
            conditions = new ArrayList<>();
        }
        return conditions;
    }

    public void setConditions(List<Condition<T>> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean evaluate(T t) {
        return evaluateStatement(t, getConditions());
    }
}
