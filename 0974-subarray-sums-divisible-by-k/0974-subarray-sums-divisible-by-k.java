class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0 ;
        int count = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int num : nums){
            int key = (num%k + k )%k ;
            sum += key ;
            if(hm.containsKey(sum % k)) count += hm.get(sum % k);
            hm.put(sum%k , hm.getOrDefault(sum%k , 0)+1);
            // System.out.println(hm);
        }
        return count ;
    }
}