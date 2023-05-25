class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < time.length ; i++){
            time[i] = time[i]%60 ;
        }
        
        int count = 0 ;
        for(int x : time){
            if(x == 0)count += hm.getOrDefault(0 , 0);
            else
            count += hm.getOrDefault(60-x , 0 );
            hm.put(x , hm.getOrDefault(x,0)+1);
        }
//         int[] freq = new int[60];
//         int res=0;

//         for(int t: time){
//             int val = t%60;
//             if(val==0){
//                 res += freq[0];
//             }
//             else{
//                 res += freq[60-val];
//             }
//             freq[val]++;
//         }
//         return res;
        return count ;
    }
}