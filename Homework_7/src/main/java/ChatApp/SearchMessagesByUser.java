package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;

public class SearchMessagesByUser implements Iterator<Message> {

    private ArrayList<Message> chatHistory;
    private int index;
    private User userToSearchWith;

    public SearchMessagesByUser(User userToSearchWith) {
        this.chatHistory = userToSearchWith.getChatHistory().getHistory();
        this.index = 0;
        this.userToSearchWith = userToSearchWith;
        System.out.println("🔍 Searching messages involving " + userToSearchWith.getUserName() + "...");
    }

    @Override
    public boolean hasNext() {
        while (index < chatHistory.size()) {
            Message currentMessage = chatHistory.get(index);
            // Check if the current message involves the specified user
            if (currentMessage.getSender().equals(userToSearchWith) ||
                    currentMessage.getRecipients().contains(userToSearchWith)) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (hasNext()) {
            return chatHistory.get(index++);
        }
        return null;
    }
}