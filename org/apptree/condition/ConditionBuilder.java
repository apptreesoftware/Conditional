package apptree.condition;

import apptree.condition.functional.interfaces.ConditionSupplier;
import apptree.condition.conditions.BasicCondition;

import java.util.Arrays;

public class ConditionBuilder<T> {
    private Conditional<T> conditional;


    public ConditionBuilder() {
    }

    public ConditionBuilder(Condition<T> condition) {
        conditional = new Conditional<>();
        conditional.getConditions().add(condition);
    }

    public ConditionBuilder<T> and(Condition<T> condition1) {
        conditional.getConditions().add(condition1);
        return this;
    }

    public ConditionBuilder<T> or(Condition<T> condition) {
        this.addOrCondition(condition);
        return this;
    }


    public ConditionBuilder<T> or(Condition<T> condition, Condition<T> condition1) {
        conditional.getConditions().add(new ConditionClause<>(condition, condition1, Operator.OR));
        return this;
    }

    public ConditionBuilder<T> with(Operator operator, Condition<T> conditionOne,
                                    Condition<T> conditionTwo) {
        return new ConditionBuilder<T>(new ConditionClause<>(conditionOne, conditionTwo, operator));
    }


    private void addOrCondition(Condition<T> condition) {
        if (!conditional.getConditions().isEmpty()) {
            ConditionStatement<T> conditionStatement =
                new ConditionStatement<>(conditional.getConditions());
            conditional.clearConditions();
            conditional.getConditions()
                       .add(new ConditionClause<>(conditionStatement, condition, Operator.OR));
            return;
        }
        throw new RuntimeException("You have no conditions to compare OR");
    }

    public Condition<T> build() {
        return new ConditionStatement<>(conditional.getConditions());
    }

}
