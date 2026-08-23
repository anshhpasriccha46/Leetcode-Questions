class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        int dp[] = new int[n + 1];
        Arrays.fill(dp  , -1);
        return kar(nums , n , dp);
        
    }
    public int kar(int[] nums , int i , int[] dp ){
        if (i == 0) return 0;
        if (i == 1) return nums[0];
        if (i == 2) return Math.max(nums[0], nums[1]);

        if(dp[i]!=-1){
            return dp[i];
        }
        int curr = nums[i-1]; 
        dp[i] = Math.max( curr+ kar(nums , i-2 , dp) , kar(nums  , i-1 ,dp) );
        return dp[i];
    }
}