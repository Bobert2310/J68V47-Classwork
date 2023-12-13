import java.util.Scanner;

public class RoadCast {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Answer = 0;
        while (Answer != 4) {
            System.out.print("Hello and Welcome to RoadCast,\n\nPress any key to continue\n1. Say \"Hello\"\n2. Tell me the time\n3. Tell me a joke\n4. Quit\n");
            System.out.print("Please Enter Your Location");
            String Location = input.nextLine();
            System.out.print("Main Menu\n\nPlease Select one of the options below by typing the corresponding number or by typing the words\n1. Current Road Conditions \"Hello\"\n2. Change Location\n3. Print Report\n4. Quit\n");

            Answer = input.nextInt();
            if (Answer == 1) {
                System.out.print("Hello\n\n");
            } else if (Answer == 2) {
                System.out.print("Time\n\n");
            } else if (Answer == 3) {
                System.out.print("Joke\n\n");
            } else if (Answer == 4) {
                System.out.print("Bye!\n\n");
            } else {
                System.out.print("Please Enter a Valid Option\n\n");
            }
        }
    }
}
