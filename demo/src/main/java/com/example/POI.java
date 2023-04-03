package com.example;

import org.json.JSONObject;


public class POI {
    private String name, description, category, building;
    private int ID;
    private boolean isFavourite, isUser;
    private int x, y, roomNum, floor;


    //LOCATION OBJECT

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
    public String toString() {
        return "{\n name: " + name + "\n" + " description: " + description + "\n" + " category: " + category
                + "\n" + " building: " + building + "\n" + " ID: " + ID + "\n" + " x: " + x + "\n" + " y: " + y + "\n" 
                + " roomNum: " + roomNum + "\n" + " floor: " + floor + "\n" + " isFavourite: " + isFavourite + "\n" + " isUser: " + isUser + "\n}";
    }

    public String stringify() {
        JSONObject temp = new JSONObject(this);
        return temp.toString();
    }

    public static POI toPOI(String json) {
        JSONObject tempJson = new JSONObject(json);
        return new POI((String) tempJson.get("name"), (String) tempJson.get("description"), (String) tempJson.get("category"), (String) tempJson.get("building"), (int) tempJson.get("ID"), (int) tempJson.get("x"), (int) tempJson.get("y"), (int) tempJson.get("roomNum"), (int) tempJson.get("floor"), (boolean) tempJson.get("isFavourite"), (boolean) tempJson.get("isUser"));
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getIsFavourite() {
        return this.isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public boolean getIsUser() {
        return this.isFavourite;
    }

    public void setIsUser(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

        public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}