class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> list = new ArrayList<>();
        // for(int i = 0 ; i < candies.length ; i++){
        //     boolean bool = true ;
        //     for(int j = 0 ; j < candies.length ; j++){
        //         if(candies[i] + extraCandies < candies[j]){
        //             bool = false ;
        //             break ;
        //         }
        //     }
        //     list.add(bool);
        // }
        
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
