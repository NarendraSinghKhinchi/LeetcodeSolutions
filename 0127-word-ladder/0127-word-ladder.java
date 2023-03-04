class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> seen = new HashSet<>();
        HashSet<String> valid = new HashSet<>();
        
        for(String str : wordList)valid.add(str);
        if(!valid.contains(endWord))return 0 ;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int steps = 0 ;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String rem = q.remove();
                if(rem.equals(endWord))return steps+1 ;
                
                for(int i = 0 ;i < rem.length() ; i++){
                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        String next = rem.substring(0 , i) + ch + rem.substring(i+1);
                        if(valid.contains(next) && !seen.contains(next)){
                            q.add(next);
                            seen.add(next);
                        }
                    }
                }
            }
            steps++ ;
        }
        return 0 ;
    }
}