package texteditor;

import java.util.HashMap;

public class CharacterFactory {
    private final HashMap<CharacterStyle, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getStyle(String font, String color, int size) {
        CharacterStyle style = new CharacterStyle(font, color, size);
        styles.putIfAbsent(style, style); // Only if the style doesn't already exist
        return styles.get(style);
    }
}