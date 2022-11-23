class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board , 0 , 0);
    }
    public boolean sudoku(char[][]board, int row , int col){
        if(row == 9){
            // it means we found our solution
            return true ;
        }
        int nrow = row ;
        int ncol = col ;
        if(col == 8){
            nrow = row + 1 ; 
            ncol = 0 ;
        }else{
            ncol = col + 1 ;
        }
        if(board[row][col] != '.'){
            boolean bool = sudoku(board , nrow , ncol);
            if(bool)return true;
        }else{
            for(int i = 1 ; i <= 9 ; i++){
                char ch = (char)(i + '0') ;
                if(safe(board , row , col , ch)){
                    board[row][col] = ch ;
                    boolean bool = sudoku(board , nrow , ncol);
                    if(bool)return true ;
                    board[row][col] = '.' ;
                }
            }
        }
        return false ;
    }
    public boolean safe(char[][] board , int row , int col , char ch){
        
        // check horizontally 
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i] == ch )return false ;
        }
        // check vertically 
        for(int j = 0 ; j < 9 ; j++){
            if(board[j][col] == ch )return false ;
        }
        // check in the current cube
        int crow = row % 3 ;
        int ccol = col % 3 ;
        row = row - crow ; 
        col = col -ccol  ;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[row + i][col + j] == ch)return false; 
            }
        }
        return true ;
    }
}