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


public class ControllerTodayScene implements Initializable, MenuActionHandler {
	// FXML elements
    @FXML private TextField mainTemp;
    @FXML private TextField foreDesc;
    @FXML private Pane rootDay;
    @FXML private TextField mainWindSpeedLow;
    @FXML private TextField mainWindSpeedHigh;
    @FXML private TextField mainWindDir;
    @FXML private TextField mainPrecip;
    @FXML private TextField basicTO;
    @FXML private TextField basicMPH;
    @FXML private Button favoritesButton;
    @FXML private TextField currLocat;
    @FXML private MenuComponent bottomMenu;

    public static String currentLocation = "Chicago";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// error checking for default location API request
        if (JavaFX.forecast == null){
            throw new RuntimeException("Forecast did not load");
        }

        currLocat.setText(currentLocation);

        // handle and set wind range output
        if (JavaFX.today.windRange) {
            mainWindSpeedHigh.setText(JavaFX.today.windHigh);
        }
        else {
            mainWindSpeedHigh.setVisible(false);
            basicTO.setVisible(false);
            mainWindSpeedLow.setLayoutY(30);
            basicMPH.setLayoutY(50);
        }

        // set other card information based on API output
        foreDesc.setText(JavaFX.today.desc);
        mainTemp.setText(String.valueOf(JavaFX.today.temp) + "°F");
        mainWindSpeedLow.setText(JavaFX.today.windLow);
        mainWindDir.setText(JavaFX.today.windDir);
        mainPrecip.setText(JavaFX.today.precip + "%");

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

    // Just here for the interface, this line should never actually print to console.
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

    public void onFavoritesClick(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/favoriteLocations.fxml"));
        try {
            Parent rootFavorites = loader.load();
            rootDay.getScene().setRoot(rootFavorites);
            rootFavorites.requestFocus();
        }
        catch (IOException x) {
            throw new RuntimeException();
        }

    }
}
