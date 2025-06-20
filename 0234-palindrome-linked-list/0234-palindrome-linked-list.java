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
    public ListNode reverse(ListNode head)
    {
        ListNode next,prev=null,cur=head;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow,fast;
        slow=head;
        fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast!=null)
        {
            slow=slow.next;
        }

        ListNode mid=reverse(slow);

        while(head!=null && mid!=null)
        {
            if(head.val!=mid.val)
            {
                return false;
            }
            head=head.next;
            mid=mid.next;
        }
        return true;
    }
}