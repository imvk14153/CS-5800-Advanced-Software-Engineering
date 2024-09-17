package Question3;

public class Driver {
    public static void main(String[] args) {

        Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook textbook = new Textbook("Clean Code", "Robert C. Martin", "Pearson");

        Course course = new Course("Advanced Software Engineering", instructor, textbook);

        course.setInstructor(instructor);
        course.setTextbook(textbook);

        course.print();
    }
}