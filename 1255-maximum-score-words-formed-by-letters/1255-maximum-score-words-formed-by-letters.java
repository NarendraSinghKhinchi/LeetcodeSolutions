class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		} 
        return recurs(words , farr , score , 0);
    }
    public int recurs(String[] words, int farr[], int[] score , int idx){
        if(idx == words.length){
            return 0 ;
        }
        int scoreNo = recurs(words , farr , score , idx+1) ;
        int scoreYes = 0 ;
        int cscore = 0 ;
        String word = words[idx] ;
        boolean flag = true ;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(farr[ch - 'a'] == 0 ){
                flag = false ;
            }
            farr[ch - 'a'] -- ;
            cscore += score[ch - 'a'] ;
        }
        if(flag){
            scoreYes = cscore + recurs(words , farr , score , idx+1) ;
        }
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++  ;
        }
        return Math.max(scoreNo , scoreYes);
    }
}




