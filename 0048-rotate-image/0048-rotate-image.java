class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i =0 ; i < matrix.length ; i++){
            for(int j = i ; j < matrix.length ; j++){
                swap(matrix , i , j );
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            int l = 0 ;
            int h = matrix.length - 1 ;
            while(l < h){
                int t = matrix[i][l] ;
                matrix[i][l]  = matrix[i][h] ;
                matrix[i][h] = t ;
                l++ ;
                h-- ;
            }
        }
        
    }
    public void swap(int [][] matrix , int i , int j){
        int t = matrix[i][j] ;
        matrix[i][j]  = matrix[j][i] ;
        matrix[j][i] = t ;
    }
}