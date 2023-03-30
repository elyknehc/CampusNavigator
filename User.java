import java.util.*;

public class User {

    private boolean isAdmin;
    public static List<POI> userPOIList;
    public static List<POI> favouritePOIList;

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
