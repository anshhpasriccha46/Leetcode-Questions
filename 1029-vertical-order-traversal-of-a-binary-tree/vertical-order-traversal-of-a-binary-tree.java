import java.util.*;
 class Node{
    int val;
    int x;
    int y;
    Node(int a , int b, int c){
        val = a;
        x = b;
        y = c;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<Node> entries = new ArrayList<>();
        
        traverse(root , 0 , 0 , entries);

        Collections.sort(entries , (a , b)->{
            if(a.x==b.x && a.y==b.y) return Integer.compare(a.val , b.val);
            if(a.y == b.y) return Integer.compare(a.x , b.x); 
            return Integer.compare(a.y , b.y);
        });
       List<List<Integer>> ans = new ArrayList<>();
       Node first = entries.get(0);
       ans.add(new ArrayList<>());
       ans.get(0).add(first.val);
       int last = first.y;
       for(int i=1 ; i<entries.size() ; i++){
        Node n = entries.get(i);
        if(last!=n.y){
            ans.add(new ArrayList<>());
            last = n.y;
        }
        ans.get(ans.size()-1).add(n.val);
       }
       return ans;
    }
    public void traverse(TreeNode root , int x , int y , ArrayList<Node> ans){
        if(root==null) return;
        ans.add(new Node(root.val , x , y));
        traverse(root.left , x+1 , y - 1 , ans);
        traverse(root.right, x+1 , y + 1  , ans);
    }
}