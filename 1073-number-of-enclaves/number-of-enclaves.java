import java.util.*;
class Coord{
    public int x;
    public int y;
    Coord(int a,  int b){
        x = a;
        y = b;
    }
}
class Solution {
    int dx[] = {-1 , 1 , 0 , 0};
    int dy[] = {0 ,0 , -1 , 1};
    Queue<Coord> q = new LinkedList<>();
    public int numEnclaves(int[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=1  ; i<grid.length-1 ; i++){
            for(int j=1 ; j<grid[0].length-1 ; j++){
               
                if(grid[i][j] == 1 && !v[i][j]){
                     v = new boolean[grid.length][grid[0].length];
                   int what = dfs(new Coord(i , j)  ,  v ,grid);
                //    if(what!=0){
                //     System.out.println(i+" " + j + " " + what);
                //    }
                   count+=what;
                }
            }
        }
        
        return count;
    }
    public int dfs(Coord n , boolean[][] v , int[][] grid){
        v[n.x][n.y] = true;
        if(n.x == 0 || n.x == grid.length-1 || n.y == 0 || n.y== grid[0].length-1 ){
            v[n.x][n.y] = false;
            return 0;
        }
       
        int count = 0;
        for(int i=0 ; i<4 ; i++){
            int xc = n.x + dx[i];
            int yc = n.y + dy[i];
            int what = 0 ;
            
            if( xc>=0 && yc>=0 && xc<grid.length && yc<grid[0].length ){
                if(!v[xc][yc] && grid[xc][yc] == 1 ){
                     what = dfs(new Coord(xc, yc ) , v  ,grid);
                    if(what == 0){
                        return 0;
                    }
                    count+=what;
                }
            }
        
        }
        grid[n.x][n.y] = 0;
        return count+1;
        
    }
}