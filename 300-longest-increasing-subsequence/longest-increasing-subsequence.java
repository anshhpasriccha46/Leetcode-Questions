class Solution {
    int max = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , 1 );
        kar(nums , dp , nums.length - 1);
        // for(int i: dp){
        //     System.out.println(i);
        // }
        return max;
    }
    public void kar(int nums[] , int dp[] , int index){
       if(index == 0){
    max = Math.max(max, dp[0]);
    return;
    }
      kar(nums , dp , index-1);
        int ind = -1;
        int val = 1;
        for(int i=0 ; i<index ; i++){
            if(nums[i]<nums[index]){
                if(dp[i]>=val){
                    val = dp[i];
                    ind=i;
                }
            }
        }
        if(ind!=-1)dp[index]+=dp[ind];
         max = Math.max(max , dp[index]);
        
    }
}