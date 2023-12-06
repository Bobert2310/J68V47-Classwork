package Lesson12;

public class Lesson12Exercise1_Student {
        public int id = 30088036;
        public String firstName = "Scott";
        public String surname = "Robson";

        public boolean present = false;
        public static void displayStudent(Student thisStudent){
                System.out.format("(%d) %s %s %n",thisStudent.id, thisStudent.firstName, thisStudent.surname);
        }
        public static void main(String[] args) {
                // create student object and display
                Student student1 = new Student();
                displayStudent(student1);
                // update values of student object and display

        }


}
