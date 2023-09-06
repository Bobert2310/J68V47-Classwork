import java.util.Scanner;
public class Lesson2Exercise2_Calculator {

        public static void main(String[] args) {
            int Answer;
            Scanner input = new Scanner(System.in);
            System.out.print("First Number ");
            int N1 = input.nextInt();

            System.out.print("Second Number ");
            int N2 = input.nextInt();

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
