class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0 ; i<nums.length - 2 ; i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
        int l = i+1;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] + nums[i] > 0){
                  r--;
            }
            else if(nums[l] + nums[r] + nums[i] < 0){
                
                  l++;
            } 
          
            else if(nums[l] + nums[r] + nums[i] == 0){
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(nums[i]);
                ans.get(ans.size() - 1).add(nums[l]);
                ans.get(ans.size() - 1).add(nums[r]);
                while(l<r && nums[l]==nums[l+1]){
                    l++;
                }
                while(l<r && nums[r]==nums[r-1]){
                    r--;
                }
                l++;
                r--;
             
            }
        }
        }
        return ans;
    }
}