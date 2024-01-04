package RoadCast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExperiment {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Get user input for the city
            System.out.print("Enter the city name: ");
            String city = reader.readLine();

            // Replace "API_KEY" and "https://api.example.com/weather" with actual API key and endpoint
            String apiKey = "API_KEY";
            String apiUrl = "https://api.example.com/weather?city=" + city + "&apiKey=" + apiKey;

            // Make a request to the weather API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the request was successful (HTTP status code 200)
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader apiReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                // Read the API response
                while ((line = apiReader.readLine()) != null) {
                    response.append(line);
                }
                apiReader.close();

                // Display the weather information
                System.out.println("Weather for " + city + ":");
                System.out.println(response.toString());
            } else {
                System.out.println("Failed to get weather information. HTTP error code: " + connection.getResponseCode());
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
