import com.fasterxml.jackson.databind.JsonNode;
import weather.WeatherAPI;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyWeatherAPI extends WeatherAPI {

    public static ArrayList<String> getRegion(float lat, float lon) throws NullPointerException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.weather.gov/points/"+String.valueOf(lat)+","+String.valueOf(lon)))
                .build();
        HttpResponse<String> response = null;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            json = mapper.readTree(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> toRet = new ArrayList<>();
        toRet.add(json.path("properties").path("gridId").asText());
        toRet.add(String.valueOf(json.path("properties").path("gridX").asInt()));
        toRet.add(String.valueOf(json.path("properties").path("gridY").asInt()));

        return toRet;
    }

}
