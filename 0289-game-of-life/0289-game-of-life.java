class Solution {
    public void gameOfLife(int[][] board) {
        
        int arr[][] = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j =0 ; j < board[0].length ; j++){
                int count = livenbrs(board , i , j , true);
                if(board[i][j] == 0 && count == 3){
                    arr[i][j] = 1 ;
                }else if(board[i][j] == 1 && (count ==  3 || count == 2)){
                    arr[i][j] = 1 ;
                }
                
            }
        }
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                board[i][j] = arr[i][j] ;
            }
        }
    }
    public int livenbrs(int [][]board , int i , int j , boolean bool ){
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length )return 0 ;
        if(!bool)return board[i][j] ;
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