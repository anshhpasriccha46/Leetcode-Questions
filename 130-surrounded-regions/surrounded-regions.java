import java.util.*;
class Coord{
    public int x;
    public int y;
    Coord(int a , int b){
        x = a;
        y = b;
    }
}
class Solution {
     int dx[] = {-1 , 1 , 0 , 0};
     int dy[] = {0 , 0 , -1 , 1};
     Queue<Coord> Q = new LinkedList<>();
    public void solve(char[][] grid) {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean done = false;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(!visited[i][j] && grid[i][j] == 'O'){
                    visited = new boolean[grid.length][grid[0].length];
                     if(!dfs(new Coord(i , j) , visited , grid)){
                      
                         Q.add(new Coord(i , j));
                     }
                     
                }
                
            }
        }
        visited = new boolean[grid.length][grid[0].length];
        while(!Q.isEmpty()){
            visited = new boolean[grid.length][grid[0].length];
            changedfs(Q.poll() , visited, grid);
        }
        
        
        
    }
    
    public boolean dfs(Coord zero , boolean[][] visited, char[][] grid ){
        visited[zero.x][zero.y] = true;
        if(zero.x == grid.length-1 || zero.x==0 || zero.y == grid[0].length-1 || zero.y==0){
             visited[zero.x][zero.y] = false;
            return true;
        }
        for(int i=0 ; i<4 ; i++){
            int xc = zero.x + dx[i];
            int yc = zero.y + dy[i];
           
           if(xc>=0 && xc<grid.length && yc>=0 && yc<grid[0].length){
           
            if(grid[xc][yc] == 'O' && !visited[xc][yc]){
                
                if( dfs(new Coord(xc , yc) , visited ,  grid) ) return true;
                
              
            }
           }
        }
        
        
        
        return false;
       
        
    }
    public void changedfs(Coord zero, boolean[][] visited , char[][] grid){
        visited[zero.x][zero.y] = true;
        grid[zero.x][zero.y] = 'X';
        for(int i=0 ; i<4 ; i++){
             int xc = zero.x + dx[i];
            int yc = zero.y + dy[i];
            if(xc>=0 && xc<grid.length && yc>=0 && yc<grid[0].length)
           
            if(grid[xc][yc] == 'O' && !visited[xc][yc]){
                
                changedfs(new Coord(xc , yc) , visited , grid) ;
                
              
            }
        }
    }
}
