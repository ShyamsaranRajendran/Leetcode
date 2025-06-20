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
    ListNode reverse(ListNode head)
    {
        ListNode next,cur=head,prev=null;

        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        return head;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        slow=reverse(slow);
        ListNode cur=head,temp,temp2;
        while(cur!=null && slow!=null)
        {
            temp=cur.next;
            cur.next=slow;
            temp2=slow.next;
            slow.next=temp;
            cur=temp;
            slow=temp2;
        }

    }
}