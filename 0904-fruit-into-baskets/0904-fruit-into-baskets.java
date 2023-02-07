class Solution {
    public int totalFruit(int[] fruits) {
        int min = 0 ;
        int i = 0 ;
        
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int j = 0 ; j < fruits.length ; j++){
            set.put(fruits[j] , set.getOrDefault(fruits[j],0)+1);
            
            while(set.size() > 2){
                set.put(fruits[i] , set.get(fruits[i]) - 1) ;
                if(set.get(fruits[i]) == 0)set.remove(fruits[i]);
                i++ ;
            }
            
            min = Math.max(min , j-i+1);
            
        }
        return min ;
    }
}