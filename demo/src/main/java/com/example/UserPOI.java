package com.example;
/**
 * @author Group 51
 * User POI class is inherits the POI class, having an additional isUser boolean
 */
public class UserPOI extends POI {
    public UserPOI(String name, String description, String category, String building, int ID, int x, int y, int roomNum, int floor, boolean isFavourite, boolean isUser) {
        super(name, description, category, building, ID, x, y, roomNum, floor, isFavourite, isUser);
    }
}
