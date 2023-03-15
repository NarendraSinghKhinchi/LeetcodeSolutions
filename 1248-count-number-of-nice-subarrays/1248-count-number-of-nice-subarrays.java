class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int i = 0 ;
        int j = 0 ;
        int odd = 0 ;
        int count = 0 ;
        int res=0;
        while(j < nums.length ){
            if(nums[j] % 2 != 0){
                odd++ ;
                count = 0 ;
            }
            while(odd == k){
                if(nums[i++] % 2 != 0){
                    odd-- ;
                }
                count++ ;
            }
            res += count ;
            j++ ;
        }

        
        return res ;
        
        // for(int j=0;j<nums.length;j++){
        //     if(nums[j]%2==1){
        //         oddcount++;
        //         count=0;
        //     }
        //     while(oddcount==k){
        //         if(nums[i++]%2==1) oddcount--;
        //         count++;
        //     }
        //     res+=count;
        // }
        
    }
}