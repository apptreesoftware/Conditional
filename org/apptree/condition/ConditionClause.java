package apptree.condition;

import apptree.condition.messenger.Messenger;

public class ConditionClause<T> implements Condition<T> {
    private Condition<T> left;
    private Condition<T> right;
    private Operator operator;

    public ConditionClause(Condition left, Condition right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
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
    public boolean evaluate(T t, Messenger messenger) {
        return evaluateClause(t, left, right, operator, messenger);
    }
}
