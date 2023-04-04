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
     * @param name
     * @param description
     * @param category
     * @param building
     * @param ID
     * @param x
     * @param y
     * @param roomNum
     * @param floor
     * @param isFavourite
     * @param isUser
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
     */
    public String toString() {
        return "{\n name: " + name + "\n" + " description: " + description + "\n" + " category: " + category
                + "\n" + " building: " + building + "\n" + " ID: " + ID + "\n" + " x: " + x + "\n" + " y: " + y + "\n" 
                + " roomNum: " + roomNum + "\n" + " floor: " + floor + "\n" + " isFavourite: " + isFavourite + "\n" + " isUser: " + isUser + "\n}";
    }

    /**
     * Stringifies a JSON object
     * @return
     */

    public String stringify() {
        JSONObject temp = new JSONObject(this);
        return temp.toString();
    }

    /**
     * Changes the POI into json format
     * @param json
     * @return
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
     * @param name of POI
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
     * @param description of POI
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
     * @param category
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
     * @param building
     */

    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Getter method for getting POI id
     * @return
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Setter method for setting a POis ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Getter method for if the POI is favorite
     * @return
     */
    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    /**
     * Setter method for setting a POI being favorite
     * @param isFavourite
     */
    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    /**
     * Getter method for if the POI is a user created POI or not 
     * @return
     */
    public boolean getIsUser() {
        return this.isUser;
    }

    /**
     * Setter method for declaring if the POI has been created by a user 
     * @param isUser
     */
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    /**
     * Getter method for the X coordinate of the POI
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setter method of setting the X coordinate of the POI
     * @param x
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter method for getting the Y coordinate of POI
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter method of setting the Y coordinate of POI
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getting the room number of POI
     * @return roomNum
     */
    public int getRoomNum() {
        return this.roomNum;
    }

    /**
     * Setting the room number of the POI that it is in 
     * @param roomNum
     */

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * Getting the floor of the POI
     * @return floor
     */
    public int getFloor() {
        return this.floor;
    }

    /**
     * Setting the floor of the POI
     * @param floor
     */

    public void setFloor(int floor) {
        this.floor = floor;
    }

}