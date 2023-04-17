class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> list = new ArrayList<>();
        
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < candies.length ; i++){
            max = Math.max(candies[i] , max);
        }
        for(int i = 0 ; i < candies.length ; i++){
            int arr = candies[i] + extraCandies ;
            if(arr < max){
                list.add(false);
            }else list.add(true);
        }
        return list ;
    }
}
