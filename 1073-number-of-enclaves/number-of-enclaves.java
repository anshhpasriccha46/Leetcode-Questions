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
    boolean found  = false;
    int tot= 0;
    public int numEnclaves(int[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        
        for(int i=0  ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
               
                if(grid[i][j] == 1 && !v[i][j]){
                    int count[] = {0};
                    found = false;
                   dfs(new Coord(i , j)  ,  v ,grid , count);
                    if(!found) tot+=count[0];
                 
                }
            }
        }
        
        return tot;
    }
    public void dfs(Coord n , boolean[][] v , int[][] grid , int[] count){
        v[n.x][n.y] = true;
         count[0]++;
        if(n.x == 0 || n.x==grid.length-1 || n.y==0 || n.y==grid[0].length-1){
            found = true;
        }
       
        for(int i=0 ; i<4 ; i++){
            int x = n.x + dx[i];
            int y = n.y + dy[i];
            if(x >= 0 && x<grid.length && y>=0 && y<grid[0].length)
            if(!v[x][y] && grid[x][y] == 1){
                dfs(new Coord(x, y) , v, grid , count);
            }
        }
    }
}