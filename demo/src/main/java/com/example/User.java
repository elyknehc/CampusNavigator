package com.example;
import java.util.*;
import javax.swing.plaf.metal.MetalFileChooserUI.FilterComboBoxRenderer;

/**
 * @author Group 51
 * A user class represents the user that is currently logged on and the POI list that they have created. 
 */
public class User {

    //Declare instance variables
    private static boolean isAdmin;
    private static List<POI> allPOI = new ArrayList<POI>();
    private static List<String> filteredCategories = new ArrayList<String>();
    private static boolean isEditing;
    private static String curBuilding;
    private static int curFloor;
    private static POI curPoi;
    private static boolean isCreating;
    
    /**
     * Class that initializes the filtered categories for the user by inserting the POI categories that cannot be removed from the map
     */
    public static void initialize() {
        filteredCategories.add("washrooms");
        filteredCategories.add("elevators");
    }
    
    /**
     * Class that retrieves the list of POIs that matches with the filter restrictions
     */
    public static List<POI> getFilteredPOI() {
        List<POI> temp = new ArrayList<POI>();
        if (filteredCategories.size() <= 2) {
            for (POI poi : allPOI) {
                if (filteredCategories.contains("favourites") && poi.getIsFavourite()) {
                    temp.add(poi);
                }
                if (filteredCategories.contains("userCreatedPOIs") && poi.getIsUser()) {
                    temp.add(poi);
                }
                if (poi.getBuilding().equals(User.getCurBuilding()) && poi.getFloor() == User.getCurFloor()) {
                    temp.add(poi);
                }
            }
            if (User.getCurPoi() != null) {
                temp.add(User.getCurPoi());
            }
            return temp;
        }

        for (POI poi : allPOI) {
            if (poi.getBuilding().equals(User.getCurBuilding()) && poi.getFloor() == User.getCurFloor()) {
                if (filteredCategories.contains("favourites") && poi.getIsFavourite()) {
                    temp.add(poi);
                }
                if (filteredCategories.contains("userCreatedPOIs") && poi.getIsUser()) {
                    temp.add(poi);

                }
                if (filteredCategories.contains(poi.getCategory())) {
                    temp.add(poi);
                }
            }
        }
        if (User.getCurPoi() != null) {
            temp.add(User.getCurPoi());
        }
        return temp;
    }

    /**
     * Method adds a new filter to check for into the list and updates the GUI
     * @param categories new updated list of filters
     */
    public static void addFilters(List<String> categories) {
        for (String category : categories) {
            if (!filteredCategories.contains(category)) {
                filteredCategories.add(category);
            }
        }
        MapScrollPanel.repaintMapPOI();
    }

    /**
     * Method removes a filter to check for from the list and updates the GUI
     * @param categoties new updated list of filters
     */
    public static void removeFilters(List<String> categories) {
        for (String category : categories) {
            try {
                filteredCategories.remove(category);
            } catch (Exception e) {
                ;
            }
        }
        MapScrollPanel.repaintMapPOI();
    }

    /** 
     * Method to see whether the program is in the stage of creating a new POI
     * @return boolean value represening whether the program is currently creating a new POI
     */
    public static boolean getIsCreating() {
        return isCreating;
    }

    /**
     * Setter method for setting if a user is creating
     * @param sets the boolean of the user if they are creating
     */
    public static void setCreating(boolean set) {
        isCreating = set;
    }

    /**
     * getAllPOI returns all POIs
     * @return allPOI returns all POIs 
     */
    public static List<POI> getAllPOI() {
        return allPOI;
    }

    /**
     * Adds a POI to the map scroll panel then repaints it
     * @param poi new POI
     */
    public static void addToAllPOI(POI poi) {
        allPOI.add(poi);
        MapScrollPanel.repaintMapPOI();
    }

    /**
     * Removes a POI from the list of all POIs
     * @param poi POI to be removed
     */
    public static void removeFromAllPOI(POI poi) {
        try {
            allPOI.remove(poi);
            MapScrollPanel.repaintMapPOI();
        } catch (Exception e) {
            ;
        }
    }

    /**
     * Getter method for getting a POI
     * @return boolean if a user returns 
     */
    public static boolean getAdmin() {
        return isAdmin;
    }

    /**
     * Method updates the admin status 
     * @param newIsAdmin Sets if the user is an admin
     */
    public static void setAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }
    
    /**
     * Method retrieves the current building
     * @return returns the current building that the user has selected
     */

    public static String getCurBuilding() {
        return curBuilding;
    }

    /**
     * Sets the new building that the user has selected
     * @param newCurBuilding new building that the user selected
     */
    public static void setCurBuilding(String newCurBuilding) {
        curBuilding = newCurBuilding;
    }

    /**
     * Gets the current floor that the user is on, as an integer
     * @return current floor that the user is on
     */
    public static int getCurFloor() {
        return curFloor;
    }

    /**
     * Sets the current floor to the floor that has been selected by the user
     * @param newCurFloor new floor that the user has selected
     */
    public static void setCurFloor(int newCurFloor) {
        curFloor = newCurFloor;
    }

    /**
     * Getter method for getting the current POI that the user has selected
     * @return current POI that the user has selected 
     */
    public static POI getCurPoi() {
        return curPoi;
    }
    /**
     * Sets the instance variable POI to the new POI that the user has created on the screen
     * @param newCurPoi new POI that the user has selected
     */
    public static void setCurPoi(POI newCurPoi) {
        curPoi = newCurPoi;
    }

    /**
     * Return if the user is in editing mode as a boolean
     * @return isEditing variable
     */
    public static boolean getEditing() {
        return isEditing;
    }

    /**
     * Sets the editing variable to if the user is editing (setter method)
     * @param newIsEditing new status of whether the user is editing or not
     */
    public static void setEditing(boolean newIsEditing) {
        isEditing = newIsEditing;
    }

    /**
     * Delete a default poi, removes it from the list for admins
     * @param input POI to be deleted
     */
    public static void deleteDefaultPOI(POI input) {
        try {
            allPOI.remove(input);
            MapScrollPanel.repaintMapPOI();
        } catch (NullPointerException e) {
            ;
        }
    }

}
