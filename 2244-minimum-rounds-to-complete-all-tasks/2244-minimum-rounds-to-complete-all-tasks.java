class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap();
        // Store the frequencies in the map.
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int minimumRounds = 0;
        for(int count : freq.values()){
           
            if(count % 3 == 0){
                minimumRounds += count / 3 ;
            }else if(count % 3 == 2){
                minimumRounds += count / 3 + 1  ;
            }else if(count % 3 == 1){
                if(count - 4 < 0)return -1 ;
                minimumRounds += (count-4)/3 + 2; 
            }
        }
        return minimumRounds ;
    }
}