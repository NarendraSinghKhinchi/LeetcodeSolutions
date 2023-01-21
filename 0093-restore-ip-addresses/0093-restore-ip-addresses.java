class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        recurs(0 , s , "" , "" , ans , 0);
        return ans ;
    }
    public void recurs(int idx , String s , String asf , String curr , List<String> ans , int len){
        if(len >= 4)return ;
        if(idx >= s.length() ){
            if( len + 1 == 4)
                ans.add(asf  + curr);
            return ;
        }
        char ch = s.charAt(idx);
        if(curr.length() == 0 || (curr.charAt(0) != '0' && Integer.parseInt(curr+ch) <= 255 )){
            recurs(idx+1 , s , asf , curr+ch , ans , len);
        }
        if(len + 1 <= 4 && curr.length() != 0 ){
            recurs(idx+1 , s , asf  + curr + ".", "" + ch , ans , len+1);
        }
    }
}