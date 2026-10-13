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
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
       // System.out.println(count);
        temp = head;
        if(n>count) return head;
        if(n==count) return head.next;
        if(count==1 && n==1 ) return head.next;
        // if(count==2 && n==2) return head.next;
        count = count - n + 1;
        //System.out.println(count);
        ListNode t = head;
        int check = 0;
        while(check!=count-1){
            check++;
            //System.out.println(check);
            t = temp;
            temp = temp.next;
        }
        t.next = temp.next;
        return head;
    }
}