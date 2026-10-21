import java.util.*;
class coord{
    int x , y;
    coord(int a ,int b){
        x = a;
        y = b;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int time = -1;
        int count = 0;
        Queue<coord> q = new LinkedList<>();
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2) q.add(new coord(i , j));
                if(grid[i][j]==1) count++;
            }
        }
        int dx[] = {-1 , 1 , 0 , 0};
        int dy[] = {0 , 0 , -1 , 1};
        if(count==0) return 0;
        //boolean[] vis  = new boolean[grid.length][grid[0].length];
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int j=0 ; j<size ; j++){
                coord n = q.poll();
                for(int i=0 ; i<4 ; i++){
                    int x = n.x + dx[i];
                    int y = n.y + dy[i];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                        if(grid[x][y]==1 ){
                            grid[x][y]=2;
                            q.add(new coord(x , y));
                            count--;
                        }
                    }
                }
            }
        }
        return count==0?time:-1;
    }
}