/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append("null");
            return sb.toString();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(Integer.toString(root.val));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode n = q.poll();
                if(n.left!=null){
                    q.add(n.left);
                    sb.append("," );
                    sb.append(Integer.toString(n.left.val));
                }
                else if(n.left==null){
                    sb.append(",");
                    sb.append("null");
                }
                if(n.right!=null){
                    q.add(n.right);
                    sb.append("," );
                    sb.append(Integer.toString(n.right.val));
                }
                 else if(n.right==null){
                    sb.append(",");
                    sb.append("null");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0 ;  j<size ; j++){
                TreeNode n  = q.poll();
            if(arr[i].equals("null") == false){
                n.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(n.left);
            }
            else n.left = null;
            i++;
            if(arr[i].equals("null") == false){
                n.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(n.right);
            }
            else n.right=null;
            i++;
            }
        }
        return root;
    }
   
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));