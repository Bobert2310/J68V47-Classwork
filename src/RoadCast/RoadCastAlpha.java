package RoadCast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RoadCastAlpha {

    private static final String API_KEY = "b9478773177fc290b1f32f1432103c10";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    private static String[] locations = {"Aberdeen", "Glasgow", "Edinburgh", "London", "Paris"};
    private static String selectedLocation = "No Location Selected";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Welcome();
        pressAnyKey();

        boolean Quit = false;

        while (!Quit) {
            MainMenu();
            int mainMenuChoice = UserInput(scanner, 4);

            if (mainMenuChoice == 1) {
                changeLocationMenu(scanner);
            } else if (mainMenuChoice == 2) {
                roadConditionsMenu(scanner);
            } else if (mainMenuChoice == 3) {
                saveReportToFile();
            } else if (mainMenuChoice == 4) {
                Quit = true;
            } else {
                System.out.println("Error: No option was selected. Please try again.");
            }
        }

        System.out.println("Thank you for using RoadCast.");
        System.out.println("Goodbye.");
        scanner.close();
    }

    private static void Welcome() {
        System.out.println("Welcome to RoadCast");
        System.out.println("Press the Enter key to continue");
    }

    private static void MainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Set Location");
        System.out.println("2. Weather Report");
        System.out.println("3. Save Report");
        System.out.println("4. Exit");
    }

    private static void changeLocationMenu(Scanner scanner) {
        System.out.println("\nLocation Menu:");

        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        int locationChoice = UserInput(scanner, 5);

        if (locationChoice != 0) {
            selectedLocation = locations[locationChoice - 1];
            System.out.println("Location changed to: " + selectedLocation);
        }
    }

    private static void roadConditionsMenu(Scanner scanner) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\nHere is the current weather for " + selectedLocation + ":");
            displayReport();
            System.out.println("1. Back\n2. Exit");
            int roadConditionChoice = UserInput(scanner, 2);

            if (roadConditionChoice == 1) {
                backToMainMenu = true;
            } else if (roadConditionChoice == 2) {
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Error: No option was selected. Please try again.");
            }
        }

    }

    private static void saveReportToFile() {
        String weatherData = getWeatherData();

        String filePath = "src/RoadCast/RoadCastReport.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(weatherData);
            writer.newLine();
            System.out.println("Weather report saved to " + filePath);
        } catch (Exception e) {
            System.out.println("Failed to save weather report. Error: " + e.getMessage());
        }
    }


    private static void displayReport() {
        String weatherData = getWeatherData();
        System.out.println("Raw Weather Data for " + selectedLocation + ":\n" + weatherData);
    }

    private static String getWeatherData() {
        String urlString = String.format("%s?q=%s&appid=%s", API_URL, selectedLocation, API_KEY);

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }

                reader.close();
                return response.toString();
            } else {
                System.out.println("Failed to retrieve weather information for " + selectedLocation +
                        ". Response code: " + responseCode);
                return "";
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve weather information. Error: " + e.getMessage());
            return "";
        }
    }

    private static int UserInput(Scanner scanner, int maxChoice) {
        int choice = -1;

        while (true) {
            System.out.println("Please enter a number between 1 and " + maxChoice + ":");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return choice;
    }

    private static void pressAnyKey() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
