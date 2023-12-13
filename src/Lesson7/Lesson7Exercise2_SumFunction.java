package Lesson7;

import java.util.Scanner;
public class Lesson7Exercise2_SumFunction {
    public static double Answer;
    public static double N1;
    public static double N2;
    public static void calculateSum() {
        Answer = N1 + N2;
        System.out.print("The sum of " + N1 + " + " + N2);
        System.out.format(" = %.2f",Answer);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the First Number ");
        N1 = input.nextDouble();

        System.out.print("Enter the Second Number ");
        N2 = input.nextDouble();

        input.nextLine();

        calculateSum();
    }
}
