package com.example;

import org.json.*;
import java.io.*;
import java.util.*;

class Json {
   public static void main(String[] args) {
      System.out.println("hello");

      /* 
      JSONObject jo = new JSONObject();
      jo.put("name", "jon doe");
      jo.put("age", "22");
      jo.put("city", "chicago");
      System.out.println(jo.toString());
      */
      /*ArrayList<POI> result = new ArrayList<POI>();

        try{
            String text = new String(Files.readAllBytes(Paths.get("POIData.json")), "StandardCharsets.UTF_8");

            JSONObject obj = new JSONObject(text);
            JSONArray arr = obj.getJSONArray("employees");

            for(int i = 0; i < arr.length(); i++){
                String name = arr.getJSONObject(i).getString("name");
                short salary = Short.parseShort(arr.getJSONObject(i).getString("salary"));
                String position = arr.getJSONObject(i).getString("position");
                byte years_in_company = Byte.parseByte(arr.getJSONObject(i).getString("years_in_company")); 
                if (position.compareToIgnoreCase("manager") == 0){
                    result.add(new Manager(name, salary, position, years_in_company));
                }
                else{
                    result.add(new OrdinaryEmployee(name, salary, position, years_in_company));
                }
            }           
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        */
        String resourceName = "/POIData.json";
        InputStream is = Json.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        System.out.println(object.toString());
        }

        // Michael change
   }
