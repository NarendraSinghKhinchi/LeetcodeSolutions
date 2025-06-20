class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        // Map<Integer,Integer> hm = help(nums1 , nums2);
        // Map<Integer,Integer> hm1 = help(nums3 , nums4);
        // int count = 0 ;
        // for(int x : hm.keySet()){
        //     int y = -x ;
        //     if(hm1.containsKey(y)){
        //         count += hm.get(x) + hm1.get(y);
        //     }
        // }
        // return count ;
        
        int [] A = nums1 ;
        int B[] = nums2 ;
        int C[] = nums3 ;
        int D[] = nums4 ;
        Map<Integer, Integer> map = help(C , D);
        // for(int i=0; i<C.length; i++) {
        //     for(int j=0; j<D.length; j++) {
        //         int sum = C[i] + D[j];
        //         map.put(sum, map.getOrDefault(sum, 0) + 1);
        //     }
        // }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }
    public Map<Integer,Integer> help(int []arr , int []num){
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < num.length ; j++){
                int sum = arr[i] + num[j] ;
                hm.put(sum , hm.getOrDefault(sum , 0) + 1);
            }
        }
        return hm ;
    }
}