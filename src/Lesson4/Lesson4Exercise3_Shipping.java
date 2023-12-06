package Lesson4;

import java.util.Scanner;

public class Lesson4Exercise3_Shipping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double Total;
        double Shipping = 10;
        System.out.println("Enter the total purchase amount: ");
        double PurA = input.nextDouble();

        System.out.format("\nShipping Cost is: £%.2f", Shipping);
        Total = PurA;
        if (PurA < 50) {

            Total = PurA + Shipping;

        }

        System.out.format("\nyour final total is: £%.2f", Total);

    }
}
