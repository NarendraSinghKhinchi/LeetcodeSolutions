class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n > 0){
            if(n == 1)return true ;
            if(set.contains(n))break ;
            set.add(n);
            n = getNext(n);
        }
        return false ;
    }
    public int getNext(int n) {
        int curr = 0 ;
        while(n > 0){
            int di = n%10 ;
            curr += (di*di);
            n /= 10 ;
        }
        return curr ;
    }
}
