import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.custom.components.MenuActionHandler;
import com.custom.components.MenuComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;

public class ControllerMultiDay implements Initializable, MenuActionHandler {
	// FXML elements
    @FXML Pane rootMultiDay;
    @FXML Pane zoomPane;
    @FXML MenuComponent bottomMenu;

    @FXML private TextField dayOneDay;
    @FXML private TextField dayOneWind;
    @FXML private TextField dayOneWindDir;
    @FXML private TextField dayOneNight;
    @FXML private TextField nightOneWind;
    @FXML private TextField nightOneWindDir;
    @FXML private TextField dayOneText;

    @FXML private TextField dayTwoDay;
    @FXML private TextField dayTwoWind;
    @FXML private TextField dayTwoWindDir;
    @FXML private TextField dayTwoNight;
    @FXML private TextField nightTwoWind;
    @FXML private TextField nightTwoWindDir;
    @FXML private TextField dayTwoText;

    @FXML private TextField dayThreeDay;
    @FXML private TextField dayThreeWind;
    @FXML private TextField dayThreeWindDir;
    @FXML private TextField dayThreeNight;
    @FXML private TextField nightThreeWind;
    @FXML private TextField nightThreeWindDir;
    @FXML private TextField dayThreeText;

    @FXML private Button dayOneZoom;
    @FXML private Button dayTwoZoom;
    @FXML private Button dayThreeZoom;

    @FXML private TextField zoomDayTemp;
    @FXML private TextField zoomNightTemp;
    @FXML private TextField zoomWindSpeedDay;
    @FXML private TextField zoomWindDirDay;
    @FXML private TextField zoomPrecipDay;
    @FXML private TextField zoomWindSpeedNight;
    @FXML private TextField zoomWindDirNight;
    @FXML private TextField zoomPrecipNight;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	// error checking for default location API request
        if (JavaFX.forecast == null){
            throw new RuntimeException("Forecast did not load");
        }
        
        // using data parsed from API request, set textfields with information on day 1 card
        dayOneDay.setText(String.valueOf(JavaFX.dayOne.day.temp));
        dayOneWind.setText(JavaFX.dayOne.day.windHigh);
        dayOneWindDir.setText(JavaFX.dayOne.day.windDir);
        dayOneNight.setText(String.valueOf(JavaFX.dayOne.night.temp));
        nightOneWind.setText(JavaFX.dayOne.night.windHigh);
        nightOneWindDir.setText(JavaFX.dayOne.night.windDir);
        dayOneText.setText(JavaFX.dayOne.day.name);

        // using data parsed from API request, set textfields with information on day 2 card
        dayTwoDay.setText(String.valueOf(JavaFX.dayTwo.day.temp));
        dayTwoWind.setText(JavaFX.dayTwo.day.windHigh);
        dayTwoWindDir.setText(JavaFX.dayTwo.day.windDir);
        dayTwoNight.setText(String.valueOf(JavaFX.dayTwo.night.temp));
        nightTwoWind.setText(JavaFX.dayTwo.night.windHigh);
        nightTwoWindDir.setText(JavaFX.dayTwo.night.windDir);
        dayTwoText.setText(JavaFX.dayTwo.day.name);

        // using data parsed from API request, set textfields with information on day 3 card
        dayThreeDay.setText(String.valueOf(JavaFX.dayThree.day.temp));
        dayThreeWind.setText(JavaFX.dayThree.day.windHigh);
        dayThreeWindDir.setText(JavaFX.dayThree.day.windDir);
        dayThreeNight.setText(String.valueOf(JavaFX.dayThree.night.temp));
        nightThreeWind.setText(JavaFX.dayThree.night.windHigh);
        nightThreeWindDir.setText(JavaFX.dayThree.night.windDir);
        dayThreeText.setText(JavaFX.dayThree.day.name);

        bottomMenu.setActionHandler(this);
    }

    public void onDayOneClick(ActionEvent e) throws IOException{
        zoomPane.setDisable(false);
        zoomPane.setVisible(true);

        zoomDayTemp.setText(String.valueOf(JavaFX.dayOne.day.temp));
        zoomWindSpeedDay.setText(JavaFX.dayOne.day.windHigh);
        zoomWindDirDay.setText(JavaFX.dayOne.day.windDir);
        zoomPrecipDay.setText(String.valueOf(JavaFX.dayOne.day.precip) + "%");

        zoomNightTemp.setText(String.valueOf(JavaFX.dayOne.night.temp));
        zoomWindSpeedNight.setText(JavaFX.dayOne.night.windHigh);
        zoomWindDirNight.setText(JavaFX.dayOne.night.windDir);
        zoomPrecipNight.setText(JavaFX.dayOne.night.precip + "%");

        dayOneZoom.setDisable(true);
        dayTwoZoom.setDisable(true);
        dayThreeZoom.setDisable(true);
    }

    public void onDayTwoClick(ActionEvent e) throws IOException{
        zoomPane.setDisable(false);
        zoomPane.setVisible(true);

        zoomDayTemp.setText(String.valueOf(JavaFX.dayTwo.day.temp));
        zoomWindSpeedDay.setText(JavaFX.dayTwo.day.windHigh);
        zoomWindDirDay.setText(JavaFX.dayTwo.day.windDir);
        zoomPrecipDay.setText(JavaFX.dayTwo.day.precip + "%");

        zoomNightTemp.setText(String.valueOf(JavaFX.dayTwo.night.temp));
        zoomWindSpeedNight.setText(JavaFX.dayTwo.night.windHigh);
        zoomWindDirNight.setText(JavaFX.dayTwo.night.windDir);
        zoomPrecipNight.setText(JavaFX.dayTwo.night.precip + "%");

        dayOneZoom.setDisable(true);
        dayTwoZoom.setDisable(true);
        dayThreeZoom.setDisable(true);
    }

    public void onDayThreeClick(ActionEvent e) throws IOException{
        zoomPane.setDisable(false);
        zoomPane.setVisible(true);

        zoomDayTemp.setText(String.valueOf(JavaFX.dayThree.day.temp));
        zoomWindSpeedDay.setText(JavaFX.dayThree.day.windHigh);
        zoomWindDirDay.setText(JavaFX.dayThree.day.windDir);
        zoomPrecipDay.setText(JavaFX.dayThree.day.precip + "%");

        zoomNightTemp.setText(String.valueOf(JavaFX.dayThree.night.temp));
        zoomWindSpeedNight.setText(JavaFX.dayThree.night.windHigh);
        zoomWindDirNight.setText(JavaFX.dayThree.night.windDir);
        zoomPrecipNight.setText(JavaFX.dayThree.night.precip + "%");

        dayOneZoom.setDisable(true);
        dayTwoZoom.setDisable(true);
        dayThreeZoom.setDisable(true);
    }

    public void onExitClick(ActionEvent e) throws IOException{
        zoomPane.setDisable(true);
        zoomPane.setVisible(false);

        dayOneZoom.setDisable(false);
        dayTwoZoom.setDisable(false);
        dayThreeZoom.setDisable(false);
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
