import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->{
             return a[0] - b[0];
            // return a[1] - b[0];
        });
        // for(int[] a: intervals){
        //     System.out.println(a[0] +" " + a[1]);
        // }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int index[] = new int[intervals.length];
        int upperLimit = intervals[0][1];
          
        for(int i=0 ; i<intervals.length - 1  ; i++){
        System.out.println(upperLimit);
        if(upperLimit >= intervals[i + 1][0]){
            index[i]++;
            upperLimit = Math.max(upperLimit , intervals[i+1][1]);

        }
        else upperLimit = intervals[i+1][1];
        }
        int i=0;
        while(i<intervals.length){
            if(index[i]==1){
                int max = intervals[i][1];
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(intervals[i][0]);
                
                while(index[i]!=0){
                    max = Math.max(max , intervals[i][1]);
                  i++;
                }
                max = Math.max(max , intervals[i][1]);
                ans.get(ans.size() - 1).add(max);
                i++;
            }
            else{
                 ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(intervals[i][0]);
                 ans.get(ans.size() - 1).add(intervals[i][1]);
                i++;
            }
        }
        int finans[][] = new int[ans.size()][2];
        for(int l=0 ; l< ans.size() ; l++){
            finans[l][0] = ans.get(l).get(0) ;
            finans[l][1] = ans.get(l).get(1);
   // System.out.println(ans.get(l).get(0) + " " + ans.get(l).get(1));
        }
        
        return finans;
    }
}