package orozco.condition.functional.interfaces;

@FunctionalInterface
public interface FuncParam<T, R> {
    R supply(T t);
}
