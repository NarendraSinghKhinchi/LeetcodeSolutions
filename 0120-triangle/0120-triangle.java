class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int ans[] = new int[triangle.get(triangle.size()-1).size()] ;
        for(int i = triangle.size()-1 ; i>= 0 ; i--){
            List<Integer> triang = triangle.get(i);
            for(int j = 0 ; j < triang.size() ; j++){
                if(i == triangle.size()-1){
                    ans[j] = triang.get(j) ;
                }else{
                    int curr = Math.min(ans[j] , ans[j+1]) ;
                    ans[j] = curr + triang.get(j);
                }
            }
        }
        return ans[0] ;
    }
}