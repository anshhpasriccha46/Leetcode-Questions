class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAns(root, p, q);
        return ans;
    }

    private boolean findAns(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean left = findAns(root.left, p, q);
        boolean right = findAns(root.right, p, q);
        boolean mid = (root == p || root == q);

        if (ans == null && (left && right || mid && (left || right))) {
            ans = root;
        }

        return left || right || mid;
    }
}