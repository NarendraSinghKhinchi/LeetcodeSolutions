class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0 ;
        int l = 0 ;
        int h = people.length - 1 ;
        while(h >= l){
            if(people[h] + people[l] <= limit){
                l++ ;
            }
            boats++ ;
            h-- ;
        }
        return boats ;
    }
}











