import java.util.*;
class node{
    int n;
    int time;
    node(int a , int b){
        n = a;
        time  = b;

    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<node>> g = new ArrayList<>();
        boolean[] v = new boolean[n+1];
        int best[] = new int[n+1];
        Arrays.fill(best , Integer.MAX_VALUE);
        
        for(int i=0  ; i<n+1 ; i++){
            g.add(new ArrayList<>());
        }
        for(int i[] : times){
            g.get(i[0]).add(new node(i[1] , i[2] ) ) ;

        }
        best[k] = 0;
        Queue<node> q = new LinkedList<>();
        q.add(new node(  k , 0) );
        int timeTaken = Integer.MIN_VALUE;

        while( !q.isEmpty() ){
            node temp = q.poll();
           for(node neigh : g.get(temp.n)){
            int a = temp.time + neigh.time;
            if(best[neigh.n] > a){
                best[neigh.n] = a;
                q.add(new node(neigh.n , a));
            }
           }
            
        } 
       for(int i=1 ; i<n+1 ; i++){
        timeTaken = Math.max(timeTaken , best[i]);
       }
       if(timeTaken == Integer.MAX_VALUE) return -1;
        return timeTaken;

    }
}