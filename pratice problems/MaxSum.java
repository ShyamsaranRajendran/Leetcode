/* 
 *   find the max sum of the sub array of k size
 *  input:
 *    [1,2,3,4,5,6]
*/

import java.util.Scanner;

public class MaxSum {


    public static int Maxsum(int arr[],int size)
    {
        int max=Integer.MIN_VALUE;
        int currentSum=0;
        for(int i=0;i<arr.length;i++)
        {

            currentSum += arr[i];
            if(i>=size-1)
            {
                max = Math.max(max, currentSum);
                currentSum-=arr[i-(size-1)];
            }
            
        }
        return max;
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        System.out.println(Maxsum(arr1,3));
    }
}
