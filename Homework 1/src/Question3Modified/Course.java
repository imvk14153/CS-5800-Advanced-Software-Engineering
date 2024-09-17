package Question3Modified;

public class Course {
    private String courseName;
    private Instructor[] instructors = new Instructor[2];
    private Textbook[] textbooks = new Textbook[2];

    private String[] instructorFirstNames = new String[2];
    private String[] instructorLastNames = new String[2];
    private String[] instructorOfficeNumbers = new String[2];

    private String[] textbookTitles = new String[2];
    private String[] textbookAuthors = new String[2];
    private String[] textbookPublishers = new String[2];

    public Course(String courseName) {
        this.courseName = courseName;
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
        this.instructors[index] = instructor;
        this.instructorFirstNames[index] = instructor.getFirstName();
        this.instructorLastNames[index] = instructor.getLastName();
        this.instructorOfficeNumbers[index] = instructor.getOfficeNumber();
    }

    public void setTextbook(int index, Textbook textbook) {
        this.textbooks[index] = textbook;
        this.textbookTitles[index] = textbooks[index].getTitle();
        this.textbookAuthors[index] = textbooks[index].getAuthor();
        this.textbookPublishers[index] = textbooks[index].getPublisher();
    }

    public void print() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("\nInstructors:\n");
        for (int i = 0; i < instructors.length; i++) {
            if(instructors[i] != null) {
                System.out.println("Instructor " + (i + 1) + " Full Name: " +
                        instructorFirstNames[i] + " " + instructorLastNames[i]);
            }
        }
        System.out.println("\nTextbooks:\n");
        for (int i = 0; i < textbooks.length; i++) {
            if (textbooks[i] != null) {
                System.out.println("Textbook " + (i + 1) + " Title: " +
                        textbookTitles[i] + ", Author: " + textbookAuthors[i]);
            }
        }
    }
}