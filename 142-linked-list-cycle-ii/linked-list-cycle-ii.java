public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode f= head;
       ListNode s = head;
       while(f!=null && f.next!=null){
        s = s.next;
        f= f.next.next;
        if(s==f){
            s = head;
            while(s!=f){
                s=  s.next;
                f = f.next;
            }
            return f;
        }
       } 
       return null;
    }
}