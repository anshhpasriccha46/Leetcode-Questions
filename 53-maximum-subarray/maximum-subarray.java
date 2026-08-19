class pair{
    int x;
    int y;
    pair(int a , int b){
        x = a;
        y = b;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i : nums){
            if(currSum<0 && i>=currSum) currSum = i;
           else currSum+=i;
            max = Math.max(max , currSum);
        }
        return max;
        
      

    }
}