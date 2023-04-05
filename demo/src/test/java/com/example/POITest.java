package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class POITest {
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        String expResult = "Middlesex";
        String result = instance.getBuilding();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        String expResult = "Washroom";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        String expResult = "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    } 

    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        int expResult = 1;
        int result = instance.getFloor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIsFavourite() {
        System.out.println("getIsFavourite");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        boolean expResult = true;
        boolean result = instance.getIsFavourite();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIsUser() {
        System.out.println("getIsUser");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        boolean expResult = false;
        boolean result = instance.getIsUser();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        String expResult = "Men's washroom";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRoomNum() {
        System.out.println("getRoomNum");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        int expResult = 136;
        int result = instance.getRoomNum();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetX() {
        System.out.println("getX");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        int expResult = 5;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetY() {
        System.out.println("getY");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        int expResult = 10;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        String building = "University College";
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setBuilding(building);
        String result = instance.getBuilding();
        assertEquals(building, result);
    }

    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "Classroom";
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setCategory(category);
        String result = instance.getCategory();
        assertEquals(category, result);
    }

    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Another room";
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setDescription(description);
        String result = instance.getDescription();
        assertEquals(description, result);
    }

    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        int floor = 2;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setFloor(floor);
        int result = instance.getFloor();
        assertEquals(floor, result);
    }

    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 2;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setID(ID);
        int result = instance.getID();
        assertEquals(ID, result);
    }

    @Test
    public void testSetIsFavourite() {
        System.out.println("setIsFavourite");
        boolean floor = false;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setIsFavourite(floor);
        boolean result = instance.getIsFavourite();
        assertEquals(floor, result);
    }

    @Test
    public void testSetIsUser() {
        System.out.println("setIsUser");
        boolean isUser = true;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setIsUser(isUser);
        boolean result = instance.getIsUser();
        assertEquals(isUser, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setFloor");
        String name = "Lecture room";
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    @Test
    public void testSetRoomNum() {
        System.out.println("setRoomNum");
        int roomNum = 222;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setRoomNum(roomNum);
        int result = instance.getRoomNum();
        assertEquals(roomNum, result);
    }

    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 100;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setX(x);
        int result = instance.getX();
        assertEquals(x, result);
    }

    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 200;
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        instance.setY(y);
        int result = instance.getY();
        assertEquals(y, result);
    }


    @Test
    public void testToString() {
        System.out.println("toString");
        POI instance = new POI("Men's washroom", "Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair.", "Washroom", "Middlesex", 1, 5, 10, 136, 1, true, false);
        String expResult = "Men's washroom                                                                Men's washroom located on the first floor of Middlesex College. Accessible by wheelchair. Washroom Middlesex 136 1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
