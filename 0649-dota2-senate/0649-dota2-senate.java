class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new ArrayDeque<>();
        int D = 0 ;
        int R = 0 ;
        for(int i = 0 ; i < senate.length() ; i++){
            q.add(senate.charAt(i));
            if(senate.charAt(i) == 'R')R += 1 ;
            else D += 1 ;
        }
        
        int ds = 0 ;
        int rs = 0 ;
        while(R > 0 && D > 0){
            char rem = q.remove();
            if(rem == 'R'){
                if(rs == 0){
                    q.add(rem);
                    ds += 1 ;
                }else{
                    rs -= 1 ;
                    R -= 1 ;
                }
            }else{
                if(ds == 0){
                    q.add(rem);
                    rs += 1 ;
                }else{
                    ds -= 1 ;
                    D -= 1 ;
                }
            }
        }
        
        if(q.peek() == 'R')return "Radiant" ;
        return "Dire" ;
    }
}