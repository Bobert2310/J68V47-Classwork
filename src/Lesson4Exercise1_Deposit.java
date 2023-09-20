import java.util.Scanner;
public class Lesson4Exercise1_Deposit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String name = input.nextLine();

        System.out.println("Enter your surname:");
        String surname = input.nextLine();

        double Remainder;
        System.out.println("Enter the total value of your order:");
        double OrderV = input.nextDouble();

        System.out.println("Enter the amount you wish to pay as deposit:");
        double PAY = input.nextDouble();

        System.out.println("Customer: " + name.substring(0,1).toUpperCase() + (" ") + surname.substring(0,1).toUpperCase() + surname.substring(1,surname.length()).toLowerCase());

        Remainder = OrderV - PAY;
        System.out.format("\nOrder Total..£%.2f", OrderV);
        System.out.format("\nDeposit Paid..£%.2f", PAY);
        System.out.format("\nRemainder..£%.2f", Remainder);
        if (OrderV > 100) {
            System.out.println("\nYou get a free toaster!");
        }
        System.out.println("Have a nice day");
    }

}
