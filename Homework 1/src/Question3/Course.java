package Question3;

public class Course {
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    private String instructorFirstName;
    private String instructorLastName;
    private String instructorOfficeNumber;

    private String textbookTitle;
    private String textbookAuthor;
    private String textbookPublisher;

    public Course(String courseName, Instructor instructor, Textbook textbook) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.instructorFirstName = instructor.getFirstName();
        this.instructorLastName = instructor.getLastName();
        this.instructorOfficeNumber = instructor.getOfficeNumber();
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
        this.textbookTitle = textbook.getTitle();
        this.textbookAuthor = textbook.getAuthor();
        this.textbookPublisher = textbook.getPublisher();
    }

    public void print() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("\nInstructor:\n");
        System.out.println("Instructor Full Name: " + instructorFirstName + " " + instructorLastName);
        System.out.println("\nTextbook:\n");
        System.out.println("Textbook Title: " + textbookTitle + ", Author: " + textbookAuthor);
    }
}