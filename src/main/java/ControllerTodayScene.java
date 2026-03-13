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

public class ControllerTodayScene implements Initializable {
    @FXML private TextField mainTemp;
    @FXML private TextField tempDesc;
    @FXML private Pane rootDay;
    @FXML private Pane bubble;
    @FXML private TextField mainWindSpeedLow;
    @FXML private TextField mainWindSpeedHigh;
    @FXML private TextField mainWindDir;
    @FXML private TextField mainPrecip;
    @FXML private TextField basicTO;
    @FXML private TextField basicMPH;
    @FXML private Button threeDayButton;
    @FXML private Button searchButton;

    //@FXML private ScrollPane rootMultiDay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Period> forecast = WeatherAPI.getForecast("LOT",77,70);
        if (forecast == null){
            throw new RuntimeException("Forecast did not load");
        }
        String[] windLex = forecast.get(0).windSpeed.split(" ");
        if (windLex.length > 2) {
            mainWindSpeedHigh.setText(windLex[2]);
        }
        else {
            mainWindSpeedHigh.setVisible(false);
            basicTO.setVisible(false);
            mainWindSpeedLow.setLayoutY(30);
            basicMPH.setLayoutY(50);
        }

        tempDesc.setText(forecast.get(0).shortForecast);
        mainTemp.setText(String.valueOf(forecast.get(0).temperature));
        mainWindSpeedLow.setText(windLex[0]);
        mainWindDir.setText(forecast.get(0).windDirection);
        mainPrecip.setText(forecast.get(0).probabilityOfPrecipitation.value + "%");
    }

    public void multidayButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        Parent rootMultiDay = loader.load();
        rootDay.getScene().setRoot(rootMultiDay);
        rootMultiDay.requestFocus();
    }
}
