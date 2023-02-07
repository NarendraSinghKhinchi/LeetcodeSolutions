class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int cols = matrix.length -1 ; 
        int rows = matrix.length -1 ;
        for(int i = rows-1 ; i >= 0 ; i--){
            for(int j = cols ; j >= 0 ; j--){
                int curr ; 
                if(j == cols){
                    curr = Math.min(matrix[i+1][j] , matrix[i+1][j-1]) ;
                }else if(j == 0){
                    curr = Math.min(matrix[i+1][j+1] , matrix[i+1][j]);
                }else{
                    curr = Math.min(matrix[i+1][j] , Math.min(matrix[i+1][j+1] , matrix[i+1][j-1]));
                }
                matrix[i][j] += curr ;
            }
        }
        int min = Integer.MAX_VALUE ;
        for(int x : matrix[0]){
            min = Math.min(min , x);
        }
        return min ;
    }
}