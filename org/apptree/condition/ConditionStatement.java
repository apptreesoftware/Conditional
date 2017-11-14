package apptree.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ConditionStatement<T> implements Condition<T> {
    private List<Condition<T>> conditionList;
    String message;


    public List<String> getMessages() {
        List<String> messages = new ArrayList<>();
        for (Condition<T> condition : getConditionList()) {
            messages.add(condition.getMessage());
        }
        return messages;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public ConditionStatement(Condition<T>... conditions) {
        this.conditionList = Arrays.asList(conditions);
    }


    public ConditionStatement(String message, Condition<T>... conditions) {
        this.conditionList = Arrays.asList(conditions);
        this.message = message;
    }

    public ConditionStatement(Collection<Condition<T>> conditionList) {
        this.conditionList = new ArrayList<>(conditionList);
    }

    public ConditionStatement(String message, Collection<Condition<T>> conditionList) {
        this.conditionList = new ArrayList<>(conditionList);
        this.message = message;
    }

    public ConditionStatement(String message, List<Condition<T>> conditionList) {
        this.conditionList = conditionList;
        this.message = message;
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
