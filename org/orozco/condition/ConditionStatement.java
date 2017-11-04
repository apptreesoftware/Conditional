package orozco.condition;

import java.util.ArrayList;
import java.util.List;

public class ConditionStatement<T> implements Condition<T> {
    private List<Condition<T>> conditionList;

    public ConditionStatement(List<Condition<T>> conditionList) {
        this.conditionList = conditionList;
    }

    public List<Condition<T>> getConditionList() {
        if (conditionList == null) {
            conditionList = new ArrayList<>();
        }
        return conditionList;
    }

    public void setConditionList(List<Condition<T>> conditionList) {
        this.conditionList = conditionList;
    }

    @Override
    public boolean evaluate(T t) {
        return evaluateStatement(t, getConditionList());
    }
}
