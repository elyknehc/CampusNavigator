package com.example;
import java.util.*;

public class User {

    private boolean isAdmin;
    private static List<POI> allPOI = new ArrayList<POI>() {
        {
            add(new POI("hey", "yo", "what", "lol", 5, 20, 30, 31, 1, true, true));
            add(new POI("test", "icles", "gay", "lmao", 6, 25, 20, 39, 2, false, true));
}};
    private static List<POI> userPOIList;
    private static List<POI> favouritePOIList;
    private static boolean isEditing;
    private static String curBuilding;
    private static String curFloor;
    private static String curPoi;

    public static List<POI> getAllPOI() {
        System.out.println("ok");
        return allPOI;
    }

    public static void addToAllPOI(POI poi) {
        allPOI.add(poi);
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCurBuilding() {
        return this.curBuilding;
    }

    public void setCurBuilding(String curBuilding) {
        this.curBuilding = curBuilding;
    }

    public String getCurFloor() {
        return this.curFloor;
    }

    public void setCurFloor(String curFloor) {
        this.curFloor = curFloor;
    }

    public String getCurPoi() {
        return this.curPoi;
    }

    public void setCurPoi(String curPoi) {
        this.curPoi = curPoi;
    }

    public boolean getEditing() {
        return this.isEditing;
    }

    public void setEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }
    

    public User(boolean adminStatus) {
        this.isAdmin = adminStatus;
        userPOIList = new ArrayList<POI>();
        favouritePOIList = new ArrayList<POI>();
    }
    
    public void addUserPOI(POI input) {
        userPOIList.add(input);
    }

    public void addFavouritePOI(POI input) {
        favouritePOIList.add(input);
    }

    // ASK GROUP LATER --> isn't this similar to POI.java toString() method?
    /*public void viewPOIInfo() {
    }
    */

    public void deletePOI(POI input) {
        userPOIList.remove(input);
        favouritePOIList.remove(input);       
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean status) {
        isAdmin = status;
    }

}
