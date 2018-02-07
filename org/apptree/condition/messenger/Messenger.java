package apptree.condition.messenger;

import java.util.Collection;

public interface Messenger {
    void send(String value);
    String getMessage(int index);
    Collection<String> getMessages();
    boolean hasMessages();
}
