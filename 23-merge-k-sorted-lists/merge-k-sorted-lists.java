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
 import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b)->{
            return a - b;
        });
        ListNode temp = null;
        for(ListNode head : lists){
            temp = head;
            while(temp!=null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode t = head;
        while(!pq.isEmpty()){
            int t2 = pq.poll();
            t.next = new ListNode(t2);
            t = t.next;
        }
        head = head.next;

        return head;
        
    }
}