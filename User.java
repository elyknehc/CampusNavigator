import java.util.*;

public class User {

    private boolean isAdmin;
    public static List<POI> userPOIList;
    public static List<POI> favouritePOIList;
    public static boolean isCreating = false;

    public static boolean cancelled;

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

    public static void setIsCreating(boolean set) {
        isCreating = set; 
    }

    public static boolean getIsCreating () {
        return isCreating;
    }

    public static void setCancel(boolean set) {
        cancelled = set; 
    }

    public static boolean getCancel () {
        return cancelled;
    }
}

