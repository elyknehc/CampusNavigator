package com.example;
import java.util.*;

public class User {

    private static boolean isAdmin;
    private static List<POI> allPOI = new ArrayList<POI>() {
        {
            //add(new POI("hey", "yo", "what", "lol", 5, 20, 30, 31, 1, true, true));
            //add(new POI("test", "icles", "gay", "lmao", 6, 25, 20, 39, 2, false, true));
}};
    private static List<POI> userPOIList;
    private static List<POI> favouritePOIList;
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

    public User() {
        userPOIList = new ArrayList<POI>();
        favouritePOIList = new ArrayList<POI>();
    }
    
    public static boolean getIsCreating() {
        return isCreating;
    }

    public static void setCreating(boolean set) {
        isCreating = set;
    }

    public static List<POI> getAllPOI() {
        System.out.println("ok");
        return allPOI;
    }

    public static void addToAllPOI(POI poi) {
        allPOI.add(poi);
    }

    public static boolean getAdmin() {
        return isAdmin;
    }

    public static void setAdmin(boolean newIsAdmin) {
        isAdmin = newIsAdmin;
    }

    public static String getCurBuilding() {
        return curBuilding;
    }

    public static void setCurBuilding(String newCurBuilding) {
        curBuilding = newCurBuilding;
    }

    public static int getCurFloor() {
        return curFloor;
    }

    public static void setCurFloor(int newCurFloor) {
        curFloor = newCurFloor;
    }

    public static POI getCurPoi() {
        return curPoi;
    }

    public static void setCurPoi(POI newCurPoi) {
        curPoi = newCurPoi;
    }

    public static boolean getEditing() {
        return isEditing;
    }

    public static void setEditing(boolean newIsEditing) {
        isEditing = newIsEditing;
    }

    public static List<POI> getUserPOI() {
        return userPOIList;
    }

    public static void addUserPOI(POI input) {
        userPOIList.add(input);
    }

    public static List<POI> getFavouritePOI() {
        return favouritePOIList;
    }

    public static void addFavouritePOI(POI input) {
        favouritePOIList.add(input);
    }

    // ASK GROUP LATER --> isn't this similar to POI.java toString() method?
    /*public void viewPOIInfo() {
    }
    */

    public void deleteUserPOI(POI input) {
        userPOIList.remove(input);   
    }

    public void deleteFavouritePOI(POI input) {
        favouritePOIList.remove(input);
    }

    public void deleteDefaultPOI(POI input) {
        allPOI.remove(input);
    }

}
