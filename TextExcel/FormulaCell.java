/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/


public class FormulaCell extends RealCell {
  
   private boolean invalid = false;
   
     
   public FormulaCell(String str) {
      super(str);
   }
 
   public double getDoubleValue() {

        try {
            String[] wordChunks = super.getMessage().split(" ");
            double returnThs= Double.parseDouble(wordChunks[1]);
 
            for (int i = 2; i < wordChunks.length; i += 2) {
            
                if (wordChunks[i].equals("+")) {
                    returnThs += Double.parseDouble(wordChunks[i + 1]);
                }
                
                else if (wordChunks[i].equals("-")) {
                    returnThs -= Double.parseDouble(wordChunks[i + 1]);
                }
                
                else if (wordChunks[i].equals("*")) {
                    returnThs *= Double.parseDouble(wordChunks[i + 1]);
                }
                
                else if (wordChunks[i].equals("/")) {
                    returnThs /= Double.parseDouble(wordChunks[i + 1]);
                }
 
            }
 
            return returnThs;
        }
 
        catch (Exception except) {
            this.invalid = true;
            return 0.0;
        }
   }
   
    
    public String abbreviatedCellText() {
        String returnThs = getDoubleValue() + ""; // This
        
        int subtract = 10 - returnThs.length();
 
        for (int i = 0; i < subtract; i++) {
            returnThs += " ";
        }
 
        if (returnThs.length() > 10) {
            return returnThs.substring(0, 10);
        }
        
        else {
            return returnThs;
        }
    }
 
    public String fullCellText() {
        return super.getMessage();
    }
 
    public boolean isInvalid() {
        return invalid;
    }
   
}