/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/


public class EmptyCell implements Cell {
   private String contents;
   
   public EmptyCell () {
      this.contents = "          ";
   }
   
   // text for spreadsheet cell display, must be exactly length 10
   public String abbreviatedCellText(){
      return contents;
   }

   
   
   // text for individual cell inspection, not truncated or padded
   public String fullCellText(){
      return "";
   }
   
}