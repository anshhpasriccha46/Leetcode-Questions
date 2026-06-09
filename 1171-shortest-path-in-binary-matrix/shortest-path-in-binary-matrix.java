import java.util.*;
class coord{
    int x;
    int y;
    coord(int a, int b){
        x = a;
        y = b;
    }
}
class Solution {
    int dx[] = {-1 , 1 , 0 , 0 , 1 , -1 , 1 , -1};
    int dy[] = {0 , 0 , -1 , 1 , 1 , -1 , -1 , 1};
    public int shortestPathBinaryMatrix(int[][] g) {
        if(g[g.length - 1][g[0].length - 1] != 0 || g[0][0]==1) return -1;
        boolean[][] v = new boolean[g.length][g[0].length];
        Queue<coord> q = new LinkedList<>();
        q.add(new coord(0 , 0));
        int count = 0;
        boolean found = false;
        while(!q.isEmpty()){
            int size=  q.size();
            count++;
           
            for(int j=0 ; j<size ; j++){
                coord temp = q.poll();
                if(temp.x == g.length - 1 && temp.y== g[0].length - 1 ){
                    found = true;
                    break;
                }
              
            for(int i=0 ; i<8 ; i++){
                int xc = temp.x + dx[i];
                int yc = temp.y + dy[i];
                if(xc>=0 && xc<g.length && yc>=0 && yc<g[0].length && !v[xc][yc] && g[xc][yc] == 0){ q.add( new coord( xc , yc ) );
                  v[xc][yc] = true;
                }
            }
            }
            if(found) break;
         
        }
        if(!found) return -1;
        return count;

    }
    public int kar(int g[][] , int x , int y , boolean[][] v){
       
        if(x == g.length - 1 && y== g[0].length - 1){
            return 1;
        }
        if(x<0 || y<0 || x > g.length - 1 || y> g[0].length - 1){
            return -1;
        }
        v[x][y] = true;
        int check = Integer.MAX_VALUE;
        for(int i=0 ; i<8 ;i++){
            int xc = x + dx[i];
            int yc = y + dy[i];
            if( xc>=0 && xc<g.length && yc>=0 && yc<g[0].length && g[xc][yc] == 0 && !v[xc][yc]){
                int see = kar(g , xc , yc , v);

                if(see != -1) {
                    
                    check = Math.min(see , check);
                    // if(x == 0 && y==1){
                    //  System.out.println(xc + " " + yc);
                    //  System.out.println( " " + check);
                    //  }
                    
                    }

                
            }
        }
         v[x][y] = false;
        if(check == Integer.MAX_VALUE) return -1;
        return check + 1;
    }
}