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
    public ListNode rotateRight(ListNode head, int k) {

         if (head == null || head.next == null || k == 0) return head;


        ListNode tail=head;
        int len=1;

        while(tail.next!=null){
            len++;
            tail=tail.next;
        }

        k=k%len;
        if(k==0){
            return head;
        }
        
        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead=newTail.next;
        newTail.next=null;

        return newHead;
    }
}