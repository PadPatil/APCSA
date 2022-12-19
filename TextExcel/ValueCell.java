/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/

public class ValueCell extends RealCell {
    public ValueCell(String contents) {
        super(contents);
    }
    
    public String abbreviatedCellText() {
    

        String temp = Double.parseDouble(super.getMessage())+ "";
        int newLen = 10 - temp.length();

        for (int i = 0; i < newLen; i++) {
            temp += " ";
        }

        if (super.getMessage().length() > 10) {
            return temp.substring(0, 10);
        }

        return temp;
    }
    
    
    public String fullCellText() {
        Double returnThs =  Double.parseDouble(super.getMessage());
        return returnThs + "";
    }
}