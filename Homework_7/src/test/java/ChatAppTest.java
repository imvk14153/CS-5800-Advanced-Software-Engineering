package ChatApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChatAppTest {

    private ChatServer chatServer;
    private User userA, userB, userC;
    private ArrayList<User> recipients;
    private Message message;
    private MessageMemento memento;
    private ChatHistory chatHistory;

    @BeforeEach
    void setUp() {
        chatServer = new ChatServer();
        userA = new User(chatServer, "userA");
        userB = new User(chatServer, "userB");
        userC = new User(chatServer, "userC");
        recipients = new ArrayList<>(Arrays.asList(userB, userC));
        message = new Message(userA, recipients, "Hello World");
        memento = new MessageMemento(Timestamp.valueOf(LocalDateTime.now()), "Test Message");
        chatHistory = new ChatHistory();
    }

    @Test
    void testMessageConstructorAndToString() {
        assertNotNull(message.getTimestamp());
        assertEquals("Hello World", message.getMessageContent());
        assertEquals(userA, message.getSender());
        assertEquals(recipients, message.getRecipients());
        assertTrue(message.toString().contains("Hello World"));
    }

    @Test
    void testSetSenderAndRecipients() {
        message.setSender(userB);
        assertEquals(userB, message.getSender());

        ArrayList<User> newRecipients = new ArrayList<>(Arrays.asList(userA));
        message.setRecipients(newRecipients);
        assertEquals(newRecipients, message.getRecipients());
    }

    @Test
    void testSetMessageContent() {
        message.setMessageContent("Updated Content");
        assertEquals("Updated Content", message.getMessageContent());
    }

    @Test
    void testChatServerRegisterAndUnregisterUser() {
        chatServer.registerUser(userA);
        chatServer.registerUser(userB);

        chatServer.unregisterUser(userB);
        chatServer.unregisterUser(userC); // Not registered, should handle gracefully
    }

    @Test
    void testChatServerSendMessage() {
        chatServer.registerUser(userA);
        chatServer.registerUser(userB);
        chatServer.registerUser(userC);

        boolean success = chatServer.sendMessage(message);
        assertTrue(success);

        chatServer.unregisterUser(userB);
        success = chatServer.sendMessage(message);
        assertFalse(success);
    }

    @Test
    void testBlockUser() {
        chatServer.registerUser(userA);
        chatServer.registerUser(userB);

        userB.blockUser(userA);

        ArrayList<User> userBBlockList = chatServer.blockedUsers.get(userB);
        assertNotNull(userBBlockList, "Block list for userB should not be null.");
        assertTrue(userBBlockList.contains(userA), "userA should be in userB's block list.");

        Message blockedMessage = new Message(userA, new ArrayList<>(Arrays.asList(userB)), "Blocked Message");
        boolean success = chatServer.sendMessage(blockedMessage);

        assertFalse(success, "The message from userA to userB should have been blocked.");
    }

    @Test
    void testChatHistoryAddAndRemoveMessage() {
        chatHistory.addMessageToHistory(message);
        assertEquals(1, chatHistory.getHistory().size());

        chatHistory.removeLastSentMessageFromHistory(userA);
        assertEquals(0, chatHistory.getHistory().size());
    }

    @Test
    void testSaveAndUndoLastMessageSent() {
        userA.saveLastMessageSent(message);
        userA.undoLastMessageSent();
        assertTrue(userA.getChatHistory().getHistory().isEmpty());
    }

    @Test
    void testMessageMementoSettersAndGetters() {
        memento.setMessageContent("Updated Content");
        memento.setTimestamp(Timestamp.valueOf(LocalDateTime.now().minusDays(1)));

        assertNotNull(memento.getTimestamp());
        assertEquals("Updated Content", memento.getMessageContent());
    }

    @Test
    void testMessageMementoMethods() {
        String mementoState = memento.getMessageMemento();
        assertNotNull(mementoState);
        assertTrue(mementoState.contains("Test Message"));

        memento.setMessageMemento(Timestamp.valueOf(LocalDateTime.now()), "New State");
        assertEquals("New State", memento.getMessageContent());
    }
}