package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
    @Test
    public void testGetIsCreating() {
        System.out.println("getIsCreating");
        boolean expResult = true;
        boolean result = User.getIsCreating();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCreating() {
        System.out.println("setCreating");
        boolean setCreating = false;
        User.setCreating(setCreating);
        boolean result = User.getIsCreating();
        assertEquals(setCreating, result);
    }

    @Test
    public void testGetAllPOI() {
        System.out.println("getAllPOI");
        int expResult = 0;
        int result = User.getAllPOI().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddToAllPOI(){
        System.out.println("addToAllPOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.addToAllPOI(newPOI);
        int expResult = 1;
        int result = User.getAllPOI().size();
        User.deleteDefaultPOI(newPOI);
        assertEquals(expResult, result);
    }

    @Test 
    public void testGetAdmin() {
        System.out.println("getAdmin");
        boolean expResult = false;
        boolean result = User.getAdmin();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAdmin() {
        System.out.println("setAdmin");
        boolean setAdmin = true;
        User.setAdmin(setAdmin);
        boolean result = User.getAdmin();
        assertEquals(setAdmin, result);
    }

    @Test
    public void testGetCurBuilding() {
        System.out.println("getCurBuilding");
        String expResult = "";
        String result = User.getCurBuilding();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCurBuilding() {
        System.out.println("setCurBuilding");
        String curBuilding = "Middlesex";
        User.setCurBuilding(curBuilding);
        String result = User.getCurBuilding();
        User.setCurBuilding("");
        assertEquals(curBuilding, result);
    }

    @Test
    public void testGetCurFloor() {
        System.out.println("getCurFloor");
        int expResult = 0;
        int result = User.getCurFloor();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCurFloor() {
        System.out.println("setCurFloor");
        int curFloor = 2;
        User.setCurFloor(curFloor);
        int result = User.getCurFloor();
        User.setCurFloor(0);
        assertEquals(curFloor, result);
    }

    @Test
    public void testGetCurPOI() {
        System.out.println("getCurPOI");
        POI expResult = null;
        POI result = User.getCurPoi();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCurPOI() {
        System.out.println("setCurPOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.setCurPoi(newPOI);
        POI result = User.getCurPoi();
        User.setCurPoi(null);
        assertEquals(newPOI,result);
    }

    @Test
    public void testGetEditing() {
        System.out.println("getEditing");
        boolean expResult = false;
        boolean result = User.getEditing();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEditing() {
        System.out.println("setEditing");
        boolean editing = true;
        User.setEditing(editing);
        boolean result = User.getEditing();
        assertEquals(editing, result);
    }

    @Test
    public void testGetUserPOI() {
        System.out.println("getUserPOI");
        int expResult = 0;
        int result = User.getUserPOI().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddUserPOI() {
        System.out.println("addUserPOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.addUserPOI(newPOI);
        int expResult = 1;
        int result = User.getUserPOI().size();
        User.deleteUserPOI(newPOI);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFavouritePOI() {
        System.out.println("getFavouritePOI");
        int expResult = 0;
        int result = User.getFavouritePOI().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddFavouritePOI() {
        System.out.println("addFavouritePOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.addFavouritePOI(newPOI);
        int expResult = 1;
        int result = User.getFavouritePOI().size();
        User.deleteFavouritePOI(newPOI);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteUserPOI() {
        System.out.println("deleteUserPOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.deleteUserPOI(newPOI);
        int expResult = 0;
        int result = User.getUserPOI().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteFavouritePOI() {
        System.out.println("deleteFavouritePOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.deleteFavouritePOI(newPOI);
        int expResult = 0;
        int result = User.getFavouritePOI().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteDefaultPOI() {
        System.out.println("deleteDefaultPOI");
        POI newPOI = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        User.deleteDefaultPOI(newPOI);
        int expResult = 0;
        int result = User.getAllPOI().size();
        assertEquals(expResult, result);
    }
    
}
