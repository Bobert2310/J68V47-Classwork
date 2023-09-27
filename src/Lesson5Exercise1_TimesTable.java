import java.util.Scanner;

public class Lesson5Exercise1_TimesTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int TTNumber = input.nextInt();
        System.out.println();

            for(int count=TTNumber; count<=TTNumber*10; count+=TTNumber)
            {
            System.out.println(count);
            }

    }
}