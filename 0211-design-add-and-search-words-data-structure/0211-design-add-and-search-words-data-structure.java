class WordDictionary {

    public WordDictionary() {
        this.end = false ;
        this.children = new WordDictionary[26];
    }
    boolean end ;
    WordDictionary [] children ;
    public void addWord(String word) {
        if(word.length() == 0){
            end = true ;
            return ;
        }
        char ch = word.charAt(0);

        if(children[ch-'a'] == null){
            children[ch-'a'] = new WordDictionary();
        }
        children[ch-'a'].addWord(word.substring(1));
        
    }
    
    public boolean search(String word) {
        if(word.length() == 0)return end ;
        char ch = word.charAt(0);
        if(ch != '.'){
            if(children[ch-'a'] == null ){
                return false ;
            }
            return children[ch-'a'].search(word.substring(1));
        }else
            for(int i =0  ; i < 26 ; i++){
                if(children[i] != null){
                    boolean bool = children[i].search(word.substring(1));
                    if(bool)return true ;
                }
            }
        return false ;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */