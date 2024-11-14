import java.util.Arrays;
import java.util.List;

public class BookDriver {
    public static void main(String[] args) {
        // BookShallowCopy (Part 2)
        List<String> chaptersForBook1 = Arrays.asList("Meaningful Names", "Functions", "Comments", "Formatting");
        BookShallowCopy book1 = new BookShallowCopy("Clean Code", "Robert C. Martin", chaptersForBook1);
        BookShallowCopy clonedBook1 = book1.clone();
        book1.getChapters().set(0, "Naming Conventions"); // Modifying chapters in the original book
        book1.getChapters().set(1, "Methods"); // Modifying chapters in the original book
        System.out.println("Original Book " + book1);
        System.out.println("Cloned Book " + clonedBook1);
        System.out.println("===================================================================================");

        // BookDeepCopy (Part 3)
        List<String> chaptersForBook2 = Arrays.asList("Verbal Diagnostic Test", "Math Diagnostic Test", "Text Completions");
        BookDeepCopy book2 = new BookDeepCopy("5 lb. GRE", "Manhattan Prep", chaptersForBook2);
        BookDeepCopy clonedBook2 = book2.clone();
        book2.getChapters().set(0, "Verbal Aptitude"); // Modifying chapters in the original book
        book2.getChapters().set(1, "Math Aptitude"); // Modifying chapters in the original book
        System.out.println("Original Book " + book2);
        System.out.println("Cloned Book " + clonedBook2);
    }
}
