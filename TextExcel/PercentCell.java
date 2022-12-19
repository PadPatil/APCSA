/*
   Padmanabh Patil
   TextExcel Checkpoint A3
   Mr. Stutler
*/

public class PercentCell extends RealCell{

    //sends this to RealCell
    public PercentCell(String c) {
        super(c);
    }
 

    public String abbreviatedCellText() {
    
        double temp = Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length() - 1));

        int convertInt = (int) temp;
        String returnThs = convertInt + "%";
        
        int newLen = 10 - returnThs.length();
        for (int i = 0; i < newLen; i++) {
            returnThs += " ";
        }
 
        return returnThs;
    }

    public String fullCellText() {
        Double returnThs = Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length() - 1)); // Primitive type
        return returnThs + "%";
    }
 

    public double getDoubleValue() { // Method overriding
        String returnThs = super.fullCellText().substring(0, super.fullCellText().length() - 1);
        Double answer = Double.parseDouble(returnThs);     
        return answer / 100.0;
    }
}