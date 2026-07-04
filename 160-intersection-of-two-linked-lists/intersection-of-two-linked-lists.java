import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a!=null){
            set.add(a);
            a = a.next;
        }
        while(b!=null){
            if(set.contains(b)) return b;
            set.add(b);
            b = b.next;
        }
        return null;
    }
}
