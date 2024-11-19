package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistory implements IterableByUser {

    private ArrayList<Message> history;

    public ChatHistory() {
        this.history = new ArrayList<>();
    }

    public void addMessageToHistory(Message message) {
        history.add(message);
    }

    public void removeLastSentMessageFromHistory(User user) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).getSender().equals(user)) {
                history.remove(i);
                break;
            }
        }
    }

    public ArrayList<Message> getHistory() {
        return history;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(userToSearchWith);
    }
}