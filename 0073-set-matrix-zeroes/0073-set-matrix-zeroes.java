class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<int[]> set = new HashSet<>();
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j =0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    set.add(new int[]{i,j});
                }
            }
        }
        for(int arr[] : set){
//             set row
            int i = arr[0] ;
            for(int j =0 ; j < matrix[0].length ; j++){
                matrix[i][j] = 0 ;
            }
            
//             set col
            int j = arr[1] ;
            for( i = 0 ; i < matrix.length ;i++){
                matrix[i][j] = 0 ;
            }
        }
    }
    
}