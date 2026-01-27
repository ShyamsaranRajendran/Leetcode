class Solution {
    public String intToRoman(int num) {
        StringBuffer str= new StringBuffer();
        String notations[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int nots[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
         
         for(int i=0;num>0;i++){
            while(num>=nots[i]){
                str.append(notations[i]);
                num=num-nots[i];
            }
         }

      return str.toString();
    }
}