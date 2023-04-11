class Solution {
    public String longestPalindrome(String s) {
        char arr[] = s.toCharArray();
        String ans = "";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1 ; j <= s.length() ; j++){
                // String str = s.substring(i , j);
                if(palin(arr , i , j) && (j-i+1) > ans.length()){
                    ans = s.substring(i , j);
                }
                // if(palin(str) && str.length() > ans.length()){
                //     ans = str ;
                // }
            }
        }
        return ans;
    }
    public boolean palin(char arr[], int i , int j){
        // int i = 0 ; 
        // int j = s.length()-1;
        j-- ;
        while(i < j){
            if(arr[i] != arr[j])return false ;
            i++ ;
            j-- ;
        }
        return true ;
    }
} 