class Spreadsheet {
    Map<String,Integer> map= new HashMap<>();

    public Spreadsheet(int rows) {
        
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        for(int i=0;i<formula.length();i++)
        {
            if(formula.charAt(i)=='+'){
                String n1=formula.substring(0,i),n2=formula.substring(i+1,formula.length());
                int cell1=Character.isUpperCase(n1.charAt(0)) ? map.getOrDefault(n1,0) : Integer.parseInt(n1);
                int cell2=Character.isUpperCase(n2.charAt(0)) ? map.getOrDefault(n2,0) : Integer.parseInt(n2);

                return cell1+cell2;
            }
        }
        return 0;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */