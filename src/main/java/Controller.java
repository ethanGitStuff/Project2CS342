import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import weather.Period;
import weather.WeatherAPI;
import java.util.ArrayList;

public class Controller implements Initializable {
    @FXML private TextField mainTemp;
    @FXML private TextField tempDesc;
    @FXML private Pane root;
    @FXML private Pane bubble;
    @FXML private TextField mainWindSpeedLow;
    @FXML private TextField mainWindSpeedHigh;
    @FXML private TextField mainWindDir;
    @FXML private TextField mainPrecip;
    @FXML private Button threeDayButton;
    @FXML private Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Period> forecast = WeatherAPI.getForecast("LOT",77,70);
        if (forecast == null){
            throw new RuntimeException("Forecast did not load");
        }
        String[] windLex = forecast.get(0).windSpeed.split(" ");
        tempDesc.setText(forecast.get(0).shortForecast);
        mainTemp.setText(String.valueOf(forecast.get(0).temperature));
        mainWindSpeedLow.setText(windLex[0]);
        mainWindSpeedHigh.setText(windLex[2]);
        mainWindDir.setText(forecast.get(0).windDirection);
        mainPrecip.setText(forecast.get(0).probabilityOfPrecipitation.value + "%");
    }
}
