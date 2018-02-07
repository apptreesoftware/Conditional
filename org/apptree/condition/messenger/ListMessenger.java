package apptree.condition.messenger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMessenger implements Messenger {
    private List<String> data;
    public ListMessenger() {
        data = new ArrayList<>();
    }

    @Override
    public void send(String value) {
        data.add(value);
    }

    @Override
    public String getMessage(int index) {
        if(data.size() == 0) {
            return "";
        }
        return data.get(index);
    }

    @Override
    public Collection<String> getMessages() {
        return data;
    }
}
