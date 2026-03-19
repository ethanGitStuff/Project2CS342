import com.custom.classes.City;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.custom.components.MenuActionHandler;
import com.custom.components.MenuComponent;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.util.Duration;
import weather.Period;
import weather.WeatherAPI;

public class ControllerFavorites implements Initializable, MenuActionHandler {

    @FXML private Pane root;
    @FXML private Pane choicePane;
    @FXML private MenuComponent bottomMenu;

    @FXML private TextField cityNameField;
    @FXML private TextField latField;
    @FXML private TextField longField;
    @FXML private TextField currentField;
    @FXML private TextField badLocation;
    @FXML private TextField badInput;

    @FXML private ListView<String> favListView;

    @FXML private Button addButton;
    @FXML private Button selectButton;
    @FXML private Button deleteButton;

    private City currentCity;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (City c : JavaFX.favorites) {
            favListView.getItems().add(c.city + " | " + c.latitude + " | " + c.longitude);
        }

        favListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldText, newText) -> {
                    if (newText != null) { onSelect(newText); }
                    else {hideChoice();}
                }
        );

        bottomMenu.setActionHandler(this);
    }

    public void onAddClick(ActionEvent e) {
        float lat;
        float lon;

        if (favListView.getItems().size() >= 14) {
            badInput.setText("Too Many");
            badText(badInput);
            badInput.setText("Not a valid input");
            return;
        }
        if (cityNameField.getText().isEmpty() || latField.getText().isEmpty() || longField.getText().isEmpty()) {
            badText(badInput);
            return;
        }
        if (cityNameField.getText().contains("|")) {
            badText(badInput);
            return;
        }
        try {
            lat = Float.parseFloat(latField.getText());
            lon = Float.parseFloat(longField.getText());
        }
        catch (NumberFormatException n) {
            badText(badInput);
            return;
        }

        for (City c : JavaFX.favorites) {
            if (cityNameField.getText().equals(c.city)) {
                badText(badInput);
                return;
            }
            if (lat == c.latitude && lon == c.longitude) {
                badText(badInput);
                return;
            }
        }
        BigDecimal bd1 = new BigDecimal(lat).setScale(4, RoundingMode.DOWN);
        BigDecimal bd2 = new BigDecimal(lon).setScale(4, RoundingMode.DOWN);


        City toAddCity = new City(cityNameField.getText(), bd1.floatValue(), bd2.floatValue());
        String toAddString = cityNameField.getText() + " | " + latField.getText() + " | " + longField.getText();

        JavaFX.favorites.add(toAddCity);
        favListView.getItems().add(toAddString);

        cityNameField.clear();
        latField.clear();
        longField.clear();
    }

    public void onSelect(String curr) {
        String fixed = curr.split("\\|")[0].trim();

        for (City c : JavaFX.favorites) {
            if (c.city.equals(fixed)) {
                currentCity = new City(c.city, c.latitude, c.longitude);
            }
        }
        currentField.setText(curr);
        choicePane.setDisable(false);
        choicePane.setVisible(true);
    }

    public void hideChoice() {
        choicePane.setDisable(true);
        choicePane.setVisible(false);
    }

    public void deleteClick(ActionEvent e) {
        int index = favListView.getSelectionModel().getSelectedIndex();
        String cityToDelete = currentCity.city;
        favListView.getItems().remove(index);
        JavaFX.favorites.removeIf(c -> cityToDelete.equals(c.city));
        favListView.getSelectionModel().clearSelection();
        currentCity = null;
    }

    public void onSelectButtonClick(ActionEvent e) {
        ArrayList<String> cityDetails = MyWeatherAPI.getRegion(currentCity.latitude, currentCity.longitude);
        if (cityDetails.get(0).isEmpty()) {
            badText(badLocation);
            return;
        }

        ArrayList<Period> newForecast = WeatherAPI.getForecast(
                cityDetails.get(0), Integer.parseInt(cityDetails.get(1)), Integer.parseInt(cityDetails.get(2)));
        if (newForecast == null) {
            badText(badLocation);
            return;
        }

        JavaFX.forecast = newForecast;
        JavaFX.setForecastOfDays();
        ControllerTodayScene.currentLocation = currentCity.city;
        onHomeClick();
    }

    private void badText(TextField bad) {
        bad.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(x -> bad.setVisible(false));
        pause.play();
    }

    @Override
    public void onMenuClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        try {
            Parent rootMultiDay = loader.load();
            root.getScene().setRoot(rootMultiDay);
            rootMultiDay.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void onHomeClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        try {
            Parent rootHome = loader.load();
            root.getScene().setRoot(rootHome);
            rootHome.requestFocus();
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
            root.getScene().setRoot(rootSearch);
            rootSearch.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
