class Coord{
    int x;
    int y;
    Coord(int a, int b){
        x = a;
        y = b;
    }
}
class Solution {
    ArrayList<Coord> a = new ArrayList<>();
    boolean doit  = true;
    public void solve(char[][] board) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j] == 'O' && vis[i][j]==false){
                    doit = true;
                    a = new ArrayList<>();
                    bfs(new Coord(i , j) , board ,vis);
                    if(doit){
                        for(Coord t: a){
                            System.out.println(t.x + " " + t.y);
                            System.out.println("HEY");
                            board[t.x][t.y] = 'X';
                        }
                        
                    }
                }
            }

        }
        
    }
    public void bfs(Coord n , char[][] board , boolean[][] vis ){
        Queue<Coord> q= new LinkedList<>();
        q.add(n);
        a.add(n);

        if(n.x == 0 || n.x==board.length-1 || n.y==0 || n.y==board[0].length - 1) doit = false;

        vis[n.x][n.y] = true;
        while(!q.isEmpty()){
            Coord temp = q.poll();
            int dx[] = {-1,1, 0 ,0};
            int dy[] = {0 ,0 , -1 ,1};
            for(int i=0 ; i<4 ; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>=0 && x<board.length && y>=0 && y<board[0].length){
                    if(board[x][y] == 'O' && !vis[x][y]){
                        vis[x][y] = true;
                        Coord t = new Coord(x , y);
                        a.add(t);
                        q.add(t);
                        if(x == 0 || x==board.length-1 || y==0 || y==board[0].length - 1) doit = false;

                    }
                }
            }
             } 
    }
}