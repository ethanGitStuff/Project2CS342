import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.custom.classes.City;
import com.custom.components.MenuActionHandler;
import com.custom.components.MenuComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import weather.Period;
import weather.WeatherAPI;

public class ControllerSearchLocation implements Initializable, MenuActionHandler {
	// FXML elements
    @FXML private Pane rootSearch;
    @FXML private MenuComponent bottomMenu;
    @FXML private TextField searchBar;
    @FXML private ListView<String> listBox;
    @FXML private Button selectButton;

    public static String selectCity;

    /*
     * Search action event handler
     * Defines how to handle search event to display cities based on user input
     * Takes in an ActionEvent, returns nothing
     */
    @FXML
    private void search(ActionEvent e) {
        listBox.getItems().clear();
        searchArray(searchBar.getText());
        listBox.getItems().addAll(currentCities);
        searchBar.clear();
    }

    @FXML
    private void collectResult(MouseEvent e){
        // get object selected in listview for each selection
        selectCity = listBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void onSelectedClick() {
        if (selectCity == null) {
            return;
        }

        int index = currentCities.indexOf(selectCity);
        Pair<Float, Float> cityCoord = coordinates.get(index);

        BigDecimal bd1 = new BigDecimal(cityCoord.getKey()).setScale(4, RoundingMode.DOWN);
        float currLat = bd1.floatValue();

        BigDecimal bd2 = new BigDecimal(cityCoord.getValue()).setScale(4, RoundingMode.DOWN);
        float currLon = bd2.floatValue();


        ArrayList<String> details = MyWeatherAPI.getRegion(currLat, currLon);
        System.out.println(details);
        ArrayList<Period> newForecast = WeatherAPI.getForecast(
                details.get(0), Integer.parseInt(details.get(1)), Integer.parseInt(details.get(2)));

        JavaFX.forecast = newForecast;
        JavaFX.setForecastOfDays();
        ControllerTodayScene.currentLocation = selectCity;
        onHomeClick();
    }

    static private ArrayList<String> currentCities;
    static private ArrayList<Pair<Float, Float>> coordinates;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        currentCities = new ArrayList<String>();
        coordinates = new ArrayList<Pair<Float, Float>>();

        listBox.getItems().addAll(currentCities);

        bottomMenu.setActionHandler(this);
	}

    @Override
    public void onMenuClick() { FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        try {
            Parent rootMultiDay = loader.load();
            rootSearch.getScene().setRoot(rootMultiDay);
            rootMultiDay.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        } }

    @Override
    public void onHomeClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        try {
            Parent root = loader.load();
            rootSearch.getScene().setRoot(root);
            root.requestFocus();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    // Just here for the interface, this line should never actually print to console.
    @Override
    public void onSearchClick() { System.out.println("Already on Search!"); }

    private void searchArray(String searchFor) {
        currentCities.clear();
        coordinates.clear();

        searchFor = searchFor.toLowerCase();

        for (City c : JavaFX.Cities) {
            String check = c.city.toLowerCase();
            if (searchFor.length() > check.length()) {
                continue;
            }
            if (check.contains(searchFor)) {
                currentCities.add(c.city);
                coordinates.add(new Pair<>(c.latitude, c.longitude));
            }
        }
    }

}
