package Question4;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files;
    private List<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addSubFolder(Folder folder) {
        subFolders.add(folder);
    }

    public void print(int indentLevel) {
        System.out.println("  ".repeat(indentLevel) + "Folder: " + name);
        for (File file : files) {
            file.print(indentLevel + 1);
        }
        for (Folder folder : subFolders) {
            folder.print(indentLevel + 1);
        }
    }
}