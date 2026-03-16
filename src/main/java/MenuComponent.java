import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.geometry.Insets;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MenuComponent extends Pane {
    @FXML private Pane backdrop;
    @FXML private Rectangle homeIcon;
    @FXML private Rectangle menuIcon;
    @FXML private Image searchIcon;

    @FXML private Button searchButton;
    @FXML private Button homeButton;
    @FXML private Button menuButton;

    private boolean homeOn = true;
    private boolean menuOn = true;
    private boolean searchOn = true;

    public MenuComponent() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/menucomponentfile.fxml"));
    }
}
