class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(arr.length != pattern.length())return false ;
        int j = 0 ;
        HashMap<String , Character> hm = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            String word = arr[i];
            if(hm.containsKey(word)){
                char ch = hm.get(word);
                char c = pattern.charAt(j);
                if(ch != c)return false ;
            }else{
                hm.put(word , pattern.charAt(j));
            }
            j++ ;
        }
        // the below code can be avoided by the use of function containsValue();
        j = 0 ;
        HashMap<Character , String> mp = new HashMap<>();
        for(int i =0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            if(mp.containsKey(ch)){
                String st = arr[j] ;
                String str = mp.get(ch);
                if(!st.equals(str))return false ;
            }else{
                mp.put(ch , arr[j]);
            }
            j++ ;
        }
        return true ;
    }
}