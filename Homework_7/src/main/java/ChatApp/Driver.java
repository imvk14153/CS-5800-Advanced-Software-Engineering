package ChatApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        // Creating users
        User userA = new User(chatServer, "userA");
        User userB = new User(chatServer, "userB");
        User userC = new User(chatServer, "userC");

        System.out.println("\n=== Registering Users ===");
        // Registering users
        chatServer.registerUser(userA);
        chatServer.registerUser(userB);
        chatServer.registerUser(userC);

        System.out.println("\n=== Messaging ===");
        userA.sendMessage(new ArrayList<>(Arrays.asList(userB, userC)), "Hello, everyone!");
        userB.sendMessage(new ArrayList<>(Arrays.asList(userA)), "Hi, userA!");
        userC.sendMessage(new ArrayList<>(Arrays.asList(userA, userB)), "Hi, team!");

        System.out.println("\n=== Undo ===");
        userA.sendMessage(new ArrayList<>(Arrays.asList(userB)), "Hello, team!");
        printChatHistory(userA);
        userA.undoLastMessageSent();
        printChatHistory(userA);

        System.out.println("\n=== Block ===");
        userB.blockUser(userA);
        userA.sendMessage(new ArrayList<>(Arrays.asList(userB)), "Are you ignoring me?");

        System.out.println("\n=== Chat History ===");
        printChatHistory(userA);
        printChatHistory(userB);
        printChatHistory(userC);

        System.out.println("\n=== Unregister User ===");
        // Unregister userB
        chatServer.unregisterUser(userB);
        // Attempt to send a message to unregistered userB
        userA.sendMessage(new ArrayList<>(Arrays.asList(userB)), "Are you still there?");

        // Part 2 - Iterator
        System.out.println("\n=== Iterating over Chat History ===");
        System.out.println("\nMessages involving userA:");
        Iterator<Message> iterator = userA.iterator(userA);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void printChatHistory(User user) {
        System.out.println("\n🔍 Chat History for " + user.getUserName() + ":");
        ArrayList<Message> history = user.getChatHistory().getHistory();
        if (history.isEmpty()) {
            System.out.println("No messages found for " + user.getUserName() + ".");
        } else {
            for (Message message : history) {
                System.out.println(message);
            }
        }
    }
}