/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node , Integer> index = new HashMap<>();
        HashMap<Integer, Node> index2 = new HashMap<>();
      HashMap<Node , Integer> map = new HashMap<>();
      Node t1 = head;
      int count = 0;
      index.put(t1 , count);
      Node head2 = new Node(head.val);  
      Node t2 = head2;
      index2.put(count , t2);
      while(t1.next!=null){
        count++;
        t2.next = new Node(t1.next.val);
        t2 = t2.next;
        t1 = t1.next;
       index.put(t1 , count );
       index2.put(count , t2);
      }
      t1 = head;
      t2 = head2;
      while(t1!=null){
        map.put(t1 , t1.random==null?-1 : index.get(t1.random));
        t1 = t1.next;
      }
      t1 = head;
      while(t1!=null){
        int check =map.get(t1);
        if(check == -1) t2.random = null;
        else t2.random = index2.get(check);
        t1 = t1.next;
        t2 = t2.next;
      }
      return head2;
    }
}