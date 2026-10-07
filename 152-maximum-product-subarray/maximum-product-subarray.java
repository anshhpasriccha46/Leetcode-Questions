class Solution {
    int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        int dp[][] = new int[nums.length][2];
        for(int i=0 ; i<dp.length ; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int a =  kar(dp , nums , nums.length-1 , 1);
        // a =  kar(dp , nums , nums.length , 0);
        return max;
    }
    public int kar(int dp[][] ,int nums[] , int i , int j){
        if(i==0){
            //System.out.println("INDEX: " + i + " returned" + dp[i][j]);
             max = Math.max(max , dp[i][1]);
             return dp[i][j];
        }
        if(j==0 && dp[i][j]!=Integer.MAX_VALUE){
            //System.out.println("INDEX: " + i + " returned" + dp[i][j]);
             
             return dp[i][j];
        }
        else if(j==1 && dp[i][j]!=Integer.MIN_VALUE){
            //System.out.println("INDEX: " + i + " returned" + dp[i][j]);
             
             return dp[i][j];
        }
        
        int one = nums[i] * kar(dp, nums , i-1 , 0 );
        int two = nums[i] * kar(dp , nums , i-1 , 1);
        
        dp[i][1] = Math.max(one , Math.max(nums[i] , two));
        dp[i][0] = Math.min(one , Math.min(nums[i] , two));
        max = Math.max(max , dp[i][1]);
        //System.out.println("INDEX: " + i + " returned " + dp[i][j]);

        return dp[i][j];
    }
}