import java.util.*;

class coord{
    int x;
    int y;
   
    coord(int a, int b ){
        x = a;
        y = b;
    }
}

class Solution {
    int dx[] = {-1 ,1,  0, 0};
    int dy[] = {0 , 0 , -1 , 1};
    public int minimumEffortPath(int[][] heights) {
        if(heights.length == 1 && heights[0].length == 1) return 0;
        Queue<coord> q= new LinkedList<>();
        q.add(new coord(0 , 0 ));
        return kar(heights , q );
    }
    public int kar(int[][] h ,  Queue<coord> q){
        int[][] best = new int[h.length][h[0].length];
        for(int i=0; i<best.length  ; i++){
            Arrays.fill(best[i] , Integer.MAX_VALUE);
        }
        best[0][0] = 0;
        while(!q.isEmpty()){
            coord temp = q.poll();
            for(int i=0 ; i<4 ; i++){
                int xc = temp.x + dx[i];
                int yc = temp.y + dy[i];
                if(xc>=0 && yc>=0 && xc<h.length && yc<h[0].length){
                     int a = Math.max(best[temp.x][temp.y],
                 Math.abs(h[xc][yc] - h[temp.x][temp.y]));
                if(best[xc][yc] > a ){
                    best[xc][yc] = a;
                    q.add(new coord(xc , yc));
                 }
                }
               
            }
        }
        return best[h.length - 1][h[0].length - 1];
    }
}