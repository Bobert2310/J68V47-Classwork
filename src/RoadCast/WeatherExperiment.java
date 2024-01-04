package RoadCast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherExperiment {

    private static final String API_KEY = "YOUR_OPENWEATHER_API_KEY";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        String city = "YOUR_CITY_NAME";
        String urlString = String.format("%s?q=%s&appid=%s", API_URL, city, API_KEY);

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
                // Read response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Extract relevant weather information
                JSONObject main = jsonResponse.getJSONObject("main");
                double temperature = main.getDouble("temp");
                double humidity = main.getDouble("humidity");

                // Display weather information
                System.out.println("Weather in " + city);
                System.out.println("Temperature: " + temperature + " Kelvin");
                System.out.println("Humidity: " + humidity + "%");
            } else {
                System.out.println("Failed to retrieve weather information. Response code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
