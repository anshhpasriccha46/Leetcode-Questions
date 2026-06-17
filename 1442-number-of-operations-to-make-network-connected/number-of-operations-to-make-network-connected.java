class Solution {
    int components = 0;
    int edge = 0;
    public int makeConnected(int n, int[][] edges) {
          boolean visited[] = new boolean[n];
          int count = 0;
          edge = edges.length;
          components= n;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        for(int i= 0 ; i<n ; i++){
            g.add(new ArrayList<>() );
        }
        for(int i=0 ; i<edges.length ; i++){
           g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0 ; i<n ; i++){
            if(visited[i] == false){
                visited[i] = true;
                count++;
                found(i , -1 , g , visited);
                
            }
        }
        if(edge >= components - 1) return components -1;
        return -1;
    }
    public void found(int n ,int p, ArrayList<ArrayList<Integer>> g , boolean[] v ){
        
        for(int i : g.get(n)){
            if(!v[i]){
                v[i] = true;
                components--;
                edge--;
                found(i , n , g , v );
               
            }
        }
    }
}