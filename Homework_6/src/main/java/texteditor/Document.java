package texteditor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, CharacterStyle style) {
        characters.add(new Character(c, style));
    }

    public List<Character> getCharacter() {
        return characters;
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write("Character: " + character.getCharacter() +
                        ", Font: " + character.getStyle().getFont() +
                        ", Color: " + character.getStyle().getColor() +
                        ", Size: " + character.getStyle().getSize());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        characters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}