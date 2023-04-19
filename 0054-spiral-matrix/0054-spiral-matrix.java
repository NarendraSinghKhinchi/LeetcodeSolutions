class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int str = 0 ;
        int enr = matrix.length-1 ;
        int stc = 0 ;
        int enc = matrix[0].length-1 ;
        int count = 0;
        int ds = matrix.length * matrix[0].length ;
        int i , j ;
        List<Integer> list = new ArrayList<>();
        while(count < ds){
            i = str ;
            j = stc ;
            while(j <= enc && count < ds){
                list.add(matrix[i][j]);
                j++ ;
                count++ ;
            }
            j-- ;
            str += 1 ;
            i = str ;
            while(i <= enr && count < ds){
                list.add(matrix[i][j]);
                i++ ;
                count++ ;
            }
            i-- ;
            enc -= 1 ;
            j = enc ;
            while(j >= stc && count < ds){
                list.add(matrix[i][j]);
                j-- ;
                count++ ;
            }
            j++ ;
            enr -= 1 ;
            i = enr ;
            while(i >= str  && count < ds){
                list.add(matrix[i][j]);
                i-- ;
                count++ ;
            }
            stc += 1;
        }
        return list ;
    }
}