package texteditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    private CharacterFactory factory;
    private Document document;

    @BeforeEach
    public void setUp() {
        factory = new CharacterFactory();
        document = new Document();
    }

    @Test
    public void testCharacterFactoryCreatesAndReuses() {
        CharacterStyle style1 = factory.getStyle("Arial", "Red", 12);
        CharacterStyle style2 = factory.getStyle("Arial", "Red", 12);
        CharacterStyle style3 = factory.getStyle("Verdana", "Black", 16);

        assertSame(style1, style2, "CharacterFactory should reuse the same instance for same styles.");
        assertNotSame(style1, style3, "CharacterFactory should create a new instance for different styles.");
    }

    @Test
    public void testAddCharacterToDocument() {
        CharacterStyle style = factory.getStyle("Roboto", "Green", 12);
        document.addCharacter('V', style);

        assertEquals(1, document.getCharacter().size());
        assertEquals('V', document.getCharacter().get(0).getCharacter());
        assertEquals(style, document.getCharacter().get(0).getStyle());
    }

    @Test
    public void testSaveToFile() throws IOException {
        CharacterStyle style1 = factory.getStyle("Times", "Red", 22);
        CharacterStyle style2 = factory.getStyle("Calibri", "Blue", 14);
        document.addCharacter('I', style1);
        document.addCharacter('K', style2);

        String filename = "testDocumentSave.txt";
        document.saveToFile(filename);

        // Check if file exists
        assertTrue(Files.exists(Paths.get(filename)), "File should be created after saving the document.");

        // Check file contents
        String content = Files.readString(Paths.get(filename));
        assertTrue(content.contains("Character: I, Font: Times, Color: Red, Size: 22"));
        assertTrue(content.contains("Character: K, Font: Calibri, Color: Blue, Size: 14"));

        Files.delete(Paths.get(filename));
    }

    @Test
    public void testLoadFromFile() throws IOException {
        String filename = "testDocumentLoad.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Character: R, Font: Verdana, Color: Black, Size: 16\n");
            writer.write("Character: A, Font: Calibri, Color: Blue, Size: 14\n");
        }

        document.loadFromFile(filename);

        // Check file contents
        String content = Files.readString(Paths.get(filename));
        assertTrue(content.contains("Character: R, Font: Verdana, Color: Black, Size: 16"));
        assertTrue(content.contains("Character: A, Font: Calibri, Color: Blue, Size: 14"));

        Files.delete(Paths.get(filename));
    }

    @Test
    public void testEqualsAndHashCode() {
        CharacterStyle style1 = new CharacterStyle("Calibri", "Blue", 14);
        CharacterStyle style2 = new CharacterStyle("Calibri", "Blue", 14);
        CharacterStyle style3 = new CharacterStyle("Roboto", "Green", 12);

        assertEquals(style1, style2, "Styles with same properties should be equal.");
        assertNotEquals(style1, style3, "Styles with different properties should be unequal.");

        assertEquals(style1.hashCode(), style2.hashCode(), "Hash for same character styles should be the same.");
        assertNotEquals(style1.hashCode(), style3.hashCode(), "Hash for different character styles should be different.");
    }

    @Test
    public void testSaveAndLoadDocument() throws IOException {
        CharacterStyle style1 = factory.getStyle("Arial", "Red", 12);
        CharacterStyle style2 = factory.getStyle("Calibri", "Blue", 14);
        document.addCharacter('V', style1);
        document.addCharacter('S', style2);

        // Save and load
        String filename = "SaveAndLoadTestDocument.txt";
        document.saveToFile(filename);
        document.loadFromFile(filename);

        Files.delete(Paths.get(filename));
    }
}