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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;
        ListNode fast=head;

        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }

        while(fast!=null)
        {
            dummy=dummy.next;
            fast=fast.next;
        }

        dummy.next=dummy.next.next;

        return res.next;
    }
}