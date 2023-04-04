package com.example;
import java.util.*;

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
    private static boolean isCreating = true;

    // CHANGED CONSTRUCTOR -- NO BOOLEAN PARAMETER 
    // public User(boolean adminStatus) {
    //     this.isAdmin = adminStatus;
    //     userPOIList = new ArrayList<POI>();
    //     favouritePOIList = new ArrayList<POI>();
    // }

    
    public static List<POI> getFilteredPOI() {
        
        if (filteredCategories.size() == 0) {
            return allPOI;
        }

        List<POI> temp = new ArrayList<POI>();
        for (POI poi : allPOI) {
            if (poi.getBuilding().equals(User.getCurBuilding()) || poi.getFloor() == User.getCurFloor()) {
                if (filteredCategories.contains(poi.getCategory())) {
                    temp.add(poi);
                }
            }
        }
        System.out.println(temp.toString());
        return temp;
    }

    public static void addFilters(List<String> categories) {
        for (String category : categories) {
            if (!filteredCategories.contains(category)) {
                filteredCategories.add(category);      
            }
        }
        MapScrollPanel.repaintMapPOI();
    }

    public static void removeFilters(List<String> categories) {
        for (String category : categories) {
            try{
                filteredCategories.remove(category);    
            }
            catch(Exception e){
                ;
            }
        }
        MapScrollPanel.repaintMapPOI();
    }

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
     * @param poi
     */
    public static void addToAllPOI(POI poi) {
        allPOI.add(poi);
        MapScrollPanel.repaintMapPOI();
    }

    /**
     * Getter method for getting a POI
     * @return boolean if a user returns 
     */
    public static boolean getAdmin() {
        return isAdmin;
    }

    /**
     * 
     * @param newIsAdmin Sets if the user is an admin
     */
    public static void setAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }
    
    /**
     * 
     * @return returns the current building that th euser has selected
     */

    public static String getCurBuilding() {
        return curBuilding;
    }

    /**
     * Sets the new building that the user has selected
     * @param newCurBuilding
     */
    public static void setCurBuilding(String newCurBuilding) {
        curBuilding = newCurBuilding;
    }

    /**
     * Gets the current floor that the user is on, as an integer
     * @return curFloor
     */
    public static int getCurFloor() {
        return curFloor;
    }

    /**
     * Sets the current floor to the floor that has been selected by the user
     * @param newCurFloor
     */
    public static void setCurFloor(int newCurFloor) {
        curFloor = newCurFloor;
    }

    /**
     * Getter method for getting the current poi that the user has selected
     * @return
     */


    public static POI getCurPoi() {
        return curPoi;
    }
    /**
     * Sets the instance variable POI to the new POI that the user has created on the screen
     * @param newCurPoi
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
     * @param newIsEditing
     */

    public static void setEditing(boolean newIsEditing) {
        isEditing = newIsEditing;
    }

    /**
     * Returns the list of UserPois
     * @return list of UserPois
     */

    public static List<POI> getUserPOI() {
        return userPOIList;
    }

    /**
     * Adds a user poi to the list of user created POIs.
     * @param input
     */
    public static void addUserPOI(POI input) {
        userPOIList.add(input);
    }

    /**
     * Returns a list of favorite POIs - getter method
     * @return list of all pois that the user has favorited
     */

    public static List<POI> getFavouritePOI() {
        return favouritePOIList;
    }

    /**
     * Adds favorite POI to the list of favorite POIs of the user.
     * @param input
     */

    public static void addFavouritePOI(POI input) {
        favouritePOIList.add(input);
    }

    // ASK GROUP LATER --> isn't this similar to POI.java toString() method?
    /*public void viewPOIInfo() {
    }
    */

    /**
     * Deletes a user POI that exists.
     * @param input
     */

    public static void deleteUserPOI(POI input) {
        try {
            userPOIList.remove(input);
        } catch (NullPointerException e) {
            ;
        }   
    }

    /**
     * Removes a POI from the favorites list.
     * @param input
     */
    public static void deleteFavouritePOI(POI input) {
        try {
            favouritePOIList.remove(input);
        } catch (NullPointerException e) {
            ;
        }
    }

    /**
     * Delete a default poi, removes it from the list for admins
     * @param input
     */
    public static void deleteDefaultPOI(POI input) {
        try {
            allPOI.remove(input);
        } catch (NullPointerException e) {
            ;
        }
    }

}
