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
public class SolarSystem {

   private ArrayList<Planet> planets = new ArrayList<Planet>();
   private Sun sun;
   
   public SolarSystem (ArrayList<Planet> planet) { // Creates a new solar system
      this.planets = planet;
  
   }
   
   public String toString() { // Returns the names of the planets of the Solar System
      String returnThs = "";
      for(int i = 0; i < planets.size(); i++) {
         returnThs += planets.get(i).name() + " ";
         
      }
      
      return returnThs; // Returns the string
   }
   
   public void addSun(Sun sun) {
      this.sun = sun;
   }
   
   public void addPlanet(Planet x) { // Adds a planet to the solar System
      planets.add(x);
   } 
   
   public String getClosest() { // Gets the closest planet to the sun
      double distance = 0; // Temp variable
      int temp = 0; // Temp variable
      double[] newList = new double[planets.size()];
      for (int k = 0; k < newList.length; k++) {
         newList[k] = planets.get(k).getOrbitRadius(); // Distances are assigned to indexes
      }
      
      distance = newList[0];
      
      for (int k = 1; k < newList.length; k++) { // This calculates the smallest number of the array
         if (distance > newList[k]) { 
            temp = k; // Temp gets the smallest value
            distance = newList[k]; // The value of distance gets shifted
         }
      }
      String returnThs = "The planet that is closest to the Sun is " + planets.get(temp).name() + ", that has the orbital radius of " + newList[temp] + " miles.";
      return returnThs; // Returns the String telling the planet closest to the sun
   }
   
   public static String getDistanceBetween (Planet a, Planet b) {     
      double distance = Math.abs(a.getOrbitRadius() - b.getOrbitRadius());
      return "The distance between the 2 planets is " + distance;
      
   }
   
   public static double addMass(Planet a, Planet b) { // Adds the mass of 2 planets
      double masses = a.getMass() + b.getMass();
      return masses;
   }
   
   
   
}