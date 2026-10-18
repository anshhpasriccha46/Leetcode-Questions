class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int a = traverse(root);
        if(root==null) return 0;
        return max;
    }
    public int traverse(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(0  ,traverse(root.left));
        int r =Math.max(0, traverse(root.right));
        
        max = Math.max( max ,  l+r+root.val);
        //System.out.println(max);
        return root.val + Math.max(l , r);
    }
}