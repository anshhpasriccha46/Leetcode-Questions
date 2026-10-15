class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, st = head;
        int count = 0;
        ArrayList<ArrayList<ListNode>> l = new ArrayList<>();

        while (temp != null) {
            count++;

            if (count == k) {
                count = 0;
                ListNode next = temp.next;
                ListNode[] useThese = reverse(st, temp, next);

                l.add(new ArrayList<>());
                l.get(l.size() - 1).add(useThese[0]);
                l.get(l.size() - 1).add(useThese[1]);

                st = next;
                temp = next;
            } else {
                temp = temp.next;
            }
        }

        if (count > 0) {
            ListNode lastTail = l.isEmpty() ? null : l.get(l.size() - 1).get(1);
            if (lastTail != null) lastTail.next = st;
            else return head;
        }

        for (int i = 0; i < l.size() - 1; i++)
            l.get(i).get(1).next = l.get(i + 1).get(0);

        return l.isEmpty() ? head : l.get(0).get(0);
    }

    private ListNode[] reverse(ListNode head, ListNode tail, ListNode aage) {
        ListNode prev = aage, curr = head;

        while (curr != aage) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{tail, head};
    }
}