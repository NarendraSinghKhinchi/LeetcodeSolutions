class Solution {
    public String addBinary(String aa, String bb) {
        
        StringBuilder ans = new StringBuilder();
        int a = aa.length() - 1 ;
        int b = bb.length() - 1 ;
        int carry = 0 ;
        while(a >= 0 || b >= 0 || carry > 0){
            int sum = carry ;
            if(a >= 0)sum += (aa.charAt(a) - '0')%10 ;
            if(b >= 0)sum += (bb.charAt(b) - '0')%10 ;
            carry = sum/2 ;
            sum = sum%2 ;
            a--;
            b-- ;
            ans.append(sum);
        }
        if(ans.length() == 0)return "0" ;
        return ans.reverse().toString();
    }
}