package orozco.condition.functional.interfaces;

@FunctionalInterface
public interface ConditionSupplier<T> {
    boolean supply(T t);
}
