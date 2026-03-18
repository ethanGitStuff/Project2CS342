import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

public class ControllerFavorites implements Initializable, MenuActionHandler {

    @FXML private Pane root;
    @FXML private Pane chaoicePane;
    @FXML private MenuComponent bottomMenu;

    @FXML private TextField cityNameField;
    @FXML private TextField latField;
    @FXML private TextField longField;

    @FXML private ListView<String> favListView;

    @FXML private Button addButton;
    @FXML private Button selectButton;
    @FXML private Button deleteButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        favListView.getItems().addAll(JavaFX.favorites);
        bottomMenu.setActionHandler(this);
    }

    public void onAddClick(ActionEvent e) {
        if (cityNameField.getText().isEmpty() || latField.getText().isEmpty() || longField.getText().isEmpty()) {
            return;
        }
        try {
            Float.parseFloat(latField.getText());
            Float.parseFloat(longField.getText());
        }
        catch (NumberFormatException n) {
            return;
        }

        String toAdd = cityNameField.getText() + " | " + latField.getText() + " | " + longField.getText();
        JavaFX.favorites.add(toAdd);
        favListView.getItems().clear();
        favListView.getItems().addAll(JavaFX.favorites);

        cityNameField.clear();
        latField.clear();
        longField.clear();
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
