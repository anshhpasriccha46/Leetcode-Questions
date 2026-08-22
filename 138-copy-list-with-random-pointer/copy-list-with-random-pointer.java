class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        // 1. Create copy of every node
        Node temp = head;

        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // 2. Connect next and random pointers
        temp = head;

        while (temp != null) {
            Node copy = map.get(temp);

            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
}