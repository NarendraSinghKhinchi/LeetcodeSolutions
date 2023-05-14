class Solution {
    public int maxScore(int[] nums) {
        this.used = new boolean[nums.length];
        this.hm = new HashMap<>();
        int max = recurs(nums , 1);
        return max ;
    }
    boolean used[] ;
    HashMap<String,Integer> hm ;
    public int gcd(int a , int b){
        if(b == 0)return a ;
        return gcd(b , a%b );
    }
    public int recurs(int []nums , int op ){
        if(op*2 > nums.length)return 0 ;
        String mas = mask();
        if(hm.get(mas) != null)return hm.get(mas);
        int max = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(!used[i] && !used[j]){
                    used[i] = true ;
                    used[j] = true ;
                    int mul = op*gcd(nums[i] , nums[j]) ;
                    int result = mul + recurs(nums , op+1);
                    max = Math.max(result , max);
                    used[i] = false ;
                    used[j] = false ;
                }
            }
        }
        hm.put(mas , max);
        return max ;
    }
    public String mask(){
        StringBuilder sb = new StringBuilder();
        for(boolean bool : used){
            if(bool)sb.append("t");
            else sb.append("f");
        }
        return sb.toString();
    }
}