import com.custom.classes.City;
import com.custom.classes.Day;
import com.custom.classes.DayPair;
import com.fasterxml.jackson.core.type.TypeReference;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import weather.Period;
import weather.WeatherAPI;

import java.io.InputStream;
import java.util.ArrayList;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	// variables for control
	public static ArrayList<Period> forecast = WeatherAPI.getForecast("LOT",77,70); // load data of default location into forecast
	public static ArrayList<City> Cities;
	public static Day today;
	public static DayPair dayOne;
	public static DayPair dayTwo;
	public static DayPair dayThree;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// cities_clean.JSON derived from Miserlou on github at
		// https://gist.github.com/Miserlou/c5cd8364bf9b2420bb29
		// Then we removed the parts of the data we did not need.
		// pull data from cities_clean json file and parse into ArrayList Cities
		ObjectMapper mapper = new ObjectMapper();
		InputStream json = JavaFX.class.getClassLoader().getResourceAsStream("Other/cities_clean.json");
		if (json == null) {
			throw new RuntimeException("City file could not be opened."); // basic error handling
		}
		Cities = mapper.readValue(json, new TypeReference<ArrayList<City>>() {});

		// pull data from forecast ArrayList to be used in displaying three-day forecast tab
		today = new Day(forecast.get(0));
		dayOne = new DayPair(forecast.get(1), forecast.get(2));
		dayTwo = new DayPair(forecast.get(3), forecast.get(4));
		dayThree = new DayPair(forecast.get(5), forecast.get(6));

		primaryStage.setTitle("Weather");

		@SuppressWarnings("ConstantConditions")
		Parent rootDay = FXMLLoader.load(getClass().getResource("/FXML/proj2SB.fxml"));

		// load app
		Scene sceneDay = new Scene(rootDay, 400,750);
		primaryStage.setScene(sceneDay);
		primaryStage.setResizable(false);
		primaryStage.show();
		rootDay.requestFocus();
	}
}
