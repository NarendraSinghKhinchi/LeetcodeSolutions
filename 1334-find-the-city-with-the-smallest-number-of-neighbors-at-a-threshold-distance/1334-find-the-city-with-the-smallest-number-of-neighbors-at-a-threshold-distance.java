class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int matrix[][] = new int[n][n] ;
        for(int mat[] : matrix)Arrays.fill(mat , -1);
        for(int edge[] : edges){
            int i = edge[0] ;
            int j = edge[1] ;
            int w = edge[2] ;
            matrix[i][j] = w ;
            matrix[j][i] = w ;
            
        }
        for(int i = 0 ; i < n ; i++){
            matrix[i][i] = 0 ;
        }
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ;i++){
                for(int j =0 ; j< n; j++){

                    if(matrix[i][k] == -1 || matrix[k][j] == -1)continue ;
                    
                    if(matrix[i][j] == -1 || (matrix[i][j] > matrix[i][k] + matrix[k][j])){
                        matrix[i][j] = matrix[i][k] + matrix[k][j] ;
                    }
                
                }
            }
        }
        int ans = -1 ;
        int preach = (int) 1e8 ;
        for(int i = 0 ; i < n ;i++){
            int reach = 0 ; 
            for(int j = 0 ; j < n ;j++){
                if(matrix[i][j] != -1 && matrix[i][j] <= distanceThreshold)reach++ ;
            }
            if(reach <= preach){
                preach = reach ;
                ans = i ;
            }
           
        }
        
        return ans ;
    }
}