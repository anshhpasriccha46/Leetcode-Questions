class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length + 1][amount + 1];

        // -1 = not calculated
        // 0 = amount 0
        // Integer.MAX_VALUE = impossible

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j == 0) {
                    dp[i][j] = 0;
                }
                else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else if (coins[i - 1] == j) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = -1;
                }
            }
        }

        int ans = kar(dp, coins, coins.length, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int kar(int dp[][], int c[], int i, int left) {

        // Already calculated
        if (dp[i][left] != -1) {
            return dp[i][left];
        }

        int min = Integer.MAX_VALUE;

        int temp = left;
        int count = 0;

        // Try using current coin 0, 1, 2, ... times
        while (temp >= 0) {

            int check = kar(dp, c, i - 1, temp);

            // Ignore impossible subproblem
            if (check != Integer.MAX_VALUE) {
                min = Math.min(min, check + count);
            }

            count++;
            temp -= c[i - 1];
        }

        dp[i][left] = min;

        return dp[i][left];
    }
}