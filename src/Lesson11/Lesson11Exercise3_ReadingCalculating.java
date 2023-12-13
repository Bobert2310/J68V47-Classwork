package Lesson11;

import java.io.*;
import java.util.Scanner;

public class Lesson11Exercise3_ReadingCalculating {
    public static void main(String[] args) {
        try ( Scanner in = new Scanner( new FileReader("FileOfIntegers.txt") ) ) {
            double Sum = 0;
            while ( in.hasNextDouble()) {
                double num = in.nextDouble();
                Sum += num;
            }

            System.out.println("Sum of all numbers in this file: " + Sum);
        } catch (IOException e) {
            System.out.println("Error occurred reading from file: " + e.toString());
        }
    }
}
