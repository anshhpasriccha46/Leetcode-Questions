class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sol = new ArrayList<>();
        kar(candidates , target , 0 , sol , 0);
        return ans;
    }
    public void kar(int nums[] , int t , int sum , List<Integer> sol,  int index){
        if(sum==t){
            ans.add(new ArrayList<>(sol));
            return;
        }
        for(int i=index ; i<nums.length ; i++){
            if(t < sum+nums[i]) continue;
            sol.add(nums[i]);
            kar(nums , t , sum+nums[i], sol , i);
            sol.remove(sol.size()-1);
        }
    }
}