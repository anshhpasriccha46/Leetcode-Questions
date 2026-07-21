/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null ) return 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();    
            boolean found = false;

            for(int i=0 ; i<size ; i++){
                TreeNode temp = q.poll();
                count++;
                if(temp.left == null){
                    found = true;
                    break;
                }
                else{
                    q.add(temp.left);
                }
                if(temp.right == null){
                    found = true;
                    break;
                }
                else{
                    q.add(temp.right);

                }
            }
            if(found == true){
             count+=q.size();
             break;
            }
        }
        return count;
    }
}