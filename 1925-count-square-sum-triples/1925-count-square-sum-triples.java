class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int a=i*i;
                int b=j*j;
                int sum=a+b;
                int c=(int)Math.sqrt(sum);
                if(c<=n && sum == c*c){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}