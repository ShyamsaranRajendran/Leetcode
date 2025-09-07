class Solution {
    public int[] sumZero(int n) {
        int ind=0;
        int res[]=new int[n];

        for(int i=1;i<=n/2;i++){
            res[ind++]=i;
            res[ind++]= -1*i;
        }
        if(n%2==1){
            res[ind]=0;
        }
        return res;
    }
}