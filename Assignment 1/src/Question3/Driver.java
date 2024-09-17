package Question3;

public class Driver {
    public static void main(String[] args) {
        Course course = new Course("Advanced Software Engineering", 2, 2);

        course.setInstructor(0, new Instructor("Nima", "Davarpanah", "3-2636"));
        course.setInstructor(1, new Instructor("Jane", "Doe", "3-2637"));

        course.setTextbook(0, new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall"));
        course.setTextbook(1, new Textbook("Effective Java", "Joshua Bloch", "Addison-Wesley"));

        course.print();
    }
}