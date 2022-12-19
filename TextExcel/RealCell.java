/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/


public class RealCell extends TextCell implements Cell { // To make code more concise
    
    public RealCell(String contents) {
        super(contents);
    }

    public String getMessage() {
        return super.fullCellText();
    }
 
    public double getDoubleValue() { // Used for all the subclasses
        return Double.parseDouble(super.fullCellText());
    }
}