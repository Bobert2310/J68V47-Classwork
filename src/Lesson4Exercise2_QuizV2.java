import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import java.util.Scanner;

public class Lesson4Exercise2_QuizV2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the capital of Spain:");
        String Answer1 = input.nextLine();

        System.out.println(Answer1.toLowerCase().contains("madrid")); //true
        if (Answer1.equals(false));
        System.out.println("Sorry, the correct answer is Madrid.");

        System.out.println("What is the capital of the UK:");
        String Answer2 = input.nextLine();

        System.out.println(Answer2.toLowerCase().contains("london")); //true
        if (Answer2.equals(false));
        System.out.println("Sorry, the correct answer is London.");

        System.out.println("What is the capital of Italy:");
        String Answer3 = input.nextLine();

        System.out.println(Answer3.toLowerCase().contains("rome")); //true
        if (Answer3.equals(false));
        System.out.println("Sorry, the correct answer is Rome.");
    }
}
