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
import java.util.Scanner;

public class Astronomer {

   public static void main(String[] args) {
   
      // Age, orbital radius, days in year, mass, name
      // Tjese are all of the planets
      Planet venus = new Planet(22345576.2, 70002.3, 221, 4.567E21, "Venus");
      Planet mercury = new Planet(10885.0, 102.0, 109, 1.087E18, "Mercury");
      Planet earth = new Planet(454396947.0, 10000.5, 365, 5.972E24, "Earth");
      Planet jupiter = new Planet(12346858.08, 1209763.235, 2345,  29.235E26, "Jupiter");
      Planet saturn = new Planet(12456098.08, 10194768.08, 2098, 25.385E20, "Saturn");
      Planet neptune = new Planet(128576050.12, 229292929.09, 4857, 1.024E26, "Neptune");
      
      
      ArrayList<Planet> list = new ArrayList<Planet>(); // List of planets
      list.add(venus);
      list.add(mercury);
      list.add(earth);
      list.add(jupiter);
      list.add(saturn);
      list.add(neptune);
      
      
      SolarSystem newSystem = new SolarSystem(list);
      Sun sun = new Sun(4603000000.0, "Sun", 1.989E30, 1327000, newSystem, list);
      newSystem.addSun(sun);
      
      System.out.println("\n" + "Solar System: " + newSystem.toString());
      System.out.println("Here are some facts about planets in our solar system!" + "\n");
      
      for(int i = 0; i < list.size(); i++) { // Lists facts about the planets using the toString method
         System.out.println("---> " + list.get(i).toString() + "\n");   
      }      
      System.out.println("Closest planet to the Sun: " + newSystem.getClosest()); // Closest planet to the sun
      System.out.println("Distance between Earth and Mercury: " + newSystem.getDistanceBetween(list.get(2), list.get(1))); // Distance between
      System.out.println("Here are the masses of Neptune and Jupiter added together: " + newSystem.addMass(list.get(3), list.get(5))); // Added mass of planets
      System.out.println("Lets compare these planets to the Sun!!!: ");
      
      for(int i = 0; i < list.size(); i++) {
         System.out.println("\n" + "--->" + sun.howMuchBiggerMass(list.get(i)));
         System.out.println("--->" + sun.howMuchOlder(list.get(i)));
      }
   }
}