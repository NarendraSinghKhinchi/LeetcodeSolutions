class Solution {
    public int maxVowels(String s, int k) {
        
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int num = 0;
        int i = 0 ;
        int j = 0 ;
        while(j < k){
            char ch = s.charAt(j++);
            if(set.contains(ch))num++ ;
        }
        int max = num ;
        while(j < s.length()){
            char ch = s.charAt(j++);
            if(set.contains(ch))num++ ;
            
            char ch2 = s.charAt(i++);
            if(set.contains(ch2))num-- ;
            
            max = Math.max(max , num);
        }
        return max ;
    }
}