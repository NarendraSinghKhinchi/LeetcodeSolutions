class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] != '.'){
                    if(!horizontal(board , board[i][j] , i , j)){
                        // System.out.println(i + "  " + j + " ho");
                        return false ;
                    }
                        
                    if(!vertical(board , board[i][j] , i , j))return false ;
                    if(!cube(board , board[i][j] , i , j))return false ;
                    
                }
                
            }
        }
        return true ;
    }
    public boolean horizontal(char board[][] , char ch , int i , int j){
        // System.out.println(i + "  " + ch);
        for(int k = 0 ; k < 9 ; k++){
            if(board[i][k] == ch && k != j)return false ;
        }
        return true ;
    }
    public boolean vertical(char board[][] , char ch , int i , int j){
        for(int k = 0 ; k < 9 ; k++){
            if(board[k][j] == ch && i != k)return false ;
        }
        return true ;
    }
    public boolean cube(char board[][] , char ch , int i , int j){
        int st = i-(i%3) ;
        int en = j-(j%3) ;
        for(int k = 0 ; k < 3 ; k++){
            for(int l = 0 ; l < 3 ; l++){
                if(board[st+k][en+l] == ch && (i != (st+k) && j != (en+l)))return false ;
            }
        }
        return true ;
    }
}