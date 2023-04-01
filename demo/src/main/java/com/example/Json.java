package com.example;

import org.json.JSONObject;

class Json {
   public static void main(String[] args) {
      System.out.println("hello");
      JSONObject jo = new JSONObject();
      jo.put("name", "jon doe");
      jo.put("age", "22");
      jo.put("city", "chicago");
      System.out.println(jo.toString());
   }
   
   //ARSALAAN CHANGES
}