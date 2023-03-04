class Solution {
    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> seen = new HashSet<>();
        for(String str : deadends)seen.add(str);
        if (seen.contains("0000")) return -1;
        Queue<String> q = new ArrayDeque<>();
        q.add("0000");
        int steps = 0 ;
        
        while(q.isEmpty() == false){
            int size = q.size();
            while(size-- > 0){
                String rem = q.remove();
                if(rem.equals(target))return steps ;
                
//                 for(int i = 0 ; i < 10 ; i++){
                    
//                     for(int j = 0 ; j < 4 ; j++){
//                         String nbr = rem.substring(0,j) + i + rem.substring(j+1);
//                         if(!seen.contains(nbr)){
//                             q.add(nbr);
//                             seen.add(nbr);
//                         }
//                     }
//                 }
                for (String nextLock : getNextStates(rem)) {
                    if (!seen.contains(nextLock)){
                        q.offer(nextLock);
                        seen.add(nextLock);
                    } 
                }
            }
            // System.out.println(q);
            steps++ ;
        }
        return -1 ;
    }
    
} 

    //    public int openLock(String[] deadends, String target) {
    //     Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
    //     if (deadSet.contains("0000")) return -1;
    //     Queue<String> q = new LinkedList<>(Collections.singletonList("0000"));
    //     for (int steps = 0; !q.isEmpty(); ++steps) {
    //         for (int i = q.size(); i > 0; --i) {
    //             String curr = q.poll();
    //             if (curr.equals(target)) return steps;
    //             for (String nei : neighbors(curr)) {
    //                 if (deadSet.contains(nei)) continue;
    //                 deadSet.add(nei); // Marked as visited
    //                 q.offer(nei);
    //             }
    //         }
    //     }
    //     return -1;
    // }
    
    