class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int h = 0;
        for(int i: nums){
            l = Math.max(l , i);
            h+=i;
        }
        while(l <= h){
            int mid = l + (h-l) / 2;
           
            boolean check = check(nums , k , mid);
            
            if(check){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return l;

    }
    public boolean check(int nums[] ,int k, int maxValue){
        int sum = 0;
        int count =1;

        for(int i=0  ; i<nums.length  ; i++){
            
            if(sum + nums[i] > maxValue){
                sum = nums[i];
                count++;
            }
            else{
                sum+=nums[i];
            }
            if(count>k) return false;
        }
        return true;
    }
}