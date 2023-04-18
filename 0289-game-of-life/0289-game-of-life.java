class Solution {
    public void gameOfLife(int[][] board) {
        
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j =0 ; j < board[0].length ; j++){
                int count = livenbrs(board , i , j , true) + 9 ;
                
                if(board[i][j] == 0){
                    board[i][j] = -count ;
                }else {
                    board[i][j] = count ;
                }
                
            }
        }
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] > 0){
                    int count = board[i][j] % 9 ;
                    if(count == 2 || count == 3){
                        board[i][j] = 1 ;
                    }else board[i][j] = 0 ;
                }else {
                    int count = (-board[i][j]) % 9 ;
                    if(count == 3)
                        board[i][j] = 1 ;
                    else board[i][j] = 0 ;
                }
            }
        }
    }
    public int livenbrs(int [][]board , int i , int j , boolean bool ){
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length )return 0 ;
        if(!bool){
            if(board[i][j] == 0 || board[i][j] == 1)return board[i][j] ;
            
            if(board[i][j] > 0)return 1 ;
            return 0 ;
        }
        int count = 0 ;
        
        count += livenbrs(board , i-1 , j , false)  ;
        count += livenbrs(board , i-1 , j+1 , false)  ;
        count += livenbrs(board , i , j+1 , false)  ;
        count += livenbrs(board , i+1 , j+1 , false)  ;
        count += livenbrs(board , i+1 , j , false)  ;
        count += livenbrs(board , i+1 , j-1 , false)  ;
        count += livenbrs(board , i , j-1 , false)  ;
        count += livenbrs(board , i-1 , j-1 , false)  ;

        
        return count ;
    }
}