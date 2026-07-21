class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root, target, k);
        return ans;
    }

    // Returns distance from current node to target.
    // Returns -1 if target is not in this subtree.
    private int find(TreeNode root, TreeNode target, int k) {

        if (root == null)
            return -1;

        // Target found
        if (root == target) {
            collect(root, 0, k);
            return 1;
        }

        int left = find(root.left, target, k);

        if (left != -1) {

            if (left == k)
                ans.add(root.val);

            collect(root.right, left + 1, k);

            return left + 1;
        }

        int right = find(root.right, target, k);

        if (right != -1) {

            if (right == k)
                ans.add(root.val);

            collect(root.left, right + 1, k);

            return right + 1;
        }

        return -1;
    }

    private void collect(TreeNode root, int dist, int k) {

        if (root == null)
            return;

        if (dist == k) {
            ans.add(root.val);
            return;
        }

        collect(root.left, dist + 1, k);
        collect(root.right, dist + 1, k);
    }
}