package com.example;
import java.util.*;

public class User {

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

    public static void setCreating(boolean set) {
        isCreating = set;
    }

    public static List<POI> getAllPOI() {
        return allPOI;
    }

    public static void addToAllPOI(POI poi) {
        allPOI.add(poi);
        MapScrollPanel.repaintMapPOI();
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

    // ASK GROUP LATER --> isn't this similar to POI.java toString() method?
    /*public void viewPOIInfo() {
    }
    */
    public static void deleteDefaultPOI(POI input) {
        try {
            allPOI.remove(input);
        } catch (NullPointerException e) {
            ;
        }
    }

}
