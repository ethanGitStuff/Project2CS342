import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
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
