public class Lesson8Exercise1_StudentNames {

    public static void main(String[] args) {
        String[] Students = {"Lee", "Scott", "Alex", "Ross", "Wiktor"};
        System.out.println(Students[0]);
        System.out.println(Students[4]);
        System.out.println(Students[Students.length-1]);
        System.out.println( Students.length );
        System.out.format("The number of items in the array is: %d",Students.length);
    }
}
