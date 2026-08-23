import java.util.*;
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n2 = (int)Math.pow(n , 2);
        int ans[] = new int[2];
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<grid.length  ; i++){
            for(int j= 0  ; j<grid[i].length ; j++){
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }
                else set.add(grid[i][j]);
                sum+=grid[i][j];
                
            }
        }
        int needed = n2*(n2+1)/2;
        sum-=ans[0];
        ans[1] = needed - sum;
        return ans;

    }
}