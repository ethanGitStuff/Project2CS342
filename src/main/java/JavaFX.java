import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import weather.Period;
import weather.WeatherAPI;

import java.util.ArrayList;

public class JavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("I'm a very professional Weather App!");

		@SuppressWarnings("ConstantConditions")
		Parent scene1 = FXMLLoader.load(getClass().getResource("/FXML/proj2SB.fxml"));

		Scene sceneDay = new Scene(scene1, 400,750);
		primaryStage.setScene(sceneDay);
		primaryStage.setResizable(false);
		primaryStage.show();
		scene1.requestFocus();
	}

}
