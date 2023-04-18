class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0; 
        for(int i = 0 ; i < 32 ; i++){
            int first = get(start , i);
            int second = get(goal , i);
            if(first != second)count++ ;
        }
        return count ;
    }
    public int get(int num , int i){
        if(((1 << i) & num) > 0)return 1 ;
        return 0 ;
    }
}