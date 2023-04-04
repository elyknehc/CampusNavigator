package com.example;
public class FavouritePOI extends POI {
    /**
     * @author Group 51
     * This class inherits the POI class. It represents a favorite POI of the user
     */
    public FavouritePOI(String name, String description, String category, String building, int ID, int x, int y, int roomNum, int floor, boolean isFavourite, boolean isUser) {
        super(name, description, category, building, ID, x, y, roomNum, floor, isFavourite, isUser);
    }
}
