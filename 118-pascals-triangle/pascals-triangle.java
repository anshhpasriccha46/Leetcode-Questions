import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();  
        if(numRows==0) return ans;
        for(int i=0 ; i<numRows ; i++)  { 
            ans.add(new ArrayList<>());
            ans.get(i).add(1);
            }
            if(numRows==1) return ans;
            ans.get(1).add(1);
            if(numRows==2) return ans;

            for(int i=2 ; i<numRows ; i++){
                for(int j=1 ; j<ans.get(i-1).size(); j++){
                    ans.get(i).add(
                        ans.get(i-1).get(j-1) + ans.get(i-1).get(j)
                    );
                }
                ans.get(i).add(1);
            }

return ans;
        
    }   
}