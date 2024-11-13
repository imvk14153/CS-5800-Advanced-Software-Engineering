package texteditor;

public class Character {
    private final char character;
    private final CharacterStyle style;

    public Character(char character, CharacterStyle style) {
        this.character = character;
        this.style = style;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterStyle getStyle() {
        return style;
    }
}