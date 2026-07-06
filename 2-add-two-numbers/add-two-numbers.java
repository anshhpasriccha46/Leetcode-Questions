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
        boolean found = false;
        boolean carryLeft = false;
        int carry = 0;
        ListNode t1= l1;
        ListNode t2 =l2;
        ListNode  head = new ListNode();
        ListNode temp = head;
        while(t1!=null && t2!=null){
            int ans = t1.val + t2.val + carry;
            
                carry = ans/10;
                ans = ans%10;
            
            temp.val = ans;
            
            t1 = t1.next;
            t2 = t2.next;
            if(t1!=null || t2!=null){
                temp.next = new ListNode();
            temp = temp.next;
            }
            
        }
        ListNode t3 = head;
        if(t1 == null){
            t3 = t2;
        }
        else t3 = t1;
        while(t3!=null){
                int ans = t3.val + carry;
          
                carry = ans/10;
                ans = ans%10;
            
            temp.val = ans;
            t3 = t3.next;
            if(t3!=null){
            temp.next = new ListNode();
            temp = temp.next;
            }
            
        }
       
        if(carry!=0){
             temp.next = new ListNode();
            temp = temp.next;
             temp.val = carry;}
        return head;
    }
}