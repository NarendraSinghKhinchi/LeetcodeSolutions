class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = 'z'+1 ;
        for(char ch : letters){
            if(ch > target && ch < ans)ans = ch ;
        }
        if(ans > 'z'){
            ans = letters[0];
        }
        return ans ;
    }
}