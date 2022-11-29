class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recurs(list , 0 , 0 , n , "");
        return list ;
    }
    public void recurs(List<String> list , int o , int c , int n , String asf){
        if(c > n || o > n)return ;
        if(c == n && o == c){
            list.add(asf);
            return ;
        }
        recurs(list , o+1 , c , n , asf+"(");
        if(o > c) recurs(list , o , c+1 , n , asf+")");
    }
}