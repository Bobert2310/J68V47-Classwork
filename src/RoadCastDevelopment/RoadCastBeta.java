package RoadCastDevelopment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RoadCastBeta {

    private static final String API_KEY = "b9478773177fc290b1f32f1432103c10";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    private static String[] locations = {"Aberdeen", "Glasgow", "Edinburgh", "London", "Paris"};
    private static String selectedLocation = "No Location Selected"; // Default location value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayWelcomeDialog();
        waitForAnyKey();

        boolean exitProgram = false;

        while (!exitProgram) {
            displayMainMenu();
            int choice = getUserChoice(scanner, 5);

            switch (choice) {
                case 1:
                    changeLocationMenu(scanner);
                    break;

                case 2:
                    roadConditionsMenu(scanner);
                    break;

                case 3:
                    saveReportToFile();
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

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Set Location");
        System.out.println("2. Weather Report");
        System.out.println("3. Save Report");
        System.out.println("4. Exit");
    }

    private static void roadConditionsMenu(Scanner scanner) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\nHere is the current weather for " + selectedLocation + ":");
            displayReport();
            System.out.println("\nMenu:");
            System.out.println("1. Back to Main Menu\n2. Exit");
            int roadConditionChoice = getUserChoice(scanner, 2);

            switch (roadConditionChoice) {
                case 1:
                    backToMainMenu = true;
                    break;
                case 2:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Error: Invalid option. Please try again.");
            }
        }
    }

    private static void changeLocationMenu(Scanner scanner) {
        System.out.println("\nLocation Menu:");

        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        int locationChoice = getUserChoice(scanner, locations.length);

        if (locationChoice != 0) {
            selectedLocation = locations[locationChoice - 1];
            System.out.println("Location changed to: " + selectedLocation);
        }
    }

    private static void saveReportToFile() {
        String urlString = String.format("%s?q=%s&appid=%s", API_URL, selectedLocation, API_KEY);

        try {
            // Create URL object
            URL url = new URL(urlString);

            // Create HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and save raw response to file
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                // Create FileWriter and BufferedWriter
                FileWriter fileWriter = new FileWriter("RoadCastReport.txt");
                BufferedWriter writer = new BufferedWriter(fileWriter);

                // Write the raw weather data to the file
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }

                // Close resources
                reader.close();
                writer.close();

                System.out.println("Weather report saved to RoadCastReport.txt");
            } else {
                System.out.println("Failed to retrieve weather information for " + selectedLocation +
                        ". Response code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayReport() {
        String urlString = String.format("%s?q=%s&appid=%s", API_URL, selectedLocation, API_KEY);

        try {
            // Create URL object
            URL url = new URL(urlString);

            // Create HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and print raw response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                System.out.println("Raw Weather Data for " + selectedLocation + ":");

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();
            } else {
                System.out.println("Failed to retrieve weather information for " + selectedLocation +
                        ". Response code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = -1;

        while (choice < 1 || choice > maxChoice) {
            System.out.println("Please enter a number between 1 and " + maxChoice + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
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
}
