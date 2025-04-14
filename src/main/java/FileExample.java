import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//For reading/writing large files, you can use BufferedReader, BufferedWriter, or Files class (Java NIO).
//Always close the file streams in finally or use try-with-resources.
//Handle exceptions properly.

public class FileExample {
    public static void main(String[] args) {
        File file = new File("example.txt");

        try {
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter("example.txt");
                writer.write("Hello, this is a sample file.");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Size: " + file.length() + " bytes");
//            File Name: example.txt
//            Path: C:\Users\sange\Desktop\JAVA-FSD\hands-on\example.txt
//            Writable: true
//            Readable: true
//            Size: 29 bytes
        }

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

    }
}
