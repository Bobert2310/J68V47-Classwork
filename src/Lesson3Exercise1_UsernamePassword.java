import java.util.Scanner;
public class Lesson3Exercise1_UsernamePassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String name = input.nextLine();

        System.out.println("Enter your surname:");
        String surname = input.nextLine();

        System.out.println("Enter your year of birth:");
        String yob = input.nextLine();

        System.out.println("Username:" + name.substring(0,1).toUpperCase() + surname.toLowerCase());

        System.out.println("Password:" + surname.substring(0,1).toLowerCase() + name.toUpperCase() + yob);

    }

}
