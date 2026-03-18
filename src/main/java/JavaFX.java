import com.custom.classes.Day;
import com.custom.classes.DayPair;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import weather.Period;
import weather.WeatherAPI;

import java.util.ArrayList;

public class JavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public static ArrayList<Period> forecast = WeatherAPI.getForecast("LOT",77,70);
	public static Day today;
	public static DayPair dayOne;
	public static DayPair dayTwo;
	public static DayPair dayThree;

	@Override
	public void start(Stage primaryStage) throws Exception {
		today = new Day(forecast.get(0));
		dayOne = new DayPair(forecast.get(1), forecast.get(2));
		dayTwo = new DayPair(forecast.get(3), forecast.get(4));
		dayThree = new DayPair(forecast.get(5), forecast.get(6));

		primaryStage.setTitle("Weather");

		@SuppressWarnings("ConstantConditions")
		Parent rootDay = FXMLLoader.load(getClass().getResource("/FXML/proj2SB.fxml"));

		Scene sceneDay = new Scene(rootDay, 400,750);
		primaryStage.setScene(sceneDay);
		primaryStage.setResizable(false);
		primaryStage.show();
		rootDay.requestFocus();
	}
}
