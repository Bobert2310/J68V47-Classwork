package Lesson3;

import java.util.Scanner;

public class Lesson3Exercise2_Quiz {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the capital of Spain:");
        String Answer1 = input.nextLine();

        System.out.println(Answer1.toLowerCase().contains("madrid")); //true

        System.out.println("What is the capital of the UK:");
        String Answer2 = input.nextLine();

        System.out.println(Answer2.toLowerCase().contains("london")); //true

        System.out.println("What is the capital of Italy:");
        String Answer3 = input.nextLine();

        System.out.println(Answer3.toLowerCase().contains("rome")); //true
    }
}