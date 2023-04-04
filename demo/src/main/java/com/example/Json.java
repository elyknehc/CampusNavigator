package com.example;
import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

   /**
    * @author Group 51
    *This class is responsible for setting JSON information for built in POIs
    */
class Json {

    /**
     * Read file reads from the POI data json and parses the information, handles any exceptions if file not found
     */
    public static void readFile() {
      String data = "";
      try{
         data = new String(Files.readAllBytes(Paths.get("./demo/src/main/java/com/example/POIData.json")));
         parseJsonToLocalData(data);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Function that writes files to the JSON, creates a new bufferred reader for the program
    */
   public static void writeFile() {
      try{

         //Writes to the JSON with a buffered reader

         String data = stringifyAllPOIData();
      
         File file = new File("./demo/src/main/java/com/example/POIData.json");
 
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(data);
         bw.close();
     }catch(IOException e){
         e.printStackTrace();
     }
   }
   /**
    * Stringifys all of the information from the JSON file to make it readable for a user
    * @return Returns a temporary array to string.
    */
   private static String stringifyAllPOIData() {
      List<POI> poiData = User.getAllPOI();
      JSONArray tempArray = new JSONArray();
      for (POI poi : poiData) {
         tempArray.put(poi.stringify());
      }
      return tempArray.toString();
   } 

   /**
    * Parses the JSON into local information
    * @param json - the information being passed to the local data
    */

   private static void parseJsonToLocalData(String json) {
      JSONArray tempArray = new JSONArray(json);
      for (Object str : tempArray) {
         String cur = str.toString();
         POI poi = POI.toPOI(cur);
         User.addToAllPOI(poi);
      }
      MapScrollPanel.repaintMapPOI();
   }
}
