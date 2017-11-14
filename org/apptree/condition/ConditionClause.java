package apptree.condition;

import static apptree.condition.ConditionBuilder.DEFAULT_MESSAGE;

public class ConditionClause<T> implements Condition<T>, Messager {
    private Condition<T> left;
    private Condition<T> right;
    private Operator operator;
    private String message;

    public ConditionClause(Condition left, Condition right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.message = DEFAULT_MESSAGE;
    }

    public ConditionClause(Condition left, Condition right, Operator operator, String message) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.message = message;
    }

    public Condition<T> getLeft() {
        return left;
    }

    public void setLeft(Condition<T> left) {
        this.left = left;
    }

    public Condition<T> getRight() {
        return right;
    }

    public void setRight(Condition<T> right) {
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public boolean evaluate(T t) {
        return evaluateClause(t, left, right, operator);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
