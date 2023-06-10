class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int lenOfWords = words[0].length();
        int lenOfConcat = words.length * lenOfWords ;
        HashMap<String,Integer> hm = new HashMap<>();
        for(String word : words){
            hm.put(word , hm.getOrDefault(word , 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= s.length()-lenOfConcat ; i++){
            String sub = s.substring(i , i+lenOfConcat);
            if(helper(sub , hm , lenOfWords)){
                list.add(i);
            }
        }
        return list ;
    }
    public boolean helper(String s , HashMap<String,Integer> hm, int lenOfWords){
        
        HashMap<String,Integer> hm2 = new HashMap<>();
        for(String str : hm.keySet()){
            hm2.put(str , hm.get(str));
        }
        
        for(int i = 0 ; i < s.length() ; i = i+lenOfWords){
            String sub = s.substring(i , i+lenOfWords);
            if(hm2.containsKey(sub) && hm2.get(sub) > 0){
                hm2.put(sub , hm2.get(sub)-1);
            }else return false ;
        }
        
        for(String str : hm.keySet()){
            if(hm2.get(str) > 0)return false ;
        }
        
        return true ;
    }
}