/*
   Padmanabh Patil
   Solar System Lab
   29 January 2020
   EXTRA CREDIT: 
   ---> Distance between 2 planets
   ---> Adds the mass of 2 planets together
   ---> The sun class
*/


import java.util.ArrayList;
public class Sun {

   // The Sun class has name, mass, diameter, solar system, planets, and age as it's fields
   private String name;  
   private double mass;
   private double diameter;
   private SolarSystem newSystem;
   private ArrayList<Planet> planets;
   private double age;
   
   public Sun(double age, String name, double mass, double diameter, SolarSystem newSystem, ArrayList<Planet> planets) { // The constructor
      this.name = name;
      this.mass = mass;
      this.diameter = diameter;
      this.newSystem = newSystem;
      this.planets = planets;
      this.age = age;
   }
   
   public  String howMuchBiggerMass(Planet a) { // How many times is the sun bigger than these planets?
      int index = 0;
      String returnThs = "";
      for(int i = 0; i < planets.size(); i++) { // Finds what index in the arrayList is planet a
         if(a.name().equals(planets.get(i).name())) {
            index = i;
         }
      }
      double divide = mass / planets.get(index).getMass(); // Divides the planet mass by the sun's mass
      returnThs = "The sun is " + divide + " times bigger than " + planets.get(index).name();
      return returnThs;
      
   }
   
   public String howMuchOlder(Planet a) { // Calculates how much older the sun is than the planets
      
      int index = 0;
      double subtract = 0;
      for(int i = 0; i < planets.size(); i++) { // Finds the index in the arrayList of planet a
         if(a.name().equals(planets.get(i).name())) {
            index = i;
         }
      }
      
     subtract = age - planets.get(index).age();
     
     if(subtract > 0) { // If the sun is older
         return "The sun is " + subtract + " years older than " + planets.get(index).name();
     }
     else if(subtract < 0) { // If the sun is younger
         return "The sun is " + (subtract * -1) + " years younger than " + planets.get(index).name();
     }
     else { // If they're the same age
         return "The sun and " + planets.get(index).name() + " are the same age";
     }
     
     
   }
   
}