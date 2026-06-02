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

    public int[][] updateMatrix(int[][] mat) {
        Queue<Coord> q = new LinkedList<>();
        boolean[][] m = new boolean[mat.length][mat[0].length];
       for(int i=0 ; i<mat.length ; i++){
        for(int j=0 ; j<mat[0].length; j++){
            if(mat[i][j] == 0){
                q.add(new Coord(i , j));
                
            }
            
        
        }
       }
       int dx[] = {-1 , 1 , 0 , 0};
       int dy[] = {0 , 0, -1 , 1}; 
       int dist = 0;
       while(!q.isEmpty()){
        int size = q.size();
        dist++;
        for(int j=0 ; j<size ; j++){
        Coord temp  = q.poll();
            for(int i=0 ; i<4 ; i++){
                int xc = temp.x + dx[i];
                int yc = temp.y + dy[i];
                if(xc>=0 && xc<mat.length && yc>=0 && yc<mat[0].length)
                if(m[xc][yc] == false && mat[xc][yc] == 1){
                    mat[xc][yc] = dist;
                    m[xc][yc] = true;
                    q.add(new Coord(xc, yc));
                }
            }
        }
       
       }
        return mat;
    }
}