class LFUCache {
    int capacity , size , min ;
    HashMap<Integer , Node> nodemap ;
    HashMap<Integer , Doubly> freqmap ;
    public LFUCache(int capacity) {
        this.capacity = capacity ;
        this.size = 0 ;
        this.min = 1 ;
        this.freqmap = new HashMap<>() ;
        this.nodemap = new HashMap<>() ;
    }
    
    public int get(int key) {
        Node node = nodemap.get(key);
        if(node == null)return -1 ;
        update(node);
        return node.val ;
    }
    private void update(Node node){
        Doubly oldlist = freqmap.get(node.freq) ;
        oldlist.remove(node);
        if(oldlist.size == 0 && node.freq == min)min++ ;
        node.freq++ ;
        Doubly newlist = freqmap.getOrDefault(node.freq , new Doubly()) ;
        newlist.add(node);
        freqmap.put(node.freq , newlist);
    }
    public void put(int key, int value) {
        if(capacity == 0)return ;
        if(nodemap.containsKey(key)){
            Node node = nodemap.get(key);
            node.val = value ;
            update(node);
        }else{
            Node node = new Node(key , value);
            nodemap.put(key , node);
            if(size == capacity){
                Doubly oldlist = freqmap.get(min);
                Node removed = oldlist.removeLast();
                if(removed != null){
                    nodemap.remove(removed.key);
                    size-- ;
                }
            }
            size++ ;
            min = 1 ;
            Doubly newlist = freqmap.getOrDefault(node.freq , new Doubly());
            newlist.add(node);
            freqmap.put(node.freq , newlist );
        }
    }
}
class Node{
    int key ;
    int val;
    int freq ;
    Node next , prev ;
    Node(int k , int v){
        this.key = k ;
        this.val = v ;
        this.freq = 1 ;
        this.next = null ;
        this.prev = null ;
    }
}
class Doubly{
    Node head , tail ;
    int size ;
    Doubly(){
        this.head = new Node(-1 , -1) ;
        this.tail = new Node(-1 , -1) ;
        head.next = tail ;
        tail.prev = head ;
        this.size = 0 ;
    }
    public void remove(Node node){
        size-- ;
        Node temp = node.next ;
        node.prev.next = temp ;
        temp.prev = node.prev ;
    }
    public void add(Node node){
        head.next.prev = node ;
        node.next = head.next ;
        node.prev = head ;
        head.next = node ;
        size++ ;
    }
    public Node removeLast(){
        if(size > 0){
            Node last = tail.prev ;
            remove(last);
            return last ;
        }
        return null ;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */