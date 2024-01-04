package RoadCast;

import java.util.Scanner;

public class RoadCast1 {
    private static String location = "Default Location"; // Default location value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcomeScreen();
        waitForAnyKey();

        boolean exitProgram = false;

        while (!exitProgram) {
            displayLocationInput();
            setLocation(scanner.nextLine());

            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    displayCurrentRoadConditions();
                    int roadConditionChoice = getUserChoice(scanner);

                    switch (roadConditionChoice) {
                        case 1:
                            printReport();
                            break;
                        case 2:
                            // Back to the main menu
                            break;
                        case 3:
                            exitProgram = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                    break;

                case 2:
                    changeLocation(scanner);
                    break;

                case 3:
                    printReport();
                    break;

                case 4:
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        System.out.println("Thank you for using RoadCast.");
        System.out.println("Goodbye.");
        scanner.close();
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome to RoadCast!\nPress any key to continue.");
    }

    private static void waitForAnyKey() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayLocationInput() {
        System.out.println("\n[Screen 2: Preferable layout for location]\nPlease enter your location:\n");
    }

    private static void setLocation(String newLocation) {
        location = newLocation;
    }

    private static void displayMenu() {
        System.out.println("\n[Screen 3: Menu Layout]\nMenu\n1. Current Road Conditions\n2. Change Location\n3. Print Report\n4. Exit\n");
    }

    private static void displayCurrentRoadConditions() {
        System.out.println("\n[Option 1 selected: Current Road Conditions]\nHere are the current road conditions for " + location + ":\n");
        System.out.println("\"Dry/Wet/Ice/Snow\"");
        System.out.println("(Recent weather)");
        System.out.println("\"%percentage of wetness%\"");
        System.out.println("(Recommendations for travel)\n");
        System.out.println("1. Print\n2. Back\n3. Exit\n");
    }

    private static void changeLocation(Scanner scanner) {
        System.out.println("\n[Option 2 selected: Change Location]\nPlease enter your new location:\n");
        setLocation(scanner.nextLine());
    }

    private static void printReport() {
        String reportFileName = "RoadcastReport1";
        System.out.println("\n[Option 3 selected: Print Report]\nA Report has been saved as " + reportFileName + "\n");
        displayCurrentRoadConditions();
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }
}
