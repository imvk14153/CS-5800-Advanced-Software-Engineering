package Question4;

public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(int indentLevel) {
        System.out.println("  ".repeat(indentLevel) + "File: " + name);
    }
}