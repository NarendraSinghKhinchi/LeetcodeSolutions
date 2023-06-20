class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        long num[] = new long[nums.length];
        num[0] = nums[0] ;
        for(int i = 1 ; i<nums.length ;i++)num[i] = num[i-1]+nums[i] ;
        int avg[] = new int[nums.length];
        int div = k+k+1 ;
        for(int i = 0 ; i < nums.length ;i++){
            
            long back = backvalue(num , i-k);
            long front = frontvalue(num , i+k);
            if(back != -1 && front != -1){
                avg[i] = (int)((front-back)/div) ;
            }else avg[i] = -1 ;
            
        }
        
        return avg ;
    }
    public long backvalue(long nums[] , int idx){
        if(idx < 0)return -1 ;
        if(idx == 0)return 0;
        
        return nums[idx-1];
    }
    public long frontvalue(long nums[] , int idx){
        if(idx >= nums.length)return -1 ;
        return nums[idx];
    }
}
