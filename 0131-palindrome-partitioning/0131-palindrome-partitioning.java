class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solution(ans , list , s , 0);
        return ans;
    }
    public boolean ispalin(List<String> list){
        for(int i = 0 ; i < list.size() ; i++){
            String str = list.get(i);
            int l = 0 ;
            int h = str.length() - 1 ;
            while(l < h){
                if(str.charAt(l) != str.charAt(h))return false ;
                l++ ; h-- ;
            }
        }
        return true ;
    }
    public void solution(List<List<String>> ans , List<String> list , String s , int idx){
        if(idx == s.length()){
            // System.out.println(list);
            if(ispalin(list)){
                ans.add(new ArrayList<>(list));
            }
            return ;
        }else if(idx > s.length())return ;
        // old and new two choice
        // char ch = s.charAt(idx);
        // list.add(ch + "");
        // solution(ans , list , s , idx+1);
        // list.remove(list.size() - 1);
        
        for(int i = 0 ; i+idx < s.length() ; i++){
            String sub = s.substring(idx , idx+i+1);
            list.add(sub);
            solution(ans , list , s , idx + i + 1);
            list.remove(list.size()-1);
        }
    }
}





