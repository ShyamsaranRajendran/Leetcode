/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;
        ListNode temp=new ListNode(0);
        ListNode head=temp;
        while(l1!=null || l2!=null || carry!=0)
        {
           int dig1=(l1!=null)?l1.val:0;
           int dig2=(l2!=null)?l2.val:0;

           int sum= dig1+dig2+carry;
           carry=sum/10;
           sum=sum%10;

           temp.next = new ListNode(sum);
           temp=temp.next;
           
           if(l1!=null)l1=l1.next;
           if(l2!=null)l2=l2.next;
        }
        return head.next;
    }
}