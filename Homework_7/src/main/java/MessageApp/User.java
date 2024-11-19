package MessageApp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements IterableByUser {

    private ChatServer chatServer;
    private String userName;
    private ChatHistory chatHistory;
    private MessageMemento memento;

    public User(ChatServer chatServer, String userName) {
        this.chatServer = chatServer;
        this.userName = userName;
        this.chatHistory = new ChatHistory();
        this.memento = new MessageMemento(null, null);
    }

    public String getUserName() {
        return userName;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void sendMessage(ArrayList<User> recipients, String content) {
        Message message = new Message(this, recipients, content);
        saveLastMessageSent(message);
        if (chatServer.sendMessage(message)) {
            chatHistory.addMessageToHistory(message);
        }
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessageToHistory(message);
        System.out.println("📨 " + userName + " received: \"" + message.getMessageContent() + "\" from " + message.getSender().getUserName());
    }

    public void saveLastMessageSent(Message message) {
        memento.setMessageMemento(Timestamp.valueOf(message.getTimestamp()), message.getMessageContent());
    }

    public void undoLastMessageSent() {
        Message lastSentMessage = null;

        // Find the last sent message by this user
        for (int i = chatHistory.getHistory().size() - 1; i >= 0; i--) {
            if (chatHistory.getHistory().get(i).getSender().equals(this)) {
                lastSentMessage = chatHistory.getHistory().get(i);
                chatHistory.getHistory().remove(i);
                break;
            }
        }

        if (lastSentMessage == null) {
            System.out.println("⚠️ No message to undo for " + userName);
            return;
        }

        // Notify recipients to remove this message from their history
        for (User recipient : lastSentMessage.getRecipients()) {
            Message finalLastSentMessage = lastSentMessage;
            recipient.getChatHistory().getHistory().removeIf(
                    msg -> msg.equals(finalLastSentMessage)
            );
        }

        System.out.println("✅ The last message by " + userName + " was successfully undone.");
    }


    public void blockUser(User blockedUser) {
        chatServer.blockUser(this, blockedUser);
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
