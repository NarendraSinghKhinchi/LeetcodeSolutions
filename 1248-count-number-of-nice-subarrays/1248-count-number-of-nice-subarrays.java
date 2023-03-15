class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
//         int i = 0 ;
//         int j = 0 ;
//         int odd = 0 ;
//         int count = 0 ;
//         while(j < nums.length ){
//             if(nums[j] % 2 != 0){
//                 odd++ ;
//             }
//             while(odd > k && i < j ){
//                 if(nums[i++] % 2 != 0){
//                     odd-- ;
//                 }
//             }
//             if(odd == k)count += 1 ;
//             j++ ;
//         }
//         while(odd == k && i < nums.length){
//             if(nums[i++] % 2 != 0 )odd-- ;
//             count += 1 ;
//         }
        
//         return count ;
        int oddcount=0;
        int res=0;
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2==1){
                oddcount++;
                count=0;
            }
            while(oddcount==k){
                if(nums[i++]%2==1) oddcount--;
                count++;
            }
            res+=count;
        }
        return res;
    }
}