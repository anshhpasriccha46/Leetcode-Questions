import java.util.*;

class node{
    int n;
    int price;
    node(int a,  int c){
        n = a;
        price = c;
    }
}
class Solution {

    public int findCheapestPrice(int num, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<node>> g = new ArrayList<>();
        for(int i=0 ; i<num ; i++){
            g.add(new ArrayList<>());
        }
        for(int i[] : flights){
            g.get(i[0]).add(new node(i[1] , i[2] ) );

        }
        Queue<node> q = new LinkedList<>();
        q.add(new node(src , 0));
        int count = -1;
        boolean found = false;
        int best[] = new int[num];
        Arrays.fill(best , Integer.MAX_VALUE);

        while(!q.isEmpty()){
            int size = q.size();
            count++;
            
            if(count>k) break;
            for(int i=0 ; i<size ; i++){
                node temp = q.poll();
                int currnode = temp.n;
                int currprice = temp.price;
                for(node neigh : g.get(currnode)){
                    if(best[neigh.n] > currprice + neigh.price  ){
                        best[neigh.n] = currprice + neigh.price;
                        q.add(new node(neigh.n , best[neigh.n]));
                    }
                }
            }
        }
        if(best[dst] == Integer.MAX_VALUE) return -1;
        return best[dst];
    }
}