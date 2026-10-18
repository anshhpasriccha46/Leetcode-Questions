class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(0, traverse(root.left));
        int r = Math.max(0, traverse(root.right));

        max = Math.max(max, root.val + l + r);

        return root.val + Math.max(l, r);
    }
}