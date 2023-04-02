package com.example;

import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class Json {
   public static void main(String[] args) {
      /*String data = readFile();
      System.out.println(data);
      writeFile(data);
      parseJsonToLocalData(stringifyAllPOIData());
      */
      //readFile();
      parseJsonToLocalData(stringifyAllPOIData());

   }

   public static void readFile() {
      String data = "";
      try{
         data = new String(Files.readAllBytes(Paths.get("/Users/michaelgao/group51/demo/src/main/java/com/example/POIData.json")));
         System.out.println(data);
      } catch (Exception e) {
         System.out.println("File does not exist");
      }
      
      parseJsonToLocalData(data);
   }

   public static void writeFile(String data) {
      try{
      
         File file = new File("../././POIData.json");
 
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(data);
         bw.close();
     }catch(IOException e){
         e.printStackTrace();
     }
   }
   

   private static String stringifyAllPOIData() {
      List<POI> poiData = User.getAllPOI();
      JSONArray tempArray = new JSONArray();
      for (POI poi : poiData) {
         tempArray.put(poi.stringify());
      }
      return tempArray.toString();
   }
   private static void parseJsonToLocalData(String json) {
      JSONArray tempArray = new JSONArray(json);
      for (Object str : tempArray) {
         String cur = (String) str;
         POI poi = POI.toPOI(cur);
         User.addToAllPOI(poi);
      }
      System.out.println(User.getAllPOI());
   }
}
