class Solution {
    public int longestStrChain(String[] words) {
       Arrays.sort(words , (a,b)->a.length() - b.length());
        
        
        HashMap<String,Integer> dp = new HashMap<>();
        int res = 0 ;
        for(String word : words){
            
            int best = 0 ;
            
            for(int i = 0 ; i < word.length() ; i++){
                String ne = word.substring(0 , i) + word.substring(i+1 , word.length()) ;
                best = Math.max(best , dp.getOrDefault(ne , 0)+1);
            }
            dp.put(word , best);
            res = Math.max(best , res);
        }
        return res ;
    }
}