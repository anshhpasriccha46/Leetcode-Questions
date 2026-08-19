class Solution {
    public void rotate(int[][] matrix) {
        int mat[][] = new int[matrix.length][matrix.length];
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                mat[j][rows - i] = matrix[i][j];
            }
            
        }
         for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                matrix[i][j] = mat[i][j] ;
            }
        }
        
    }
}