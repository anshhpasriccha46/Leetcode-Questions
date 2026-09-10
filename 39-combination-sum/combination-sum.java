class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> sol=new ArrayList<>(); 
         List<Integer> ans=new ArrayList<>();
         kar(0 , sol , ans , target , candidates , 0);
         return sol;
    }
    public void kar( int index, List<List<Integer>> sol ,  List<Integer> ans , int t, int a[] , int sum){
        if( sum == t){
            sol.add(new ArrayList<>(ans));
            return ;
        }
       
        for(int i= index ; i<a.length ; i++){
            if(sum + a[i] <= t ){
            sum+=a[i];
            ans.add(a[i]);
            kar(i , sol , ans , t , a, sum);
            sum-=a[i];
            ans.remove(ans.size() -1);
        }
       
        }
    }
}