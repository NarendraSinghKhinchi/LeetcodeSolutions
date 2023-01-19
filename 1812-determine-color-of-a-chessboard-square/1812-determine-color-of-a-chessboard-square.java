class Solution {
    public boolean squareIsWhite(String coordinates) {
        int row = (coordinates.charAt(0)-'a' + 1) ;
        int col = (coordinates.charAt(1) - '0') ;
        // System.out.println(row + "  " +col);
        if(row % 2 == 0 && col % 2 == 0)return false ;
        if(row %2 != 0 && col % 2 != 0)return false ;
        return true ;
    }
}