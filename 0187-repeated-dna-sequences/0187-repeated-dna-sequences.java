class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < s.length()-9; i++){
            String sub = s.substring(i , i+10);
            hm.put(sub,hm.getOrDefault(sub,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(String str : hm.keySet()){
            if(hm.get(str) >= 2)list.add(str);
        }
        return list ;
    }
}