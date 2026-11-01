class Solution {
    int[] dx = {-1 , 1,  0 , 0};
    int[] dy = {0 , 0 , -1 , 1};

    public boolean exist(char[][] board, String word) {
        
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                vis[i][j] = true;
                if(kar(board , word , i , j ,0 ,  vis)) return true;
                vis[i][j] = false;
            }
        }
        return false;
    }
    public boolean kar(char[][] board , String word , int x , int y , int a ,boolean[][] vis){
        // if(a==word.length() ){
        //     return true;
        // }
        
        if(board[x][y] == word.charAt(a)){
            if(a==word.length() - 1) return true;
           for(int i=0 ; i<4 ; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX>=0 && newX<board.length && newY>=0 && newY<board[0].length && !vis[newX][newY]){
                    
                    vis[newX][newY] = true;
                   if(kar(board , word, newX , newY , a+1 , vis)) return true;
                  
                   vis[newX][newY] = false;
                }
           }

        }  
           return false;   
    }

}