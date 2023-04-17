class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        for(int i = 0 ; i < candies.length ; i++){
            boolean bool = true ;
            for(int j = 0 ; j < candies.length ; j++){
                if(candies[i] + extraCandies < candies[j]){
                    bool = false ;
                    break ;
                }
            }
            list.add(bool);
        }
        return list ;
    }
}