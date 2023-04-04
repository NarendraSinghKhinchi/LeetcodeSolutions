class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 1 ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                ans += 1 ;
                set = new HashSet<>();
            }
            set.add(ch);
        }
        return ans ;
    }
}