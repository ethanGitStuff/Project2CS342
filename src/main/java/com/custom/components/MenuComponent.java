package com.custom.components;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

// Custom class for encapsulating Menu Bar that shows up across all app tabs
public class MenuComponent extends Pane {
	
    @FXML private Button searchButton; // element of menu bar: search button
    @FXML private Button homeButton;   // element of menu bar: home button
    @FXML private Button menuButton;   // element of menu bar: 3-day forecast menu button

    private MenuActionHandler eventHandler; // interface instance with event handlers

    // variables for control
    boolean homeOn = true;
    boolean menuOn = true;
    boolean searchOn = true;

    /*
     * Constructor
     * Takes no parameters, throws IOException
     * Loads menu component as FXML asset controlled by current instance
     */
    public MenuComponent() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/menucomponentfile.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }

    @FXML
    private void initialize() {
        homeButton.setDisable(!homeOn);     // set home button status
        menuButton.setDisable(!menuOn);     // set menu button status
        searchButton.setDisable(!searchOn); // set search button status

        // determine whether to call the button's eventhandler, defined by controller implementing MenuActionHandler interface
        menuButton.setOnAction(e -> { if (eventHandler != null && menuOn) eventHandler.onMenuClick();});
        homeButton.setOnAction(e -> { if (eventHandler != null && homeOn) eventHandler.onHomeClick();});
        searchButton.setOnAction(e -> { if (eventHandler != null && searchOn) eventHandler.onSearchClick();});
    }

    /*
     * Setter function to update home button status
     * Takes a single boolean value input to update button status, returns nothing
     */
    public void setHomeOn(boolean input) { this.homeOn = input; }
    
    /*
     * Setter function to update menu button status
     * Takes a single boolean value input to update button status, returns nothing
     */
    public void setMenuOn(boolean input) { this.menuOn = input; }
    
    /*
     * Setter function to update search button status
     * Takes a single boolean value input to update button status, returns nothing
     */
    public void setSearchOn(boolean input) { this.searchOn = input; }

    /*
     * Getter function to evaluate home button status
     * Takes no parameters, returns a single boolean value representing status of button
     */
    public boolean getHomeOn() { return homeOn; }
    
    /*
     * Getter function to evaluate menu button status
     * Takes no parameters, returns a single boolean value representing status of button
     */
    public boolean getMenuOn() { return menuOn; }
    
    /*
     * Getter function to evaluate home button status
     * Takes no parameters, returns a single boolean value representing status of button
     */
    public boolean getSearchOn() { return searchOn; }

    /*
     * Set event handler
     * Takes a MenuActionHandler instance as a parameter, returns nothing
     */
    public void setActionHandler(MenuActionHandler handler) {
        this.eventHandler = handler;
    }
}
