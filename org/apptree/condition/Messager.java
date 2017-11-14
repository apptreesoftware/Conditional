package apptree.condition;

public interface Messager {
    default String getMessage() {
        return "";
    }
}
