package Lesson11;

import java.io.*;
public class Lesson11Exercise2_ReadingFiles {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Error occurred reading the file: " + e.toString());
        }
    }
}