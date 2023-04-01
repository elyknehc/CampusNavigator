package com.example;

import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class Json {

   public static String readFile() {
      String data = "";
         try{
            data = new String(Files.readAllBytes(Paths.get("../././POIData.json")));
         } catch (Exception e) {
            System.out.println("File does not exist");
         }
         return data;
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
   public static void main(String[] args) {
      String data = readFile();
      System.out.println(data);
      writeFile(data);
   }
}
