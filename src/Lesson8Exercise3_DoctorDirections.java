import java.util.*;

public class Lesson8Exercise3_DoctorDirections {

    public static String[] addToStringArray(String[] directions, String newString) {
        String[] newArray = Arrays.copyOf(directions, directions.length + 1);
        newArray[directions.length] = newString; // new line should be inserted into position 4
        return newArray;
    }

    public static String[] removeLastElement(String[] directions) {
        return Arrays.copyOf(directions, directions.length - 1);
    }

    public static void main(String[] args) {
        // Set up the directions array
        String[] directions = {"Start by exiting the building you are currently in and turning left onto the main road.",
                "Walk down the road for two blocks until you reach the traffic lights.",
                "At the traffic lights, turn right onto Oak Street.",
                "Follow Oak Street for one block then turn left onto Elm Street.",
                "Walk to the end of Elm Street. Your doctor's office will be the third building on the right side of the road.",
                "Enter through the front door of the office. Let the receptionist know you have arrived for your appointment.",
                "Take a seat in the waiting room. The doctor will call your name when it's time to be seen. You've arrived!"
        };

        int step = 1;
        System.out.println("\nDirections:");
        for (String Direction : directions) {
            System.out.format("%d. %s %n", step, Direction);
            step++;
        }

        step = 1;
        directions = addToStringArray(directions, "After turning onto Elm Street, walk past the grocery store on your right.");

        System.out.println("\nModified Directions:");
        for (String newDirection : directions) {
            System.out.format("%d. %s %n", step, newDirection);
            step++;
        }

        directions = removeLastElement(directions);

        step = 1;

        System.out.println("\nFinal Directions:");
        for (String finalDirection : directions) {
            System.out.format("%d. %s %n", step, finalDirection);
            step++;
        }
    }
}
