package apptree.condition;

import apptree.condition.messenger.Messenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionStatement<T> implements Condition<T> {
    private List<Condition<T>> conditionList;

    public ConditionStatement(List<Condition<T>> conditionList) {
        this.conditionList = conditionList;
    }

    public ConditionStatement(Condition<T>[] conditionList) {
        this.conditionList = Arrays.asList(conditionList);
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
    public boolean evaluate(T t, Messenger messenger) {
        return evaluateStatement(t, getConditionList(), messenger);
    }
}
