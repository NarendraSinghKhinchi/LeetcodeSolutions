class Solution {
    int arr[] ;
    public Solution(int[] nums) {
        this.arr = nums ;
    }
    
    public int[] reset() {
        return arr ;
    }
    
    public int[] shuffle() {
        int shuf[] = new int[arr.length];
        HashSet<Integer> set = new HashSet<>();
        int i = 0 ;
        while(i < shuf.length){
            int random = (int)(Math.random()*arr.length);
            if(!set.contains(random)){
                set.add(random);
                shuf[i] = arr[random];
                i++ ;
            }
        }
        return shuf ;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */