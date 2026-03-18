package weather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1


public class WeatherAPI {
	/*
	 * Function to request forecast information from API
	 * takes in a string representing the region where the nearest NWS office is located,
	 * 		an integer representing the representing the X grid coordinate and an integer
	 * 		representing the Y grid coordinate, and returns an ArrayList with information
	 */
    public static ArrayList<Period> getForecast(String region, int gridx, int gridy) {
        // build api call request using parameters as search input
    	HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.weather.gov/gridpoints/"+region+"/"+String.valueOf(gridx)+","+String.valueOf(gridy)+"/forecast"))
                .build();
        HttpResponse<String> response = null;
        // basic error handling
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Root r = getObject(response.body());
        if(r == null){
            System.err.println("Failed to parse JSon");
            return null;
        }
        return r.properties.periods;
    }
    // parse json received by request into ArrayList to return
    public static Root getObject(String json){
        ObjectMapper om = new ObjectMapper();
        Root toRet = null;
        // more basic error handling
        try {
            toRet = om.readValue(json, Root.class);
            ArrayList<Period> p = toRet.properties.periods;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return toRet;
    }
}



