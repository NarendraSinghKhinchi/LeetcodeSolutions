class Solution {
    public int diagonalSum(int[][] mat) {
      // 00  01 02
      // 10  11 12
      // 20  21 22
        int sum = 0 ;
        int i = 0 ; 
        int j = 0 ;
        while(i < mat.length){
            sum += mat[i++][j++] ;
        }
        i = 0 ;
        j = mat.length-1 ;
        while(i < mat.length){
            if(i != j)
                sum += mat[i][j];
            i++ ;
            j-- ;
        }
        return sum ;
    }
}