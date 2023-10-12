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
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s ;
    }
}