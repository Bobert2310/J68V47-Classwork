import java.util.Scanner;

public class Lesson2Exercise3_Receipt {

        public static void main(String[] args) {
            double Answer;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the Price of the First Item ");
            double N1 = input.nextDouble();

            System.out.print("Enter the Price of the Second Item ");
            double N2 = input.nextDouble();

            System.out.print("Enter the Price of the Third Item ");
            double N3 = input.nextDouble();

            input.nextLine();

            Answer = N1 + N2 + N3;
            System.out.format("\nItem 1..£%.2f", N1);
            System.out.format("\nItem 2..£%.2f", N2);
            System.out.format("\nItem 3..£%.2f", N3);
            System.out.format("\nSUBTOTAL..£%.2f", Answer);

        }
    }


