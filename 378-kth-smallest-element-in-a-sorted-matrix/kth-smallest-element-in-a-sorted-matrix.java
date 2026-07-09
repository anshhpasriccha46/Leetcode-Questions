import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {

      
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return b - a;
       });
       
for(int i=0 ; i<mat.length ; i++)
      { for(int num : mat[i]){
        if(pq.size() < k){
            pq.add(num);
        }
        else if(num<pq.peek()){
            pq.poll();
            pq.add(num);
        }

       }}
       return pq.peek();
    }

}