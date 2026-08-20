/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        boolean crosseda = false;
        boolean crossedb = false;
        while(a!=b){
            a = a.next;
            if(a==null ){
                if(crosseda) return null; 
                a= headB;
                crosseda =true;
            }
            b = b.next;
            if(b==null) {
                   if(crossedb) return null; 
            b = headA;
            crossedb = true;
            }
        }
        return a;
    }
}