class Trie {

    public Trie() {
        this.childNode = new Trie[26] ;
        this.end = false ;
    }
    Trie[] childNode ;
    boolean end ;
    
    public void insert(String word) {
        if(word.length() == 0){
            end = true ;
            return ;
        }
        char ch = word.charAt(0);
        Trie child ;
        if(childNode[ch-'a'] == null){
            child = new Trie() ;
        }else{
            child = childNode[ch-'a'];
        }
        childNode[ch-'a'] = child ;
        String sub = word.substring(1);
        
        child.insert(sub);
        
    }
    
    public boolean search(String word) {
        if(word.length() == 0 )return end ;
        
        
        char ch = word.charAt(0);
        
        if(childNode[ch-'a'] == null){
            return false ;
        }
        Trie child = childNode[ch-'a'];
        String sub = word.substring(1);
          
        return child.search(sub) ;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0)return true ;
        
        char ch = prefix.charAt(0);
        
        if(childNode[ch-'a'] == null){
            return false ;
        }
        Trie child = childNode[ch-'a'];
        String sub = prefix.substring(1);
          
        return child.startsWith(sub) ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */