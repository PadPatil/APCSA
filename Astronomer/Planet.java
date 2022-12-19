/*
   Padmanabh Patil
   Solar System Lab
   29 January 2020
   EXTRA CREDIT: 
   ---> Distance between 2 planets
   ---> Adds the mass of 2 planets together
   ---> The sun class
*/

public class Planet {

   
   // These are all the fields the planet class shall have
   private double age;
   private double orbitRad;
   private int dayInYr;
   private double mass;
   private String name;
   
   public void setOrbitRadius(double radius) { // Sets the orbital radius. MUTATOR
      this.orbitRad = radius;
   }
   public double getOrbitRadius() { // Gets the orbital radius. ACCESSOR
      return this.orbitRad;
      
   }
   
   public double getMass() { // Gets the mass
      return this.mass;
   }
   
   public String name() { // Returns the name of the planet
      return this.name;
   }

   public double age() {
      return this.age;
   }   
   
   public Planet(double age, double orbitRad, int dayInYr, double mass, String name) { // The first constructor for planet
      this.age = age;
      this.orbitRad = orbitRad;
      this.dayInYr = dayInYr;
      this.mass = mass;
      this.name = name;
      
   }
   
      
   public Planet(double age, double orbitRad, int dayInYr, double mass) { // An overload of the class planet
      this(age, orbitRad, dayInYr, mass, "planet");
      }
           
   
   
   
   
   public String toString() { // Returns the planet's name, age, and days in year
      String a = "" + "The planet " + name + " is " + age + " years old, with " + dayInYr + " days in it's year.";
      return a;
   }
}