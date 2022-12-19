/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/

// Update this file with your own code

public class SpreadsheetLocation implements Location {
   
   private String cellName;
   private int row;
   private int col;
   
   public SpreadsheetLocation(String cellName) {
        String letter = cellName.substring(0, 1).toLowerCase();
        int num = Integer.parseInt(cellName.substring(1));
        row = num - 1;
 
        switch (letter) {
            case "a":
                this.col = 0;
                break;
            case "b":
                this.col = 1;
                break;
            case "c":
                this.col = 2;
                break;
            case "d":
                this.col = 3;
                break;
            case "e":
                this.col = 4;
                break;
            case "f":
                this.col = 5;
                break;
            case "g":
                this.col = 6;
                break;
            case "h":
                this.col = 7;
                break;
            case "i":
                this.col = 8;
                break;
            case "j":
                this.col = 9;
                break;
            case "k":
                this.col = 10;
                break;
            case "l":
                this.col = 11;
                break;
           }
   }

   @Override
   public int getRow() {
      return row;
   }

   @Override
   public int getCol() {

      return col;
   }
}
