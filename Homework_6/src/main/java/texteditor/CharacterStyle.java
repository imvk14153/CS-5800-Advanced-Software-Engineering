package texteditor;

import java.util.Objects;

public class CharacterStyle {
    private final String font;
    private final String color;
    private final int size;

    public CharacterStyle(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterStyle newStyle = (CharacterStyle) o;
        return size == newStyle.size && font.equals(newStyle.font) && color.equals(newStyle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, color, size);
    }
}