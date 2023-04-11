class Solution {
    public String removeStars(String s) {
        ArrayList<Character> li = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                li.add(ch);
            }else{
                li.remove(li.size()-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : li)sb.append(ch);
        return sb.toString();
    }
}