class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> [] set = new HashSet[26] ;
//         long ans = 0l ;
//         for(String str:ideas)set.add(str) ;
//         for(int i = 0 ; i < ideas.length ; i++){
//             for(int j = i+1 ; j < ideas.length ; j++){
//                 String s1 = ideas[j].charAt(0) + ideas[i].substring(1) ;
//                 String s2 = ideas[i].charAt(0) + ideas[j].substring(1);
//                 if(!set.contains(s1) && !set.contains(s2)){
//                     sel.add(s1 +" " + s2);
                    
//                 }
//             }
        // }
        // System.out.println(sel);
        for(int i =0 ; i < 26 ; i++)set[i] = new HashSet<>() ;
        
        for(String idea : ideas){
            int idx = idea.charAt(0) - 'a' ;
            set[idx].add(idea.substring(1));
        }
        long answer = 0l ;
        for(int i = 0 ; i < 26 ; i++){
            for(int j = i+1 ; j < 26 ; j++){
                long mutual = 0 ;
                HashSet<String> set1 = set[i] ;
                HashSet<String> set2 = set[j] ;
                for(String str : set1){
                    if(set2.contains(str))mutual++ ;
                }
                answer += (set1.size() - mutual ) * (set2.size() - mutual) * 2 ;
            }
        }
        return answer;
    }
}


