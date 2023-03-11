class Solution {
    public String pushDominoes(String dominoes) {
        int left[] = new int[dominoes.length()] ;
        int right[] = new int[dominoes.length()] ;
        
        for(int i = dominoes.length() - 1 ; i >= 0 ; i--){
            char ch = dominoes.charAt(i) ;
            if(ch == 'R'){
                left[i] = -1 ;
            }else if(ch == 'L'){
                left[i] = 0 ;
            }else{
                if(i+1 < dominoes.length() && left[i+1] != -1){
                    left[i] = 1+left[i+1];
                }else{
                    left[i] = -1 ;
                }
            }
            // System.out.print(left[i] + " ");
        }
        // System.out.println();

        
        for(int i = 0 ; i < dominoes.length() ; i++){
            char ch = dominoes.charAt(i) ;
            if(ch == 'L'){
                right[i] = -1 ;
            }else if(ch == 'R'){
                right[i] = 0 ;
            }else{
                if(i-1 >= 0 && right[i-1] != -1){
                    right[i] = 1 + right[i-1] ;
                }else{
                    right[i] = -1 ;
                }
            }
            // System.out.print(right[i] + " ");

        }
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < dominoes.length() ; i++){
            
            char ch = dominoes.charAt(i);
            if(ch == 'L')sb.append('L') ;
            else if(ch == 'R')sb.append('R') ;
            else if(left[i] == right[i]) {
                sb.append('.');
            }else if(left[i] != -1 && (left[i] < right[i] || right[i] == -1)){
                sb.append('L') ;
            }else{
                sb.append('R');
            }
        }
        return sb.toString();
    }
}