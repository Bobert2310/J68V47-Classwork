package Lesson7;

import java.util.Scanner;

public class Lesson7Exercise1_MightyMenu {

    public static void ShowMenu() {
        System.out.print("Hello and Welcome to the Magic Menu,\n\nPlease Select one of the options below by typing the corresponding number\n1. Say \"Hello\"\n2. Tell me the time\n3. Tell me a joke\n4. Quit\n");
    }
    public static int Answer = 0;
    public static void getOption() {
        Scanner input = new Scanner(System.in);
        Answer = input.nextInt();
    }
    public static void option1() {
        System.out.print("Hello\n\n");
    }
    public static void option2() {
        System.out.print("Time\n\n");
    }
    public static void option3() {
        System.out.print("Joke\n\n");
    }
    public static void main(String[] args) {
        while (Answer != 4) {
            ShowMenu();
            getOption();
            if (Answer == 1) {
                option1();
            } else if (Answer == 2) {
                option2();
            } else if (Answer == 3) {
                option3();
            } else if (Answer == 4) {
                System.out.print("Bye!\n\n");
            } else {
                System.out.print("Please Enter a Valid Option\n\n");
            }
        }
    }
}
