class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sol = new ArrayList<>();List<Integer> ans  = new ArrayList<>();
        kar(sol , ans , candidates , target , 0 , 0);
        return sol;
    }
    void kar( List<List<Integer>> sol , List<Integer> ans, int arr[] , int target , int sum ,int index){
        if(sum == target){
            sol.add(new ArrayList<>(ans));
            return;
        }
        else{
            for(int i=index ; i<arr.length;  i++){
                if(index<i && arr[i] == arr[i-1]) continue;
                else if(sum+arr[i] <= target ){ans.add(arr[i]);
                kar(sol , ans  , arr , target , sum+arr[i] , i+1);
                ans.remove(ans.size() - 1);
            }
            }
        }
      
    }
}