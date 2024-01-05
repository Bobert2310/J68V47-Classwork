package RoadCast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExperimentRawData {

    private static final String API_KEY = "b9478773177fc290b1f32f1432103c10";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        String city = "London";
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
                // Read and print raw response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                System.out.println("Raw Weather Data for " + city + ":");

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();
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
