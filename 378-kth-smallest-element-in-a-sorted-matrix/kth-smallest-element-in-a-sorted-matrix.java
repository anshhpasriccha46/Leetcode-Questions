import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {

        int nums[] = new int[mat.length * mat[0].length];
        int index = 0;
        for(int i=0 ; i<mat.length  ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                nums[index] = mat[i][j];
                index++;
            }
        }
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return b - a;
       });
       

       for(int num : nums){
        if(pq.size() < k){
            pq.add(num);
        }
        else if(num<pq.peek()){
            pq.poll();
            pq.add(num);
        }

       }
       return pq.peek();
    }

}