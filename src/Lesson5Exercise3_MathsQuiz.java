import java.util.Random;
import java.util.Scanner;


public class Lesson5Exercise3_MathsQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int Score = 0;

        for(int count=0; count<=10; count++) {
            int RN1 = random.nextInt(2) ;
            int RN2 = random.nextInt(2);
            int Answer = RN1 + RN2;

            System.out.println(RN1 + (" + ") + RN2 + " = ");
            int UserInput = input.nextInt();
            System.out.println();

            if (UserInput == Answer) {
                Score++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("Sorry, the answer was " + Answer);

            }
        }
        System.out.println("Thank you for playing");
        System.out.println("Your final score is " + Score + " Out of 10");
    }
}
