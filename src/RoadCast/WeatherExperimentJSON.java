package RoadCast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class WeatherExperimentJSON {

    private static final String OPENWEATHER_API_KEY = "b9478773177fc290b1f32f1432103c10";
    private static final String OPENWEATHER_API_ENDPOINT = "https://api.openweathermap.org/data/2.5/weather";
    private static final String OPENWEATHER_GEOCODE_ENDPOINT = "https://api.openweathermap.org/geo/1.0/direct";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Get user input for the city
            System.out.print("Enter the city name: ");
            String city = reader.readLine();

            // Use geocoding API to get latitude and longitude for the city
            String geocodeUrl = OPENWEATHER_GEOCODE_ENDPOINT +
                    "?q=" + URLEncoder.encode(city, "UTF-8") +
                    "&limit=1" +
                    "&appid=" + OPENWEATHER_API_KEY;

            URL geocodeApiUrl = new URL(geocodeUrl);
            HttpURLConnection geocodeConnection = (HttpURLConnection) geocodeApiUrl.openConnection();
            geocodeConnection.setRequestMethod("GET");

            if (geocodeConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader geocodeReader = new BufferedReader(new InputStreamReader(geocodeConnection.getInputStream()));
                StringBuilder geocodeResponse = new StringBuilder();
                String geocodeLine;

                while ((geocodeLine = geocodeReader.readLine()) != null) {
                    geocodeResponse.append(geocodeLine);
                }
                geocodeReader.close();

                // Parse the geocode response to get latitude and longitude
                Map<String, Object> geocodeMap = parseJson(geocodeResponse.toString());

                if (geocodeMap != null && geocodeMap.containsKey("lat") && geocodeMap.containsKey("lon")) {
                    double latitude = Double.parseDouble(geocodeMap.get("lat").toString());
                    double longitude = Double.parseDouble(geocodeMap.get("lon").toString());

                    // Use latitude and longitude to get weather data
                    String weatherUrl = OPENWEATHER_API_ENDPOINT +
                            "?lat=" + latitude +
                            "&lon=" + longitude +
                            "&appid=" + OPENWEATHER_API_KEY;

                    URL weatherApiUrl = new URL(weatherUrl);
                    HttpURLConnection weatherConnection = (HttpURLConnection) weatherApiUrl.openConnection();
                    weatherConnection.setRequestMethod("GET");

                    if (weatherConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader weatherReader = new BufferedReader(new InputStreamReader(weatherConnection.getInputStream()));
                        String weatherLine;
                        StringBuilder weatherResponse = new StringBuilder();

                        while ((weatherLine = weatherReader.readLine()) != null) {
                            weatherResponse.append(weatherLine);
                        }
                        weatherReader.close();

                        // Display the formatted weather information
                        displayWeatherInfo(city, parseWeatherJson(weatherResponse.toString()));
                    } else {
                        System.out.println("Failed to get weather information. HTTP error code: " + weatherConnection.getResponseCode());
                    }

                    weatherConnection.disconnect();
                } else {
                    System.out.println("Invalid geocode response. Please check the city name.");
                }
            } else {
                System.out.println("Failed to get geocode information. HTTP error code: " + geocodeConnection.getResponseCode());
            }

            geocodeConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> parseJson(String json) {
        // Implement JSON parsing logic based on the actual structure of the API response
        // This is a simplified example and may need modification based on the actual response structure
        // Consider using a JSON parsing library for a more robust solution
        try {
            // Your JSON parsing logic here...
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Map<String, Object> parseWeatherJson(String json) {
        // Parse the weather JSON response and return a map of relevant details
        try {
            Map<String, Object> weatherMap = parseJson(json);

            if (weatherMap != null && weatherMap.containsKey("main") && weatherMap.containsKey("wind")) {
                Map<String, Object> mainDetails = (Map<String, Object>) weatherMap.get("main");
                Map<String, Object> windDetails = (Map<String, Object>) weatherMap.get("wind");

                // Convert temperature from Kelvin to Celsius
                double temperatureKelvin = Double.parseDouble(mainDetails.get("temp").toString());
                double temperatureCelsius = temperatureKelvin - 273.15;

                // Convert wind speed from m/s to km/h
                double windSpeedMetersPerSecond = Double.parseDouble(windDetails.get("speed").toString());
                double windSpeedKilometersPerHour = windSpeedMetersPerSecond * 3.6;

                // Add the converted values to the weatherMap
                weatherMap.put("temperature", temperatureCelsius);
                weatherMap.put("humidity", mainDetails.get("humidity"));
                weatherMap.put("windSpeed", windSpeedKilometersPerHour);
                weatherMap.put("description", getWeatherDescription(weatherMap));

                return weatherMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getWeatherDescription(Map<String, Object> weatherMap) {
        // Extract weather description from the response
        if (weatherMap.containsKey("weather")) {
            List<Map<String, Object>> weatherDetails = (List<Map<String, Object>>) weatherMap.get("weather");
            if (!weatherDetails.isEmpty() && weatherDetails.get(0).containsKey("description")) {
                return weatherDetails.get(0).get("description").toString();
            }
        }
        return "N/A";
    }

    private static void displayWeatherInfo(String city, Map<String, Object> weatherInfo) {
        if (weatherInfo != null) {
            System.out.println("Weather for " + city + ":");
            System.out.println("Temperature: " + weatherInfo.get("temperature") + "°C");
            System.out.println("Humidity: " + weatherInfo.get("humidity") + "%");
            System.out.println("Wind Speed: " + weatherInfo.get("windSpeed") + " km/h");
            System.out.println("Description: " + weatherInfo.get("description"));
        } else {
            System.out.println("Failed to parse weather information.");
        }
    }
}
