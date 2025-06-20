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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode FirstHead=head;
        ListNode SecondHead=head.next;

        ListNode first=head;
        ListNode second=head.next;

        while(second !=null && second.next!=null)
        {
           
            first.next=second.next;
            first=first.next;
            second.next=first.next;
            second=second.next;
        }
        first.next=SecondHead;
        return head;
    }
}