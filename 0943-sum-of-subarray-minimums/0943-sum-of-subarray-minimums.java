class Solution {
    public int sumSubarrayMins(int[] arr) {
      int mod=1000000007;
      int n=arr.length;
      int[] next=new int[n];  
      int[] prev=new int[n]; 
    Stack<Integer> s=new Stack<>();
    for(int i=n-1;i>=0;i--){
        while(!s.isEmpty() && arr[s.peek()]>arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            next[i]=n;
        }
        else{
            next[i]=s.peek();
        }
        s.push(i);
    }
    s.clear();
    for(int i=0;i<n;i++){
        while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            prev[i]=-1;
        }
        else{
            prev[i]=s.peek();
        }
        s.push(i);
    }
    long ans=0;
    for(int i=0;i<n;i++){
        long left=i-prev[i];
        long right=next[i]-i;
        ans+=(arr[i]*left*right);
    }
    return (int)(ans%mod);
    }
}