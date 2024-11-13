package texteditor;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        Document doc = new Document();

        CharacterStyle style1 = factory.getStyle("Arial", "Red", 12);
        CharacterStyle style2 = factory.getStyle("Calibri", "Blue", 14);
        CharacterStyle style3 = factory.getStyle("Verdana", "Black", 16);
        CharacterStyle style4 = factory.getStyle("Roboto", "Green", 12);
        CharacterStyle style5 = factory.getStyle("Times", "Blue", 22);

        String text = "HelloWorldCS5800";
        CharacterStyle[] styles = {style1, style2, style3, style4, style5};

        for (int i = 0; i < text.length(); i++) {
            doc.addCharacter(text.charAt(i), styles[i % styles.length]);
        }

        // Save document
        try {
            doc.saveToFile("Document1.txt");
        } catch (IOException e) {
            System.out.println("The following exception occurred while saving the document: " + e);
        }

        // Load document
        try {
            doc.loadFromFile("Document1.txt");
        } catch (IOException e) {
            System.out.println("The following exception occurred while loading the document: " + e);
        }
    }
}