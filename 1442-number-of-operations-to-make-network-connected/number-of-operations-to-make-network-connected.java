class Solution {
    public int makeConnected(int n, int[][] connections) {
        int components = n;
        int extra = 0;
        

        int[] rank = new int[n];
        int[] parent = new int[n];
        for(int i =0 ; i<parent.length ; i++){
            parent[i] = i;
        }
        for(int i=0 ; i<connections.length  ; i++){
            int n1 = connections[i][0];
            int n2 = connections[i][1];
            if(findParent(n1 , parent) == findParent(n2 , parent)){
                extra++;
            }
            else{
                components--;
              
                union(n1 , n2 ,  parent , rank);
            }
        }
        if( extra >= components - 1 ) return components - 1;
        return -1;
    }
    public int findParent(int n1 ,  int parent[]){
        if(n1 == parent[n1]) return n1;
        parent[n1] = findParent( parent[n1] , parent);
        return parent[n1];
    }
    public void union(int n1 , int n2 , int parent[] , int rank[]){
        int pn1 = findParent(n1 , parent);
        int pn2 = findParent(n2 , parent);
        if(rank[pn1] > rank[pn2]){
            parent[pn2] = pn1;
        }
        else if(rank[pn1] < rank[pn2]){
            parent[pn1] = pn2;
        }
        else{
            parent[pn2] = pn1;
            rank[pn1]++;
        }

    }
}