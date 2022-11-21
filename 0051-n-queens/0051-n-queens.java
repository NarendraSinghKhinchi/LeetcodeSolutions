class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> list  = new ArrayList<>();
        int chess[][] = new int[n][n] ;
        recursion(list , chess , 0 ) ;
        return list ;
    }
    public static void recursion(List<List<String>> ans ,int chess[][] , int row){
        if(row == chess.length){
            // it means we just found a solution
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i < chess.length ; i++){
                String str = "" ;
                for(int j = 0 ; j < chess.length; j++){
                    if(chess[i][j] != 0){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                list.add(str);
            }
            ans.add(list);
            return ;
        }
        for(int col = 0 ; col < chess.length ; col++){
            if(safe(chess , row , col)){
                chess[row][col] = 1 ;
                recursion(ans , chess , row + 1 );
                chess[row][col] = 0;
            }
        }
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