/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
   
   EC: Error handling
   
   I'm working on the history extra credit so that's why it is commented out
*/

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

// Update this file with your own code
public class TextExcel {
   public static void main(String[] args) {
       // Add your command loop here
       
      Scanner scan = new Scanner(System.in);
      Spreadsheet s = new Spreadsheet();
      
      System.out.println(s.getGridText());      
      System.out.print("Write a cell command: ");
      String x = scan.nextLine();
       
      ArrayList<String> history =  new ArrayList<String>();

      while(!x.toLowerCase().equals("quit")) { // The main loop for the project

         System.out.println(s.processCommand(x));
         System.out.print("Write a cell command, and if you want to quit, type \"quit\": "); // Continuously asks for commands until "quit"
         x = scan.nextLine();
         history.add(x);
      }
      
      System.out.println("Thanks for using TextExcel! Have a great day!");
   }
}
