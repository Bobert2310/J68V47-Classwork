package RoadCast;

import java.util.Scanner;
public class RoadCast {
    private static String location = "Default Location"; // Default location value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcomeDialog();
        waitForAnyKey();

        boolean exitProgram = false;

        while (!exitProgram) {
            displayLocation();
            setLocation(scanner.nextLine());

            if (!isValidLocation()) {
                System.out.println("Error: Invalid symbols or numbers. Please use only characters.");
                continue;
            }

            if (!checkLocationWithWeatherAPI()) {
                System.out.println("Could not find location. Please try again or enter another location.");
                continue;
            }

            displayMainMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    roadConditionsMenu(scanner);
                    break;

                case 2:
                    changeLocation(scanner);
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

    private static void displayLocation() {
        System.out.println("\nPlease enter your location:");
    }

    private static void setLocation(String newLocation) {
        location = newLocation;
    }

    private static boolean isValidLocation() {
        // Implement validation logic for valid characters in the location
        // For simplicity, assuming all characters are valid
        return true;
    }

    private static boolean checkLocationWithWeatherAPI() {
        // Implement logic to check if location is available with weather API
        // For simplicity, assuming the location is always valid
        return true;
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("Please type the option you'd like or the corresponding number");
        System.out.println("1. Road Conditions\n 2. Change Location\n 3. Print/Save Report\n 4. Exit");
    }

    private static void roadConditionsMenu(Scanner scanner) {
        System.out.println("\nHere are the current road conditions for " + location + ":");
        // Implement fetching weather information and displaying road conditions
        System.out.println("1. Print\n 2. Back\n 3. Exit");
        int roadConditionChoice = getUserChoice(scanner);

        switch (roadConditionChoice) {
            case 1:
                printSaveReport();
                break;
            case 2:
                // Back to the main menu
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Error: No option was selected. Please try again.");
        }
    }

    private static void changeLocation(Scanner scanner) {
        System.out.println("\nChanging Location");
        setLocation(scanner.nextLine());
    }

    private static void printSaveReport() {
        System.out.println("\nSaving Current Report to File");
        // Implement logic to run road conditions segment and write output to file
        System.out.println("Your Report has been saved as _______");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void waitForAnyKey() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
