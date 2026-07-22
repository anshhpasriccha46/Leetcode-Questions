import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i =0 ; i<graph.length ; i++){
            g.add(new ArrayList<>());
        }
        for(int to = 0 ; to<graph.length  ; to++){
            for(int from: graph[to]){
                g.get(from).add(to);
            }
        }
        int[] indeg = new int[graph.length];
      for(ArrayList<Integer> entry : g){
        for(int i: entry){
            indeg[i]++;
        }
      }
      Queue<Integer> q = new LinkedList<>();
     ArrayList<Integer> ans  = new ArrayList<>();
      for(int i=0 ; i<g.size() ; i++){
        if(indeg[i]==0){
            q.add(i);
            ans.add(i);
            
        }
      }
      while(!q.isEmpty()){
        int ele  = q.poll();
        for(int i: g.get(ele)){
            indeg[i]--;
            if(indeg[i]==0){
                q.add(i);
                ans.add(i);
            }
        }
      }
      Collections.sort(ans , (a , b)->{
        return a-b;
      });
      return ans;
     

    }
}