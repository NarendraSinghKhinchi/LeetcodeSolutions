class Solution {
    public int totalNQueens(int n) {
        
        // boolean chess[][] = new boolean[n][n] ;
        boolean cols[] = new boolean[n];
        boolean diag[] = new boolean[n + n - 1] ;
        boolean rev[] = new boolean[n + n - 1] ;
        return recurs(n , cols , diag , rev , 0);
    }
    public int recurs(int chess, boolean cols[], boolean diag[], boolean rev[], int row ){
        if(row == chess){
            return 1 ;
        }
        int count = 0 ;
        for(int col = 0 ; col < chess ;col++){
            if(!cols[col] &&  !diag[row+col] && !rev[row - col + chess - 1] ){
                cols[col] = true ;
                diag[row + col] = true ;
                rev[row - col + chess - 1] = true ;
                
                count += recurs(chess , cols , diag , rev , row+1) ;
                    
                cols[col] = false ;
                diag[row + col] = false ;
                rev[row - col + chess - 1] = false ;     
            }
        }
        return count ;
    }
    
}