class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // g is child and s is cookie
        int ans = 0 ;
        int j = 0 ;
        for(int i = 0 ; i < s.length && j < g.length ; i++){
            if(s[i]  >= g[j] ){
                ans += 1 ;
                j++ ;
            }
        }
        return ans ;
    }
}