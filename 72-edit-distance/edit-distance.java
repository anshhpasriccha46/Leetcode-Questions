class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i[] : dp){
            Arrays.fill(i , -1);
        }
        for(int i=0; i<dp.length; i++){
            dp[i][0] = i;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = i;
        }
        return kar(dp , word1.length() , word2.length()  ,word1 , word2);

    }
    public int kar(int dp[][] , int i , int j , String w1 , String w2){
        if(i==0 || j==0){
            return dp[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i-1)==w2.charAt(j-1)){
            return dp[i][j] =  kar(dp , i-1 ,j-1 , w1 , w2);
        }
        else{
            return dp[i][j] =1+ Math.min( kar(dp , i-1 ,j , w1 , w2) ,  Math.min(kar(dp , i ,j-1 , w1 , w2) ,kar(dp , i-1 ,j-1 , w1 , w2) ));
        }
    }
}