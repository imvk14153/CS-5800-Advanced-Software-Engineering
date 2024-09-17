package Question4;

public class Driver {
    public static void main(String[] args) {

        Folder phpDemo1 = new Folder("php_demo1");

        Folder sourceFiles = new Folder("Source Files");

        Folder phalcon = new Folder(".phalcon");
        sourceFiles.addSubFolder(phalcon);

        Folder app = new Folder("app");
        app.addSubFolder(new Folder("config"));
        app.addSubFolder(new Folder("controllers"));
        app.addSubFolder(new Folder("library"));
        app.addSubFolder(new Folder("migrations"));
        app.addSubFolder(new Folder("models"));
        app.addSubFolder(new Folder("views"));
        sourceFiles.addSubFolder(app);

        Folder cache = new Folder("cache");
        sourceFiles.addSubFolder(cache);

        Folder publicFolder = new Folder("public");
        publicFolder.addFile(new File(".htaccess"));
        publicFolder.addFile(new File(".htrouter.php"));
        publicFolder.addFile(new File("index.html"));
        sourceFiles.addSubFolder(publicFolder);

        phpDemo1.addSubFolder(sourceFiles);

        Folder includePath = new Folder("Include Path");
        phpDemo1.addSubFolder(includePath);

        Folder remoteFiles = new Folder("Remote Files");
        phpDemo1.addSubFolder(remoteFiles);

        // Printing full structure
        System.out.println("Full Structure:");
        phpDemo1.print(0);

        // Deleting app folder
        sourceFiles.getSubFolders().removeIf(subFolder -> subFolder.getName().equals("app"));
        System.out.println("\nFull Structure After Deleting 'app' Folder:");
        phpDemo1.print(0);

        // Deleting public folder
        sourceFiles.getSubFolders().removeIf(subFolder -> subFolder.getName().equals("public"));
        System.out.println("\nFull Structure After Deleting 'public' Folder:");
        phpDemo1.print(0);
    }
}
