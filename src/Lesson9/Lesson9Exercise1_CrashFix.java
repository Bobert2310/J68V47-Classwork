package Lesson9;

import java.util.Scanner;
public class Lesson9Exercise1_CrashFix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String response = scanner.nextLine();

        for (int i = response.length(); i >= 1; i--) {
            String character = response.substring(0, 1);
            response = response.substring(1, response.length());
            System.out.print(character);
        }
    }
}
