class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isGood(int num){
        
        boolean hasChanged = false;

        while(num!=0){

            if(num==3 || num==4 || num==7){
                return false;
            }

            if(num==2 || num== 5 || num==9 || num==6){
                hasChanged =true;
            }
            num/=10;
        }

        return hasChanged;
    }
}