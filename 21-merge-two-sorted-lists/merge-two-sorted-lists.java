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
    public ListNode mergeTwoLists(ListNode l, ListNode d) {
        ListNode head = new ListNode();
        ListNode check = head;
        
        while(l!=null && d!=null){
            if(l.val <= d.val){
               check.next = new ListNode();
               check = check.next;
                check.val = l.val;
                l=l.next;
                
            }
            else if(d.val < l.val){
               check.next = new ListNode();
               check = check.next;
                check.val = d.val;
                d=d.next;
                
            }

        }
        while(d!=null){
            check.next = new ListNode();
               check = check.next;
                check.val = d.val;
                d=d.next;
        }
        while(l!=null) {
               check.next = new ListNode();
               check = check.next;
                check.val = l.val;
                l=l.next;
        }
        return head.next;
    }
}