class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            String str = strs[i] ;
            String coded = coder(str);
            if(hm.containsKey(coded)){
                hm.get(coded).add(str);
            }else{
                List<String> lis = new ArrayList<>();
                lis.add(str);
                hm.put(coded , lis);
            }
        }
        for(String str : hm.keySet()){
            list.add(hm.get(str));
        }
        return list ;
    }
    public String coder(String str){
        char chr[] = str.toCharArray();
        Arrays.sort(chr);
        StringBuilder sb = new StringBuilder();
        for(char ch : chr){
            sb.append(ch);
        }
        return sb.toString();
    }
}