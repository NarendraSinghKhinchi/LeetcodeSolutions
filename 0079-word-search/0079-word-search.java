class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length] ;
        for(int i = 0 ; i < board.length; i++){
            for(int j =0 ;j < board[0].length ; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board , word , i , j , visited , 0))return true ;
                }
            }
        }
        return false ;
    }
    public boolean dfs(char [][]board , String word , int row , int col , boolean visited[][] , int idx){
        if(idx == word.length())return true ;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col])return false ;
        
        char ch = word.charAt(idx) ;
        // System.out.println(ch + " "+row + " "+col +" "+idx);
        if(board[row][col] != ch)return false ;
        visited[row][col] = true ;
        boolean up = dfs(board , word , row-1 , col , visited , idx+1) ;
        if(up)return up ;
        boolean down = dfs(board , word , row+1 , col , visited , idx+1) ;
        if(down)return down ;
        boolean front = dfs(board , word , row , col+1 , visited , idx+1) ;
        if(front)return front ;
        boolean back = dfs(board , word , row , col-1 , visited , idx+1) ;
        if(back)return back ;
        visited[row][col] = false ;
        return false ;
    }
}