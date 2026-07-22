import java.util.*;
class Pair{
    int node ;
    int time;
    Pair(int a , int b){
        node = a;
        time = b;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for(int i=0 ; i<=n ; i++){
            g.add(new ArrayList<>());
        }
        for(int entry[] : times){
            g.get(entry[0]).add(new Pair(entry[1] , entry[2]));
        }
        int best[] = new int[n+1];
        Arrays.fill(best , Integer.MAX_VALUE);
        best[k] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k , 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int time = curr.time;
            for(Pair nei: g.get(node)){
                if(best[nei.node] > best[node] + nei.time){
                    best[nei.node] = best[node] + nei.time;
                    System.out.println(nei.node + " " + best[nei.node]);
                    q.add(new Pair(nei.node ,best[nei.node]  ));
                }
            }
        }
        int ans = 0;
        best[0] = 0;
        for(int i: best){
            if(i==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans , i);
        }
        return ans;
    }
}