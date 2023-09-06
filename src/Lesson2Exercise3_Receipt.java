import java.util.Scanner;

public class Lesson2Exercise3_Receipt {

        public static void main(String[] args) {
            double Answer;
            Scanner input = new Scanner(System.in);
            System.out.print("First Item ");
            double N1 = input.nextDouble();

            System.out.print("Second Item ");
            double N2 = input.nextDouble();

            System.out.print("Third Item ");
            double N3 = input.nextDouble();

            input.nextLine();

            Answer = N1 + N2 + N3;
            System.out.println("SUBTOTAL..£");
            System.out.println(Answer);

        }
    }

}
