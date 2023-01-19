class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0 ;
        int count = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int num : nums){
            int key = (sum + num%k + k )%k ;
            if(hm.containsKey(key)) count += hm.get(key);
            hm.put(key , hm.getOrDefault(key , 0)+1);
            // System.out.println(hm);
            sum = key ;
        }
        return count ;
    }
}