import java.io.*;
import java.util.Scanner;

public class Lesson11Exercise3_ReadingCalculating {
    public static void main(String[] args) {
        try ( Scanner in = new Scanner( new FileReader("FileOfIntegers.txt") ) ) {
            String text = in.nextLine();
            double num = in.nextDouble();
            while ( in.hasNextLine() ) {
                System.out.println( in.nextLine() );
            }

            System.out.println(text);
        } catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }
    }
}
