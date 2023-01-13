class Solution {
    public int trap(int[] height) {
        int pr[] = new int[height.length];
        pr[0] = height[0];
        for(int i = 1 ; i<height.length ; i++){
            pr[i] = Math.max(height[i] , pr[i-1]);
        }
        
        int su[] = new int[height.length];
        su[height.length - 1] = height[height.length-1];
        for(int i = height.length-2 ; i >= 0 ; i--){
            su[i] = Math.max(height[i] , su[i+1]);
        }
        
        int ans = 0 ;
        for(int i = 0 ; i < height.length ; i++){
            ans += (Math.min(pr[i] , su[i]) - height[i] ) ;
        }
        return ans ;
    }
}