import java.util.ArrayList;
import java.util.List;

class BookDeepCopy implements Cloneable {
    private String title;
    private String author;
    private List<String> chapters;

    public BookDeepCopy(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = new ArrayList<>(chapters);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public List<String> getChapters() { return chapters; }
    public void setChapters(List<String> chapters) { this.chapters = chapters; }

    @Override
    public BookDeepCopy clone() {
        try {
            BookDeepCopy copy = (BookDeepCopy) super.clone();
            copy.chapters = new ArrayList<>(this.chapters);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "(Deep Copy) \nTitle: " + title + ", Author: " + author + ", Chapters: " + chapters + "\n";
    }
}