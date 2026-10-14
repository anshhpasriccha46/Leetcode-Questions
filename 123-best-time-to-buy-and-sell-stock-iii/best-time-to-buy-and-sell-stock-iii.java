class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][4];
        for(int i[] :dp ){
            Arrays.fill(i , Integer.MIN_VALUE);
        }
        dp[0][0] = Math.max(dp[0][0], -prices[0] );
        dp[0][1] = Math.max(dp[0][1] ,dp[0][0] + prices[0] );
        dp[0][2] = Math.max(dp[0][2] , dp[0][1] - prices[0]);
        dp[0][3] = Math.max(dp[0][3] , dp[0][2] + prices[0] );
        return kar(prices , dp, prices.length-1 , 3);

    }
    private int kar(int p[] , int dp[][] , int i , int a){
        if(i==0){
            return dp[i][a];
        }
        if(dp[i][a]!=Integer.MIN_VALUE) return dp[i][a];
        dp[i][0] = Math.max(kar(p, dp ,i-1 , 0) , -p[i] );
        dp[i][1] = Math.max(kar(p , dp , i-1 , 1) , dp[i][0] + p[i]);
        dp[i][2] = Math.max(kar(p , dp , i-1 ,2) , dp[i][1] - p[i]);
        dp[i][3] = Math.max(kar(p , dp ,i-1 ,3) , dp[i][2] + p[i]);
        return dp[i][a];
    }
}