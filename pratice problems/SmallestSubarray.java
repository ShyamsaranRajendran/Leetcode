public class SmallestSubarray {
    
    // Smallest Sum >= k
    public static int  Answer(int arr[],int target){
        
        int size=Integer.MAX_VALUE;
        int startwin=0;
        int currentSum=0;
        for(int endwin=0;endwin<arr.length;endwin++)
        {
          currentSum+=arr[endwin];
           while(currentSum >target)
           {
            size=Math.min(size,endwin-startwin+1);
            currentSum-=arr[startwin];
            startwin++;
           }
        }
        return size;
    }
    public static void main(String[] args) {
        int arr[]={10,2,4,1,5,6,8};
        System.out.println(Answer(arr,16));
    }
}
