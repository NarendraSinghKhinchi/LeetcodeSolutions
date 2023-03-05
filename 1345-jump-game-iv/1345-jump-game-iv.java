class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        // we will be storing indexex corresponding to value
        for(int i = 0 ; i < arr.length ; i++){
            int val = arr[i] ;
            if(hm.containsKey(val)){
                hm.get(val).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(val , list);
            }
        }
        int n = arr.length ;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        // will be storing indexes in queue
        boolean visited[] = new boolean[arr.length];
        int steps = 0 ;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int i = q.remove();
                
                if(i == n-1)return steps ;
                if(i+1 < n && !visited[i+1]){
                    q.add(i+1);
                    visited[i+1] = true ;
                }
                if(i-1 >= 0 && !visited[i-1]){
                    visited[i-1] = true ;
                    q.add(i-1);
                }
                ArrayList<Integer> nbrs = hm.get(arr[i]);
                // System.out.println(nbrs);
                for(int nbr : nbrs){
                    if(!visited[nbr] && nbr != i){
                        q.add(nbr);
                        visited[nbr] = true ;
                    }
                }
                hm.get(arr[i]).clear();
            }
            steps++ ;
        }
        return -1 ;
    }
}