/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/

// Update this file with your own code

public class Spreadsheet implements Grid {

   private Cell[][] cells;

   public Spreadsheet() {
      Cell[][] cellList = new Cell[20][12];  // Makes a new array, based on the dimensions of the exel spreadsheenewCell 
      
      for(int i = 0; i < 20 ; i++) { /// I'm now using a for loop to make the CellList
         for(int j = 0 ; j < 12 ; j++ ) {
            cellList[i][j] = new EmptyCell();
         }
      }
      
      this.cells = cellList; // Assigns the array made to the cells field 
   }

   @Override
   public String processCommand(String command) {
       // TODO Auto-generated method stub
      String[] wordChunks = command.split(" ");

        try { // A new trick I learned, it first compiles the code in here, and then if there is an error it goes to the "catch"
            if(command.equals("")) {// If there is an empty string..
                return "";
            }
 
 
            if(wordChunks.length == 1) { // When there is only 1 word
                if(command.toLowerCase().equals("clear")) {
                    for (int i = 0; i < getRows(); i++) {
                        for (int j = 0; j < getCols(); j++) {
                            cells[i][j] = new EmptyCell();
                        }
                    }
 
                    return getGridText();
                }

                else if(command.length() == 2 || command.length() == 3) { // If that word is not clear, just return the value fo the cell
                    SpreadsheetLocation newLocation = new SpreadsheetLocation(command);
                    return cells[newLocation.getRow()][newLocation.getCol()].fullCellText();
                }
            }
 
            else {
            
                 if(wordChunks[1].equals("=")) { // If the user is assigning something...
                    char checkForCols = wordChunks[0].toLowerCase().charAt(0);
                    int checkForRows = Integer.parseInt(wordChunks[0].substring(1));
 
                    if(checkForCols > 'l') { // If the column is "greater" than the character "l" or rows are more than 20
                        return "ERROR: Please enter a valid column, between A and L.";
                    }
                    else if(checkForRows > 20) {
                        return "ERROR: Please enter a valid row number, between 1 and 20";
                    }
 
                    //assign to string value
                    SpreadsheetLocation newLocation = new SpreadsheetLocation(wordChunks[0]);
                    int newLocRow = newLocation.getRow();
                    int newLocCol = newLocation.getCol();
 
                    Cell newCell;
                    if(wordChunks.length == 3) {
                        if(command.contains("\"")) { // If there are quotes
                            int quoteVal = command.indexOf("\""); // Finds the index of the first quote
                            String restOfStr = command.substring(quoteVal + 1); // Gets the rest of the string
                            
                            if(!restOfStr.contains("\"")) {
                                return "ERROR: You cannot have only 1 quote in the String. Please enter a valid String.";
                            }
 
                            newCell= new TextCell(wordChunks[2]);
                        }

                        else if(command.contains("%")) { // If we are dealing with a percent
                            newCell= new PercentCell(wordChunks[2]); // Assign to a PercentCell
                        } else { // The only other option is a valueCell
                            newCell= new ValueCell(wordChunks[2]);
                        }
 
                        cells[newLocRow][newLocCol] = newCell; 
                        return getGridText();
                    } 
                    else if(wordChunks.length > 3) {
                    
                        if(command.contains("\"")) {
                            int assign = command.indexOf("\"");
                            String strNeeded = command.substring(assign);
 
                            Cell cell2= new TextCell(strNeeded);
                            cells[newLocRow][newLocCol] = cell2;
                            return getGridText();
                        }
                        
                         
                        else if (command.contains("(")) {
                        
                            String newStr = "";
                            
                            for (int i = 2; i < wordChunks.length; i++) {
                                newStr += wordChunks[i] + " ";
                            }
 
                            Cell newCell2 = new FormulaCell(newStr.substring(0, newStr.length() - 1));
                            cells[newLocRow][newLocCol] = newCell2;
 
     
                            FormulaCell newFormulaCell = new FormulaCell(newStr.substring(0, newStr.length() - 1));
                            
                            if (newFormulaCell.isInvalid()) {
                            
                                cells[newLocRow][newLocCol] = new EmptyCell();
                                return "ERROR: Your command was invalid. Please try again.";
                                
                            }
 
                            return getGridText();
                        }
                    }
                }
 

                else if(wordChunks[0].toLowerCase().equals("clear")) { // To clear a certain cell
                
                    SpreadsheetLocation newLocation = new SpreadsheetLocation(wordChunks[1]);
                    int newLocRow = newLocation.getRow();
                    int newLocCol = newLocation.getCol();
                    cells[newLocRow][newLocCol] = new EmptyCell();
 
                    return getGridText();
                }
            }
 
            return "ERROR: Please enter a valid command.";
        }
        
        catch (Exception except) {
            return "ERROR: Your command was not understood. Pleade enter a valid command.";
        }
   }

   

   @Override
   public int getRows() { // Number of rows
      return 20;
   }

   @Override
   public int getCols() { // Number of columns
      return 12;   
   
   }

   @Override
   public Cell getCell(Location loc) {
      // TODO Auto-generated method stub
      return cells[loc.getRow()][loc.getCol()];
   }

   @Override
   public String getGridText() {
   
       // This string made the top layer, the indicator if the column 
      String returnThs = "";
   
        // FirsnewCellline
      returnThs += "   |";
      for(int col = 0; col < getCols(); col++) { // This prints ounewCellthe firsnewCellrow- the "A   | B       |C         |
         returnThs += ((char)('A' + col));
         returnThs += "         |";
      }
      returnThs += "\n"; // On a new line..
 
      for(int row = 0; row < getRows(); row++) { // This prints ounewCell each and every remaining rows
      
         int rowNumber = row + 1;
         returnThs += rowNumber;
            
         if(rowNumber < 10) {
            returnThs += "  |";
         }
         else {
            returnThs += " |";
         }
      
         for(int col = 0; col < getCols(); col++) {
            returnThs += cells[row][col].abbreviatedCellText() + "|"; // We have to only display 10 chars for each cell so abbreviatedCellText()
         }
      
         returnThs += "\n"; // New row
      }
    
      return returnThs; // Returns the spreadsheet
   }
}