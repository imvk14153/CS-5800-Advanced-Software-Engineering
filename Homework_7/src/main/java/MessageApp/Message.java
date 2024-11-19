package MessageApp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Message {

    private User sender;
    private ArrayList<User> recipients;
    private LocalDateTime timestamp;
    private String messageContent;

    public Message(User sender, ArrayList<User> recipients, String messageContent) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = LocalDateTime.now();
        this.messageContent = messageContent;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public ArrayList<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<User> recipients) {
        this.recipients = recipients;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        String recipientNames = String.join(", ", recipients.stream().map(User::getUserName).toList());
        return "📩 " + sender.getUserName() + " sent at " + this.timestamp + " to [" + recipientNames + "]: \"" + this.messageContent + "\"";
    }
}