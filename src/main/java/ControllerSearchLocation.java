import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.custom.components.MenuActionHandler;
import com.custom.components.MenuComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;

public class ControllerSearchLocation implements Initializable, MenuActionHandler {
    @FXML private Button threeDayButton;
    @FXML private Button searchButton;
    @FXML private Button homeButton;
    @FXML private Pane rootSearch;
    @FXML private MenuComponent bottomMenu;

	/*
	public void multidayButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/multidayScene.fxml"));
        Parent rootMultiDay = loader.load();
        rootSearch.getScene().setRoot(rootMultiDay);
        rootMultiDay.requestFocus();
    }

	public void homeButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
        Parent rootDay = loader.load();
        rootSearch.getScene().setRoot(rootDay);
        rootDay.requestFocus();
    }*/
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

        bottomMenu.setActionHandler(this);
	}

    @Override
    public void onMenuClick() { FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/proj2SB.fxml"));
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

    @Override
    public void onSearchClick() { System.out.println("Already on Search!"); }

}
