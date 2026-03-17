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

public class ControllerMultiDay implements Initializable, MenuActionHandler {
    @FXML Pane rootMultiDay;
    @FXML MenuComponent bottomMenu;

    @FXML private TextField dayOneDay;
    @FXML private TextField dayOneNight;
    @FXML private TextField dayOneText;


    @FXML private TextField dayTwoDay;
    @FXML private TextField dayTwoNight;
    @FXML private TextField dayTwoText;


    @FXML private TextField dayThreeDay;
    @FXML private TextField dayThreeNight;
    @FXML private TextField dayThreeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (JavaFX.forecast == null){
            throw new RuntimeException("Forecast did not load");
        }

        dayOneDay.setText(String.valueOf(JavaFX.forecast.get(2).temperature));
        dayOneNight.setText(String.valueOf(JavaFX.forecast.get(3).temperature));
        dayOneText.setText(JavaFX.forecast.get(2).name);

        dayTwoDay.setText(String.valueOf(JavaFX.forecast.get(4).temperature));
        dayTwoNight.setText(String.valueOf(JavaFX.forecast.get(5).temperature));
        dayTwoText.setText(JavaFX.forecast.get(4).name);

        dayThreeDay.setText(String.valueOf(JavaFX.forecast.get(6).temperature));
        dayThreeNight.setText(String.valueOf(JavaFX.forecast.get(7).temperature));
        dayThreeText.setText(JavaFX.forecast.get(6).name);

        /*
        String[] windLex = forecast.get(0).windSpeed.split(" ");
        if (windLex.length > 2) {
            mainWindSpeedHigh.setText(windLex[2]);
        }
        else {
            mainWindSpeedHigh.setVisible(false);
            basicTO.setVisible(false);
            mainWindSpeedLow.setLayoutY(30);
            basicMPH.setLayoutY(50);
        }*/


        bottomMenu.setActionHandler(this);
    }

    @Override
    public void onMenuClick() { System.out.println("Already on Multi-day forecast!"); }

    @Override
    public void onHomeClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        try {
            Parent root = loader.load();
            rootMultiDay.getScene().setRoot(root);
            root.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void onSearchClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/locationSearch.fxml"));
        try {
            Parent rootSearch = loader.load();
            rootMultiDay.getScene().setRoot(rootSearch);
            rootSearch.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
