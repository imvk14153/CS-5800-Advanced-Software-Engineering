package ChatApp;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {

    private ArrayList<User> registeredUsers;
    HashMap<User, ArrayList<User>> blockedUsers;

    public ChatServer() {
        this.registeredUsers = new ArrayList<>();
        this.blockedUsers = new HashMap<>();
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
        blockedUsers.putIfAbsent(user, new ArrayList<>());
        System.out.println("✅ " + user.getUserName() + " is now part of the chat!");
    }

    public void unregisterUser(User user) {
        if (registeredUsers.contains(user)) {
            registeredUsers.remove(user);
            blockedUsers.remove(user);

            // Remove the user from other users' block lists
            for (ArrayList<User> blockList : blockedUsers.values()) {
                blockList.remove(user);
            }

            System.out.println("❌ " + user.getUserName() + " has been removed from the chat.");
        } else {
            System.out.println("❗ " + user.getUserName() + " is not registered. Unregister failed.");
        }
    }

    public boolean sendMessage(Message message) {
        User sender = message.getSender();
        boolean success = true;

        for (User recipient : message.getRecipients()) {
            if (registeredUsers.contains(recipient)) {
                if (!blockedUsers.get(recipient).contains(sender)) {
                    System.out.println(message);
                    recipient.receiveMessage(message);
                } else {
                    System.out.println("❌ Message from " + sender.getUserName() + " to " + recipient.getUserName() + " was blocked.");
                    success = false;
                }
            } else {
                System.out.println("❗ " + recipient.getUserName() + " is not registered. Message failed.");
                success = false;
            }
        }

        return success;
    }

    public void blockUser(User blocker, User blocked) {
        blockedUsers.get(blocker).add(blocked);
        System.out.println("🚫 " + blocker.getUserName() + " blocked " + blocked.getUserName() + ".");
    }
}
