package RoadCast;

import java.util.Scanner;

public class RoadCastLayout {
    private static String[] locations = {"Aberdeen", "Glasgow", "Edinburgh", "London", "Paris"};
    private static String selectedLocation = "Default Location"; // Default location value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcomeDialog();
        waitForAnyKey();

        boolean exitProgram = false;

        while (!exitProgram) {
            displayLocationOptions();
            int locationChoice = getUserChoice(scanner, locations.length);

            if (locationChoice == 0) {
                exitProgram = true;
                continue;
            }

            selectedLocation = locations[locationChoice - 1];

            if (!checkLocationWithWeatherAPI()) {
                System.out.println("Could not find location. Please try again or choose another location.");
                continue;
            }

            displayMainMenu();
            int choice = getUserChoice(scanner, 4);

            switch (choice) {
                case 1:
                    roadConditionsMenu(scanner);
                    break;

                case 2:

                    break;

                case 3:
                    printSaveReport();
                    break;

                case 4:
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Error: No option was selected. Please try again.");
            }
        }

        System.out.println("Thank you for using RoadCast.");
        System.out.println("Goodbye.");
        scanner.close();
    }

    private static void displayWelcomeDialog() {
        System.out.println("Welcome to RoadCast");
        System.out.println("Press any key to continue");
    }

    private static void displayLocationOptions() {
        System.out.println("\nPlease choose your location:");

        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        System.out.println("0. Exit");
    }

    private static boolean checkLocationWithWeatherAPI() {


        return true;
    }

    private static void roadConditionsMenu(Scanner scanner) {
        System.out.println("\nHere are the current road conditions for " + selectedLocation + ":");
        // Implement fetching weather information and displaying road conditions
        System.out.println("1. Print\n 2. Back\n 3. Exit");
        int roadConditionChoice = getUserChoice(scanner, 3);

        switch (roadConditionChoice) {
            case 1:
                printSaveReport();
                break;
            case 2:

                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Error: No option was selected. Please try again.");
        }
    }

    private static void printSaveReport() {
        System.out.println("\nSaving Current Report to File");
        // Implement logic to run road conditions segment and write output to file
        System.out.println("Your Report has been saved as _______");
    }

    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = -1;

        while (choice < 0 || choice > maxChoice) {
            System.out.println("Please enter a number between 0 and " + maxChoice + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        return choice;
    }

    private static void waitForAnyKey() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Road Conditions");
        System.out.println("2. Change Location");
        System.out.println("3. Save Report");
        System.out.println("4. Exit");
    }
}
