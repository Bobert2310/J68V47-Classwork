import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class WeatherExperiment {

        public static void main(String[] args) {
            // Replace "YOUR_API_KEY" with your OpenWeatherMap API key
            String apiKey = "YOUR_API_KEY";
            String city = "CityName"; // Replace with the desired city name

            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                connection.disconnect();

                // Parse and display the weather information
                parseWeatherData(response.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void parseWeatherData(String jsonData) {
            // Add your JSON parsing logic here
            // Extract relevant weather information from the JSON data

            // Example: Display the raw JSON data
            System.out.println("Raw Weather Data:\n" + jsonData);
        }
    }

