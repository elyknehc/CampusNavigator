package com.example;

import org.json.JSONObject;


public class POI {
    private String name, description, category;
    private int ID;
    private boolean isFavourite, isUser;

    public static void main(String[] args) {
        POI x = new POI("hey", "yo", "what", 5, true, true);
        System.out.println(POI.toPOI(x.stringify()));
    }
    
    

    public POI(String name, String description, String category, int ID, boolean isFavourite, boolean isUser) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.ID = ID;
        this.isFavourite = isFavourite;
        this.isUser = isUser;
    }

    @Override
    public String toString() {
        return "POI Info:\n name: " + name + "\n" + " description: " + description + "\n" + " category: " + category
                + "\n" + " isFavourite: " + isFavourite + "\n" + " isUser: " + isUser + "\n" + " id: " + ID;
    }

    public String stringify() {
        JSONObject temp = new JSONObject(this);
        return temp.toString();
    }

    public static POI toPOI(String json) {
        JSONObject tempJson = new JSONObject(json);
        System.out.println(tempJson.get("name"));
        return new POI((String) tempJson.get("name"), (String) tempJson.get("description"), (String) tempJson.get("category"), (int) tempJson.get("ID"), (boolean) tempJson.get("isFavourite"), (boolean) tempJson.get("isUser"));
        // POI temp = new POI();
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

}