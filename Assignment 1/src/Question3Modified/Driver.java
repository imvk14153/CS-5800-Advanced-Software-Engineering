package Question3Modified;

public class Driver {
    public static void main(String[] args) {
        Course course = new Course("Advanced Software Engineering");

        course.setInstructor(0, new Instructor("Nima", "Davarpanah", "3-2636"));
        course.setInstructor(1, new Instructor("James", "Bond", "3-2635"));

        course.setTextbook(0, new Textbook("Clean Code", "Robert C. Martin", "Pearson"));
        course.setTextbook(1, new Textbook("Design Patterns", "Erich Gamma", "Addison-Wesley Professional"));

        course.print();
    }
}
