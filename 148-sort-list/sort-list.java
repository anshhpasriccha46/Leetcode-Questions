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
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode a = head;
        while(a!=null){
            ans.add(a.val);
            a= a.next;
        }
        Collections.sort(ans);
        head = new ListNode(ans.get(0));
        a= head;
        for(int i=1; i<ans.size() ;  i++){
            a.next= new ListNode(ans.get(i));
            a = a.next;
        }
        return head;
    }
}