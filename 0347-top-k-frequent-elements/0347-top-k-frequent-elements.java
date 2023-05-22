class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : nums){
            hm.put(x , hm.getOrDefault(x , 0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int a[] , int b[]){
                return -(Integer.compare(a[1],b[1]));
            }
            
        });
        
        for(int x : hm.keySet()){
            pq.add(new int[]{x , hm.get(x)});
        }
        int arr[] = new int[k];
        int i = 0 ;
        while(k > 0){
            arr[i++] = pq.remove()[0] ;
            k-- ;
        }
        return arr ;
    }
}