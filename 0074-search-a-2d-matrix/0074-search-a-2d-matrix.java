class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int lo = 0 ;
        int hi = matrix.length - 1 ;
        int col = matrix[0].length-1 ;
        while(lo < hi){
            int mid = lo + (hi-lo)/2 ;
            if(matrix[mid][col] < target){
                lo = mid+1 ;
            }else {
                hi = mid ;
            }
        }
        // System.out.println(hi);
        int row = hi ;
        if(lo > hi)return false ;
        
         lo = 0 ;
         hi = matrix[0].length - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2 ;
            if(matrix[row][mid] == target){
                return true ;
            }else if(matrix[row][mid] < target){
                lo = mid + 1 ; ;
            }else{
                hi = mid - 1 ;
            }
        }
        return false ;  
    }
}