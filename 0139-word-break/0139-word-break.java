class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String str : wordDict)dict.add(str);
        dict.add("");
        int dp[] = new int[s.length()];
        
        return recurs(s , dict , 0 , dp);
    }
    public boolean recurs(String s , HashSet<String> dict , int idx , int dp[]){
        if(idx==s.length())return true ;
        if(dp[idx] != 0)return dp[idx] == 1 ? true : false ;
        boolean bool = false ;
        for(int j = idx ; j < s.length() ; j++){
            String sub = s.substring(idx , j+1);
            if(dict.contains(sub)){
                bool = recurs(s , dict , j+1 , dp);
                if(bool)break ;
            }
        }
        dp[idx] = bool ? 1 : 2 ;
        return bool ;
    }
}