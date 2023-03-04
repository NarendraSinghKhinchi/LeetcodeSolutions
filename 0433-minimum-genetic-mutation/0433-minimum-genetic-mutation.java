class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        HashSet<String> ban = new HashSet<>();
        for(String str : bank)ban.add(str);
        q.add(start);
        seen.add(start);
        int steps = 0 ;
        char ch[] = new char[]{'A' , 'C' , 'G' , 'T'};
        while(!q.isEmpty()){
            int size = q.size() ;
            for(int j = 1 ; j <= size ; j++){
                String rem = q.remove();
                if(rem.equals(end))return steps ;
            
            
            
                for(char c : ch){
                    for(int i = 0 ; i < rem.length() ; i++){
                        String nbr = rem.substring(0 , i) + c + rem.substring(i+1);
                        if(!seen.contains(nbr) && ban.contains(nbr)){
                            q.add(nbr);
                            seen.add(rem);
                        }
                    }
                }
            }
            
            steps++ ;
        }
        return -1 ;
    }
}