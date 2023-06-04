class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        char prev = s.charAt(s.length()-1);
        int val = hm.get(prev);
        for(int i = s.length()-2 ; i >= 0 ; i--){
            int cval = hm.get(s.charAt(i));
            int pval = hm.get(prev);
            if(cval < pval ){
                val -= cval ;
            }else{
                val += cval ;
            }
            prev = s.charAt(i);
        }
        return val ;
    }
}