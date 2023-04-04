package com.example;

import org.json.JSONObject;

/**
 * POI class for user to set information of a point of interest
 * @author Group 51
 */
public class POI {

    //Set up instance variables
    private String name, description, category, building;
    private int ID;
    private boolean isFavourite, isUser;
    private int x, y, roomNum, floor;


    //LOCATION OBJECT


    /**
     * Constructor to create a new point of interest object.
     * @param name Name of the POI
     * @param description Description of the POI
     * @param category Category of the POI type
     * @param building Building type of POI
     * @param ID POI's ID
     * @param x Cooridnate of POI
     * @param y Coordinate of POI
     * @param roomNum - Number of the Room of POI
     * @param floor - Floor number of the POI
     * @param isFavourite - If User had selected Favorite for POI
     * @param isUser - If the User is an admin or a normal user
     */
    public POI(String name, String description, String category, String building, int ID, int x, int y, int roomNum, int floor, boolean isFavourite, boolean isUser) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.building = building;
        this.ID = ID;
        this.isFavourite = isFavourite;
        this.isUser = isUser;
        this.x = x;
        this.y = y;
        this.roomNum = roomNum;
        this.floor = floor;
    }

    @Override

    /**
     * ToString method for the object. Prints the information of the POI.
     * @return string representation of the POI
     */
    public String toString() {
        return name + "                                                                " + description + " " + category + " " + building + " " + roomNum + " " + floor;
    }

    /**
     * Stringifies a JSON object
     * @return Returns JSON
     */
    public String stringify() {
        JSONObject temp = new JSONObject(this);
        return temp.toString();
    }

    /**
     * Changes the POI into json format
     * @param json of a POI
     * @return Returns the POI as a string instead of JSON
     */
    public static POI toPOI(String json) {
        JSONObject tempJson = new JSONObject(json);
        return new POI((String) tempJson.get("name"), (String) tempJson.get("description"), (String) tempJson.get("category"), (String) tempJson.get("building"), (int) tempJson.get("ID"), (int) tempJson.get("x"), (int) tempJson.get("y"), (int) tempJson.get("roomNum"), (int) tempJson.get("floor"), (boolean) tempJson.get("isFavourite"), (boolean) tempJson.get("isUser"));
    }
    
    /**
     * Getter method for getting the name of the POI
     * @return POI name 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method for setting the name
     * @param name name of POI
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method of description of POI
     * @return POI description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter method for description of POI
     * @param description description of POI
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method of the POI category
     * @return Category of the POI
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Setter method of category 
     * @param category categoty of POI
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter method of the building that the user is on
     * @return building that the user is on
     */
    public String getBuilding() {
        return this.building;
    }
    /**
     * Setter method for the users building
     * @param building - building of POI
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Getter method for getting POI id
     * @return ID of POI
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Setter method for setting a POis ID
     * @param ID - ID of POI
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter method for if the POI is favorite
     * @return if the POI is favorite or not
     */
    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    /**
     * Setter method for setting a POI being favorite
     * @param isFavourite boolean representing whether the POI is favourited or not
     */
    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    /**
     * Getter method for if the POI is a user created POI or not 
     * @return User - if the user is admin 
     */
    public boolean getIsUser() {
        return this.isUser;
    }

    /**
     * Setter method for declaring if the POI has been created by a user 
     * @param isUser - if user is admin or not
     */
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    /**
     * Getter method for the X coordinate of the POI
     * @return x - x cooridinate of POI
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setter method of setting the X coordinate of the POI
     * @param x - Sets X coordinate
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter method for getting the Y coordinate of POI
     * @return y - Y coordinate of POI
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter method of setting the Y coordinate of POI
     * @param y - Sets y coordinate of POI
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getting the room number of POI
     * @return roomNum - Room number of POI
     */
    public int getRoomNum() {
        return this.roomNum;
    }

    /**
     * Setting the room number of the POI that it is in 
     * @param roomNum - Room number of POI
     */
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * Getting the floor of the POI
     * @return floor - Returns floor number
     */
    public int getFloor() {
        return this.floor;
    }

    /**
     * Setting the floor of the POI
     * @param floor - Sets floor 
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

}