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
import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node , Integer> m1 = new HashMap<>();
        HashMap<Integer , Node> m2 = new HashMap<>();
        int ind = 0;
        Node temp = head;
        while(temp!=null){
            m1.put( temp, ind );
            ind++;
            temp = temp.next;
        }
        Node t1 = new Node(-1);
        Node h2 = t1;
        ind = 0;
        temp = head;
        while(temp!=null){
            t1.next = new Node(temp.val);
            t1 = t1.next;
            m2.put(ind , t1);
            ind++;
            temp = temp.next;
        }
        temp = head;
        h2 = h2.next;
        t1 = h2;
        while(temp!=null){
            if(temp.random!=null){
                int index = m1.get(temp.random);
                t1.random = m2.get(index);
            }
            temp = temp.next;
            t1 = t1.next;
        }

        return h2;
        
    }
}