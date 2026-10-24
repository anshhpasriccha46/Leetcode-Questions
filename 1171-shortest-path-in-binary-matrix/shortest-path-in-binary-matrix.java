import java.util.*;
class coord{
    int x;
    int y;
    int dist;
    coord(int a , int b , int c){
        x = a;
        y = b;
        dist = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        Queue<coord> q = new LinkedList<>();
        
        if(grid[0][0] == 0){
            q.add(new coord(0 , 0, 1));
        }
        vis[0][0] = true;
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1,  0,  1, -1, 1, -1, 0, 1};
        while(!q.isEmpty()){
            coord curr = q.poll();
            if(curr.x==grid.length-1 && curr.y==grid[0].length-1){
                return curr.dist;
            }
            for(int i=0 ; i<8 ; i++){
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];
                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 0){
                    if(!vis[x][y]){
                        vis[x][y] = true;
                        q.add(new coord(x , y , curr.dist + 1));
                    }
                }
            }
        }
        return -1;
    }
}