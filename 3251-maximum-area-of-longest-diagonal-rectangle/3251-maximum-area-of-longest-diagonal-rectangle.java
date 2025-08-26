class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double s=0;
        double maxDia=0;
        for(int []dim:dimensions){
            double len1=dim[0];
            double len2=dim[1];
            double dia=Math.sqrt(len1*len1 + len2*len2);
            
            if(dia > maxDia){
                s=len1*len2;
                maxDia=dia;
            }else if(dia==maxDia){
                s=Math.max(s,len1*len2);
            }
        }

        return (int)s;
    }
}