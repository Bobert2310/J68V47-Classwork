import java.io.*;

public class Lesson11Exercise4_CompareFiles {
    public static void main(String[] args) {
        String line = "FileCompare1.txt";
        String line2 = "FileCompare2.txt";
        try (BufferedReader reader1 = new BufferedReader(new FileReader("FileCompare1.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("FileCompare2.txt"))) {

            while ((line = reader1.readLine()) != null && (line2 = reader2.readLine()) != null)
            {
                if (!line.equals(line2)) {
                    System.out.println("Files are different");
                    System.out.println("File 1: " + line);
                    System.out.println("File 2: " + line2);
                } else {
                    System.out.println("Files are identical");
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred reading the file: " + e.toString());
        }
    }
}
