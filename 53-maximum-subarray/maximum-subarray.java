class Solution {
    public int maxSubArray(int[] nums) {
        // if(nums.length == 1) return nums[0];
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i : nums){
            curr+=i;
            maxSum = Math.max(maxSum , curr);
            curr = Math.max(curr ,  0);
            
        }
        return maxSum;
    }
}