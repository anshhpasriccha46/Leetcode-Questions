class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, kar(i, nums, dp));
        }

        return ans;
    }

    public int kar(int i, int[] nums, int[] dp) {

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // At least nums[i] itself
        int max = 1;

        for (int j = 0; j < i; j++) {

            // nums[i] can be appended to sequence ending at j
            if (nums[j] < nums[i]) {
                int check = kar(j, nums, dp) + 1;
                max = Math.max(max, check);
            }
        }

        return dp[i] = max;
    }
}