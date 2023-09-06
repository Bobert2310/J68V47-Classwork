import java.util.*;
public class Lesson2Exercise1_Short_Story {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("What is your hobby? ");
        String Hobby = input.nextLine();

        System.out.println("Hello " + name + ", I also like " + Hobby);
    }

}
