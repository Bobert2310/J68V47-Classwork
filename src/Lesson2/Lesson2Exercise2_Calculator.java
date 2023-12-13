package Lesson2;

import java.util.Scanner;
public class Lesson2Exercise2_Calculator {
        public static void main(String[] args) {
            double Answer;
            Scanner input = new Scanner(System.in);
            System.out.print("First Number ");
            double N1 = input.nextDouble();

            System.out.print("Second Number ");
            double N2 = input.nextDouble();

            input.nextLine();

            System.out.print("+, -, * or /: ");
            String Type = input.nextLine();

            if (Type.equals("+")) {
                Answer = N1 + N2;
                System.out.println(Answer);
            }
            else if (Type.equals("-")) {
                Answer = N1 - N2;
                System.out.println(Answer);
            }
            else if (Type.equals("*")) {
                Answer = N1 * N2;
                System.out.println(Answer);
            }
            else if (Type.equals("/")) {
                Answer = N1 / N2;
                System.out.println(Answer);
            }
        }
}
