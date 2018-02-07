package apptree.condition.conditions;


import apptree.condition.Condition;
import apptree.condition.functional.interfaces.ConditionSupplier;
import apptree.condition.messenger.Messenger;

public class BasicCondition<T> implements Condition<T> {
    ConditionSupplier<T> basicCondition;
    String message;

    public BasicCondition() {
    }

    public BasicCondition(ConditionSupplier<T> conditionSupplier, String message) {
        basicCondition = conditionSupplier;
        this.message = message;
    }

    public BasicCondition(ConditionSupplier<T> conditionSupplier) {
        basicCondition = conditionSupplier;
    }

    public static <T> BasicCondition<T> withCondition(ConditionSupplier<T> conditionSupplier, String message) {
        return new BasicCondition<>(conditionSupplier, message);
    }

    public static <T> BasicCondition<T> withCondition(ConditionSupplier<T> conditionSupplier) {
        return new BasicCondition<>(conditionSupplier);
    }

    public static Condition defaultCondition() {
        return new DefaultCondition();
    }

    @Override
    public boolean evaluate(T t, Messenger messenger) {
        boolean val =  basicCondition.supply(t);
        if(!val){
            messenger.send(message);
        }
        return val;
    }
}
