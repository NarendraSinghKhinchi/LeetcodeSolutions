class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1 ;
        for(int i = digits.length - 1 ; i >= 0 ; i--){
            int s = digits[i]+carry ;
            digits[i] = s%10 ;
            carry = s/10 ;
        }
        
        if(carry == 0)return digits ;
        
        int[] newArr = new int[digits.length+1];
        newArr[0] = carry ;
        System.arraycopy(digits, 0, newArr, 1, digits.length);
        
        return newArr ;
    }
}