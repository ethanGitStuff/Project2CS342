package com.custom.components;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MenuComponent extends Pane {
    @FXML private Button searchButton;
    @FXML private Button homeButton;
    @FXML private Button menuButton;

    private MenuActionHandler eventHandler;

    boolean homeOn = true;
    boolean menuOn = true;
    boolean searchOn = true;

    public MenuComponent() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/menucomponentfile.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }

    @FXML
    private void initialize() {
        homeButton.setDisable(!homeOn);
        menuButton.setDisable(!menuOn);
        searchButton.setDisable(!searchOn);

        menuButton.setOnAction(e -> { if (eventHandler != null && menuOn) eventHandler.onMenuClick();});
        homeButton.setOnAction(e -> { if (eventHandler != null && homeOn) eventHandler.onHomeClick();});
        searchButton.setOnAction(e -> { if (eventHandler != null && searchOn) eventHandler.onSearchClick();});
    }

    public void setHomeOn(boolean input) { this.homeOn = input; }
    public void setMenuOn(boolean input) { this.menuOn = input; }
    public void setSearchOn(boolean input) { this.searchOn = input; }

    public boolean getHomeOn() { return homeOn; }
    public boolean getMenuOn() { return menuOn; }
    public boolean getSearchOn() { return searchOn; }

    public void setActionHandler(MenuActionHandler handler) {
        this.eventHandler = handler;
    }
}
