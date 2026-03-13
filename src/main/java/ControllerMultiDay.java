import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import weather.Period;
import weather.WeatherAPI;
import java.util.ArrayList;

public class ControllerMultiDay implements Initializable{
    @FXML ScrollPane rootMultiDay;
    @FXML Button testButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void testButton(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        Parent rootDay = loader.load();
        rootMultiDay.getScene().setRoot(rootDay);
        rootDay.requestFocus();
    }
}
