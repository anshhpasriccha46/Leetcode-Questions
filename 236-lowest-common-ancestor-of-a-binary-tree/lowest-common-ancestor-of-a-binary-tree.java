/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean see = findAns(root , p , q);
        return ans;
    }
    public boolean findAns(TreeNode root , TreeNode p , TreeNode q){
        if(root==null) return false;
        boolean left = findAns(root.left , p , q);
        boolean right = findAns(root.right , p , q);
        
        if(left || right ){
               if(root==p || root== q){
                found = true;
                ans = root;
               
                }
                else if(left && right){
                    if(!found){
                        found = true;
                        ans =root;
                    }
                    
                }
                return true;
            
        }
        if(root==p || root==q) return true;
        return false;

    }
}