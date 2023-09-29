class Solution {
    public int[][] generateMatrix(int n) {
        
        int mat[][] = new int[n][n] ;
        int count = 1 ;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1; 
        
        while(count <= n*n){
            for(int i = top , j = left ; j <= right && count <= n*n ; j++){
                mat[i][j] = count++ ;
            }
            top += 1 ;
            for(int i = top , j = right ; i <= bottom && count <= n*n ; i++){
                mat[i][j] = count++;
            }
            right -= 1 ;
            for(int i = bottom , j = right ; j >= left && count <= n*n ; j--){
                mat[i][j] = count;
                count++ ;
            } 
            bottom -= 1 ;
            for(int i = bottom , j = left ; i >= top && count <= n*n ; i--){
                mat[i][j] = count ;
                count++ ;
            }
            left += 1 ;
        }
        return mat ;
    }
}