import java.util.Random;
import java.util.Scanner;

public class Lesson6Exercise3_MathsQuiz3Lives {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int Score = 0;
        int Lives = 3;

        for (int count = 0; count <= 10; count++) {
            int RN1 = random.nextInt(11);
            int RN2 = random.nextInt(11);
            int Answer = RN1 + RN2;

            System.out.println(RN1 + (" + ") + RN2 + " = ");
            int UserInput = input.nextInt();
            System.out.println();

            if (UserInput == Answer) {
                Score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Sorry, the answer was " + Answer + ".\nYou lost a life :(");
                Lives--;
                System.out.println("You have " + Lives + " lives left\n");


                if (Score == 10) {
                    System.out.println("Well Done! Perfect Score!");
                } else if (Lives == 0) {
                    System.out.println("Game Over! You ran out of lives.");
                } else {
                    System.out.println("Thank you for playing");
                }
                System.out.println("Your final score is " + Score + " Out of 10");
            }

            }
        }
    }
