class Solution {
    public int longestSubsequence(int[] arr, int d) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int x : arr){
            hm.put(x , hm.getOrDefault(x-d , 0)+1);
            max = Math.max(hm.get(x) , max);
        }
        return max ;
    }
}