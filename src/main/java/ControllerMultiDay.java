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

        dayOneDay.setText(String.valueOf(JavaFX.dayOne.day.temp));
        dayOneNight.setText(String.valueOf(JavaFX.dayOne.night.temp));
        dayOneText.setText(JavaFX.dayOne.day.name);

        dayTwoDay.setText(String.valueOf(JavaFX.dayTwo.day.temp));
        dayTwoNight.setText(String.valueOf(JavaFX.dayTwo.night.temp));
        dayTwoText.setText(JavaFX.dayTwo.day.name);

        dayThreeDay.setText(String.valueOf(JavaFX.dayThree.day.temp));
        dayThreeNight.setText(String.valueOf(JavaFX.dayThree.night.temp));
        dayThreeText.setText(JavaFX.dayThree.day.name);

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
