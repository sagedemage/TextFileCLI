import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "create":
                /* Create file */
                try {
                    File text_file = new File(args[1]);
                    boolean create_file = text_file.createNewFile();

                    if (create_file) {
                        System.out.println("File created: " + text_file.getName());
                    }
                    else {
                        System.out.println("File already exists");
                    }
                }
                catch (IOException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
                break;
            case "write":
                /* Write text to the file */
                try {
                    FileWriter writer = new FileWriter(args[1]);
                    writer.write(args[2]);
                    writer.close();
                }
                catch (IOException e) {
                    System.out.println("An error occurred");
                    e.printStackTrace();
                }
                System.out.println("Successfully wrote to the file.");
                break;
            case "read":
                /* Read a file */
                try {
                    File text_file = new File(args[1]);
                    Scanner reader = new Scanner(text_file);
                    while (reader.hasNextLine()) {
                        String line = reader.nextLine();
                        System.out.println(line);
                    }
                    reader.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("An error occurred");
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Error");
        }
    }
}