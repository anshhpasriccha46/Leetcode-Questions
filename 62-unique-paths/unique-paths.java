class Solution {
    int x[] = {-1,1 , 0 , 0};
    int y[] = {0 , 0, -1, 1};
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int dp[][] = new int[m+1][n+1];
        
        for(int i[] : dp){
           Arrays.fill(i , -1);
        }
        dp[m-1][n] = 1;
        dp[m][n-1] = 1;
        return kar(dp , 1 , 1 , m , n);

    }
    public int kar(int dp[][] , int r , int c , int m , int n){
        if(dp[r][c]!=-1) return dp[r][c];
        int count = 0;
        
    int nextX = r + 1;
    int nextY = c;
     if(nextX <= m && nextX>=0 && nextY<=n && nextY>=0){
       count+=kar(dp , nextX  ,nextY ,m , n);
     }
     
     nextX= r;
     nextY = c+1;
     if(nextX <= m && nextX>=0 && nextY<=n && nextY>=0){
       count+=kar(dp , nextX  ,nextY ,m , n);
     }
     

     return dp[r][c]  = count;
    
        
    }
    
}