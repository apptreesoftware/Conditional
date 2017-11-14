package apptree.condition;


import apptree.condition.conditions.BasicCondition;

import java.util.HashMap;
import java.util.Map;

public class Conditional<T> implements Condition<T> {
    private Map<Condition<T>, String> conditionMap;

    Conditional() {

    }

    public static <T> ConditionBuilder<T> start(Condition<T> conditionSupplier) {
        return new ConditionBuilder<>(new BasicCondition<>(conditionSupplier));
    }


    public static <T> ConditionBuilder<T> create(Condition<T> condition) {
        return new ConditionBuilder<>(condition);
    }


    public static <T> ConditionBuilder<T> create(Condition<T> condition, String message) {
        return new ConditionBuilder<>(condition);
    }


    public void clearConditions(){
        this.conditionMap = null;
    }



    @Override
    public boolean evaluate(T t) {
        return evaluateStatement(t, getConditionMap().keySet());
    }

    public Map<Condition<T>, String> getConditionMap() {
        if(conditionMap == null) {
            conditionMap = new HashMap<>();
        }
        return conditionMap;
    }
}
