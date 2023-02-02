class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int rank[] = new int[26];
        for(int i = 0 ; i < order.length() ; i++){
            int idx = (order.charAt(i)-'a');
            rank[idx] = i ;
        }
        for(int i = 0 ; i < words.length - 1 ; i++){
            boolean compare = compare(words[i] , words[i+1] , rank);
            if(!compare)return compare ;
        }
        return true ;
    }
    public boolean compare(String str1 , String str2 , int rank[]){
        
        int i = 0 ;
        int j = 0 ;
        while(i < str1.length() || j < str2.length()){
            if(j == str2.length())return false ;
            if(i == str1.length())return true ;
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if(ch1 != ch2){
                int idx1 = (ch1-'a');
                int idx2 = (ch2-'a');
                if(rank[idx1] > rank[idx2])return false ;
                else break ;
            }
            i++ ; j++ ;
        }
        return true ;
    }
}