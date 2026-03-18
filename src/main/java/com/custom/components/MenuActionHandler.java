package com.custom.components;

/*
 * Defines interface for handling menu bar present across all pages of the app
 */
public interface MenuActionHandler {
	/*
	 * Method for handling click action of 3-Day Forecast Menu button (three bars icon)
	 * Returns nothing, takes no parameters
	 */
    void onMenuClick();
    
    /*
     * Method for handling click action of Search button (magnifying glass icon)
     * Returns nothing, takes no parameters
     */
    void onSearchClick();
    
    /*
     * Method for handling click action of Home button (rounded rectangle icon)
     * Returns nothing, takes no parameters
     */
    void onHomeClick();
}


