/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/


public class TextCell implements Cell {
   private String contents;
   
   public TextCell (String text) {
      if (text.isEmpty()){
         throw new IllegalArgumentException ("Cell text cannot be null/empty");
      }
      this.contents = text;
   }
   
   public void setVal (String val) {
      this.contents = val;
   }
   
   public String abbreviatedCellText(){
           

        String returnThs = "";
        int len = contents.length();
        
      
        if (contents.contains("\"")) { // If there is a quotee....
            returnThs = contents.substring(1, contents.length() - 1);
            len = contents.length() - 2;
        }
 
        else {
            returnThs = contents;
        }

        if (len >= 11) { // If it;s more than 10 chars
            return returnThs.substring(0, 10);
        }
 
        String str = "";
 
        str = returnThs;
        int remainder = 10 - len;
        for (int i = 0; i < remainder; i++) {
            str += " ";
        }
 
        return str;
   }
   
   // text for individual cell inspection, not truncated or padded
   public String fullCellText(){
      return contents;
   }
   
}