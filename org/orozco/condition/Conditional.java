package orozco.condition;


import orozco.condition.conditions.BasicCondition;
import orozco.condition.functional.interfaces.ConditionSupplier;
import orozco.condition.functional.interfaces.FuncParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Conditional<T> implements Condition<T> {
    private List<Condition<T>> conditions;

    Conditional() {

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
