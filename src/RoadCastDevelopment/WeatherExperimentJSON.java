package RoadCastDevelopment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExperimentJSON {

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
                // Read JSON response and parse using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                WeatherData weatherData = objectMapper.readValue(connection.getInputStream(), WeatherData.class);

                // Print parsed information
                System.out.println("Weather Information for " + city + ":");
                System.out.println(weatherData);
            } else {
                System.out.println("Failed to retrieve weather information. Response code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherData {
        @JsonProperty("main")
        private MainInfo mainInfo;

        public MainInfo getMainInfo() {
            return mainInfo;
        }

        public void setMainInfo(MainInfo mainInfo) {
            this.mainInfo = mainInfo;
        }

        @Override
        public String toString() {
            return "Temperature: " + mainInfo.getTemperature() + "°C";
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainInfo {
        @JsonProperty("temp")
        private double temperature;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }
    }
}
