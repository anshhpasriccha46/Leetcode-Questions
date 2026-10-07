class Solution {
    int max = 1;
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , -1);
        dp[0] = 1;
        int a  = kar(dp , nums , nums.length-1);
        return max;

    }
    public int kar(int dp[] , int nums[] , int i){
        if(dp[i]!=-1) {
           // System.out.println("INDEX: " + i+ " value: " + dp[i]);
            return dp[i];
        }
        //int a = kar(dp , nums , i-1);
        for(int j=0 ; j<i ; j++){
            int check = kar(dp , nums , j);
            if(nums[j]<nums[i]) dp[i] = Math.max(dp[i] , 1 + check);
        }
        if(dp[i]==-1) dp[i] = 1;
        //System.out.println("INDEX: " + i+ " value: " + dp[i]);
        max = Math.max(max , dp[i]);
        return dp[i];
    }
}