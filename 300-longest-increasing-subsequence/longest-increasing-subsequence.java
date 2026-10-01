class Solution {
    int count = 1;
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        kar(nums , dp , nums.length-1);
        return count;
    }
    public void kar(int nums[] , int dp[] , int i){
        
        if(i==0) return;
        kar(nums , dp , i-1);
        for(int j=0 ; j<i ; j++){
            if(nums[j] < nums[i]){
                dp[i] = Math.max(dp[i] , dp[j] + 1);
                
                count = Math.max(count , dp[i]);
                
            }
        
        }
       
        
    }

}