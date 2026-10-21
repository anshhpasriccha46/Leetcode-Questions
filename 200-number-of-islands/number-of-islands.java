class Solution {
    int dx[] =  {-1,1,0 , 0};
    int dy[] = {0 ,0 , -1,1};
    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid , vis , i  ,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid , boolean[][] vis , int x  , int y){
        vis[x][y] = true;
        for(int i=0 ; i<4 ; i++){
            int coordx = x + dx[i];
            int coordy = y + dy[i];
            if( coordx>=0 && coordy>=0 && coordx<grid.length && coordy<grid[0].length &&  grid[coordx][coordy]=='1'){
                if(!vis[coordx][coordy])dfs(grid  ,  vis , coordx , coordy);
            }
        }
    }
}