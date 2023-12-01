import java.io.*;
import java.util.Scanner;

public class Lesson11Exercise1_NumberFile {
    public static void main(String[] args) {
        try {
            FileWriter out = new FileWriter ("output.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int TTNumber = input.nextInt();

        for (int count2 = 1; count2 <= 10; count2++) {
            int count = count2 * TTNumber;
            System.out.println(count2 + " x " + TTNumber + " = " + count);
            out.write(count2 + " x " + TTNumber + " = " + count + "\n");
        }

            out.close();

        } catch (IOException e) {
            System.out.println("Error occurred writing to file: " + e.toString());
        }
    }
}