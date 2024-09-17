package Question3;

public class Course {
    private String courseName;
    private Instructor[] instructors;
    private Textbook[] textbooks;

    public Course(String courseName, int numInstructors, int numTextbooks) {
        this.courseName = courseName;
        this.instructors = new Instructor[numInstructors];
        this.textbooks = new Textbook[numTextbooks];
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor[] getInstructors() {
        return instructors;
    }

    public Textbook[] getTextbooks() {
        return textbooks;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(int index, Instructor instructor) {
        if (index >= 0 && index < instructors.length) {
            instructors[index] = instructor;
        }
    }

    public void setTextbook(int index, Textbook textbook) {
        if (index >= 0 && index < textbooks.length) {
            textbooks[index] = textbook;
        }
    }

    public void print() {
        System.out.println("\nCourse Name: " + courseName +"\n");
        System.out.println("\nInstructors:\n");
        for (Instructor instructor : instructors) {
            if (instructor != null) {
                System.out.println("Instructor Name: " + instructor.getFirstName() + " " + instructor.getLastName() +
                        ", Office Number: " + instructor.getOfficeNumber());
            }
        }
        System.out.println("\nTextbooks:\n");
        for (Textbook textbook : textbooks) {
            if (textbook != null) {
                System.out.println("Textbook Title: " + textbook.getTitle() + ", Author: " + textbook.getAuthor() + ", Publisher: " + textbook.getPublisher());
            }
        }
    }
}