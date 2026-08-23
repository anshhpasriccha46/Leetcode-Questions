class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
         for(int i: nums){
            sum+=i;
         }
         if(sum%2!=0) return false;
         Boolean dp[][] = new Boolean[n+1][sum+1];

         return kar(dp , nums , n , 0 , sum );

    }
    public Boolean kar(Boolean dp[][] , int arr[] , int i , int sumSoFar, int totSum){
        if(sumSoFar == totSum/2) return dp[i][sumSoFar] = true;

        if(i==0) return false;

        if(dp[i][sumSoFar] != null) return dp[i][sumSoFar];

        dp[i][sumSoFar] = kar(dp , arr , i-1 , sumSoFar , totSum) || kar(dp , arr , i-1 , sumSoFar + arr[i-1] , totSum);
        return dp[i][sumSoFar];
    }
}