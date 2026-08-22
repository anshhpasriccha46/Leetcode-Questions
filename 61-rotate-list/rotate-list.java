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
        if(head==null) return null;
        if(k==0) return head;
        ListNode temp = head;
        int count = 1;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        k=k%size;
        temp = head;
        if(size==1 || k==0) return head;

    
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        head =  prev;
        curr = head;
        prev = null;
        next = null;
        temp = head;
        
        while(count!=k){
            count++;
            temp = temp.next;
        }
         ListNode nextGroup = temp.next;
        while(curr!=nextGroup){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = nextGroup;
        ListNode endFirstGroup = head;
        head = prev;
        prev = null;
        next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        endFirstGroup.next = prev;
        
        return head;


    }
}