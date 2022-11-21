class Solution {
    public int totalNQueens(int n) {
        int chess[][] = new int[n][n] ;
        return recursion(chess , 0 ) ;
    }
    public static int recursion(int chess[][] , int row){
        if(row == chess.length){
            // it means we just found a solution
            return 1 ;
        }
        int count = 0 ;
        for(int col = 0 ; col < chess.length ; col++){
            if(safe(chess , row , col)){
                chess[row][col] = 1 ;
                count += recursion(chess , row + 1 );
                chess[row][col] = 0;
            }
        }
        return count ;
    }
    public static boolean safe(int chess[][] , int row , int col){
        
        for(int i = row ; i >= 0 ; i-- ){
            if(chess[i][col] != 0)return false;
        }
        for(int i = row , j = col ; i >= 0 && j>= 0 ; i-- , j--){
            if(chess[i][j] != 0)return false ;
        }
        for(int i = row , j = col ; i >= 0 && j < chess.length ; i-- , j++){
            if(chess[i][j] != 0)return false ;
        }
        return true ;
    } 
}