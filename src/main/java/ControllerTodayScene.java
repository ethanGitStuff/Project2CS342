import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.custom.components.MenuActionHandler;
import com.custom.components.MenuComponent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import weather.Period;
import weather.WeatherAPI;
import java.util.ArrayList;

public class ControllerTodayScene implements Initializable, MenuActionHandler {
    @FXML private TextField mainTemp;
    @FXML private TextField foreDesc;
    @FXML private Pane rootDay;
    @FXML private TextField mainWindSpeedLow;
    @FXML private TextField mainWindSpeedHigh;
    @FXML private TextField mainWindDir;
    @FXML private TextField mainPrecip;
    @FXML private TextField basicTO;
    @FXML private TextField basicMPH;
    @FXML private MenuComponent bottomMenu;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (JavaFX.forecast == null){
            throw new RuntimeException("Forecast did not load");
        }

        if (JavaFX.today.windRange) {
            mainWindSpeedHigh.setText(JavaFX.today.windHigh);
        }
        else {
            mainWindSpeedHigh.setVisible(false);
            basicTO.setVisible(false);
            mainWindSpeedLow.setLayoutY(30);
            basicMPH.setLayoutY(50);
        }

        foreDesc.setText(JavaFX.today.desc);
        mainTemp.setText(String.valueOf(JavaFX.today.temp));
        mainWindSpeedLow.setText(JavaFX.today.windLow);
        mainWindDir.setText(JavaFX.today.windDir);
        // Not sure why
        mainPrecip.setText(JavaFX.today.precip + "%");

        /*
        String[] windLex = JavaFX.forecast.get(0).windSpeed.split(" ");
        if (windLex.length > 2) {
            mainWindSpeedHigh.setText(windLex[2]);
        }
        else {
            mainWindSpeedHigh.setVisible(false);
            basicTO.setVisible(false);
            mainWindSpeedLow.setLayoutY(30);
            basicMPH.setLayoutY(50);
        }

        tempDesc.setText(JavaFX.forecast.get(0).shortForecast);
        mainTemp.setText(String.valueOf(JavaFX.forecast.get(0).temperature));
        mainWindSpeedLow.setText(windLex[0]);
        mainWindDir.setText(JavaFX.forecast.get(0).windDirection);
        mainPrecip.setText(JavaFX.forecast.get(0).probabilityOfPrecipitation.value + "%");
         */

        bottomMenu.setActionHandler(this);
    }

    @Override
    public void onMenuClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        try {
            Parent rootMultiDay = loader.load();
            rootDay.getScene().setRoot(rootMultiDay);
            rootMultiDay.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void onHomeClick() { System.out.println("Already at home!"); }

    @Override
    public void onSearchClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/locationSearch.fxml"));
        try {
            Parent rootSearch = loader.load();
            rootDay.getScene().setRoot(rootSearch);
            rootSearch.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
