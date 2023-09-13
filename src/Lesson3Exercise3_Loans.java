import java.util.Scanner;

public class Lesson3Exercise3_Loans {
    public static void main(String[] args) {
        double M;
        Scanner input = new Scanner(System.in);
        System.out.print("Loan amount: ");
        double L = input.nextDouble();

        System.out.print("Interest rate (APR %): ");
        double j = input.nextDouble();

        System.out.print("Number of years: ");
        double n = input.nextDouble();
        input.nextLine();

        M = L * (((j/100)/12) / (1 - Math.pow(1 + ((j/100)/12), -(n*12))));


        System.out.print("Monthly payment for this loan = " + M);

    }
}
