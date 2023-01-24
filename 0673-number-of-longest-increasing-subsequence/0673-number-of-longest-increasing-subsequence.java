class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len[] = new int[nums.length];
        int cnt[] = new int[nums.length];
        int res = 0 ;
        int max_len = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            len[i] = 1 ;
            cnt[i] = 1 ;
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j]+1)cnt[i] += cnt[j] ;
                    if(len[i] < len[j]+1){
                        len[i] = len[j] + 1 ;
                        cnt[i] = cnt[j] ;
                    }
                }
            }
            if(max_len == len[i])res += cnt[i] ;
            if(max_len < len[i]){
                max_len = len[i] ;
                res = cnt[i] ;
            }
        }
        return res ;
    }
}