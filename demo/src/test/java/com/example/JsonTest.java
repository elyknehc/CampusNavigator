package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.Test;

public class JsonTest {
    @Test
    public void testReadFile(){
        System.out.println("readFile");
        Json.readFile();
        int expResult = 0;
        int result = User.getAllPOI().size();
        //assertNotEquals(expResult, result);
        assertEquals(expResult, result);
    }

    @Test
    public void testWriteFile() {
        System.out.println("writeFile");
        Json.writeFile();
        int expResult = 0;
        Json.readFile();
        int result = User.getAllPOI().size();
        assertEquals(expResult, result);
    }
    
}
