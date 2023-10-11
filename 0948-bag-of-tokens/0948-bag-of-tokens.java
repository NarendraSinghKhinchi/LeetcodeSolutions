class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0 ;
        int curr = 0 ;
        int i = 0 ;
        int j = tokens.length ;
        while(i < j){
            // System.out.println(power);
            
            if(tokens[i] <= power){
                curr += 1 ;
                power -= tokens[i];
                i++;
            }else if(curr > 0){
                curr -= 1 ;
                j--;
                power += tokens[j];
            }else i++ ;
            ans = Math.max(curr, ans);
            // System.out.println(curr);
        }
        return ans ;
    }
}