import java.util.Scanner;

public class Lesson4Exercise2_QuizV2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the capital of Spain:");
        String Answer1 = input.nextLine();

        if (Answer1.toLowerCase().contains("madrid")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Sorry, the correct answer is Madrid.");
        }
        System.out.println("What is the capital of the UK:");
        String Answer2 = input.nextLine();

        if (Answer2.toLowerCase().contains("london")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Sorry, the correct answer is London.");
        }

        System.out.println("What is the capital of Italy:");
        String Answer3 = input.nextLine();

        if (Answer3.toLowerCase().contains("rome")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Sorry, the correct answer is Rome.");
        }
    }
}
