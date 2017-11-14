package apptree.condition;

public class ConditionBuilder<T> {
    private Conditional<T> conditional;
    public static final String DEFAULT_MESSAGE = "default";


    public ConditionBuilder() {
    }

    public ConditionBuilder(Condition<T> condition) {
        conditional = new Conditional<>();
        conditional.getConditionMap().put(condition, DEFAULT_MESSAGE);
    }

    public ConditionBuilder(Condition<T> condition, String message) {
        conditional = new Conditional<>();
        conditional.getConditionMap().put(condition, message);
    }

    public ConditionBuilder<T> and(Condition<T> condition1) {
        conditional.getConditionMap().put(condition1, DEFAULT_MESSAGE);
        return this;
    }


    public ConditionBuilder<T> and(Condition<T> condition1, String message) {
        conditional.getConditionMap().put(condition1, message);
        return this;
    }

    public ConditionBuilder<T> or(Condition<T> condition) {
        this.addOrCondition(condition, DEFAULT_MESSAGE);
        return this;
    }

    public ConditionBuilder<T> or(Condition<T> condition, String message) {
        this.addOrCondition(condition, message);
        return this;
    }


    public ConditionBuilder<T> or(Condition<T> condition, Condition<T> condition1) {
        conditional.getConditionMap().put(new ConditionClause<>(condition, condition1, Operator.OR), DEFAULT_MESSAGE);
        return this;
    }

    public ConditionBuilder<T> or(Condition<T> condition, Condition<T> condition1, String message) {
        conditional.getConditionMap().put(new ConditionClause<>(condition, condition1, Operator.OR), message);
        return this;
    }

    public ConditionBuilder<T> with(Condition<T> conditionOne,
                                    Condition<T> conditionTwo, Operator operator) {
        return new ConditionBuilder<>(new ConditionClause<>(conditionOne, conditionTwo, operator));
    }


    public ConditionBuilder<T> with(Condition<T> conditionOne,
                                    Condition<T> conditionTwo, Operator operator, String message) {
        return new ConditionBuilder<>(new ConditionClause<>(conditionOne, conditionTwo, operator, message));
    }


    private void addOrCondition(Condition<T> condition, String message) {
        if (!conditional.getConditionMap().isEmpty()) {
            ConditionStatement<T> conditionStatement =
                new ConditionStatement<>(conditional.getConditionMap().keySet());
            conditional.clearConditions();
            conditional.getConditionMap()
                       .put(new ConditionClause<>(conditionStatement, condition, Operator.OR), message);
            return;
        }
        throw new RuntimeException("You have no conditions to compare OR");
    }

    public Condition<T> build() {
        return new ConditionStatement<>(conditional.getConditionMap().keySet());
    }

}
