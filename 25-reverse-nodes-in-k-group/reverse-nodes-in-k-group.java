class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            count++;

            if(count == k){
                ListNode futurePrev;
                if(prev!=null)  futurePrev = prev.next;
                else futurePrev = head;
                if(prev != null){
                    prev.next = rev(prev.next, temp.next);
                }
                else{
                    head = rev(head, temp.next);
                }

                count = 0;
                prev = futurePrev;
                temp = prev.next;
            }

          else   temp = temp.next;
        }

        return head;
    }

    public ListNode rev(ListNode head, ListNode end){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = end;

        return prev;
    }
}