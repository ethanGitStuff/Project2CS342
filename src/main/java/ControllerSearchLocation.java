import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;

public class ControllerSearchLocation implements Initializable {
    @FXML private Button threeDayButton;
    @FXML private Button searchButton;
    @FXML private Button homeButton;
    @FXML private Pane rootSearch;

	
	public void multidayButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        Parent rootMultiDay = loader.load();
        rootSearch.getScene().setRoot(rootMultiDay);
        rootMultiDay.requestFocus();
    }

	public void homeButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        Parent rootDay = loader.load();
        rootSearch.getScene().setRoot(rootDay);
        rootDay.requestFocus();
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
