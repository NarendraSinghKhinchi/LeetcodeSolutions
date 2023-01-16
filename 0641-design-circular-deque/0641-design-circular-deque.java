class MyCircularDeque {

    class Node{
        int val ;
        Node next , prev ;
        Node(int data){
            this.val = data ;
            this.next = null ;
            this.prev = null ;
        }
    }
    
    Node head ;
    Node tail ;
    int size ;
    int currSize ;
    public MyCircularDeque(int k) {
        this.head = new Node(-1);
        this.tail = new Node(-1) ;
        head.next = tail ;
        tail.prev = head ;
        this.size = k ;
        this.currSize = 0 ;
    }
    
    public boolean insertFront(int value) {
        if(currSize == size)return false ;
        Node node = new Node(value);
        Node temp = head.next ;
        head.next = node ;
        node.prev = head ;
        node.next = temp ;
        temp.prev = node ;
        currSize++ ;
        return true ;
    }
    
    public boolean insertLast(int value) {
        if(currSize == size)return false ;
        Node node = new Node(value);
        Node temp = tail.prev ;
        tail.prev = node ;
        node.next = tail ;
        node.prev = temp ;
        temp.next = node ;
        currSize++ ;
        return true ;
    }
    
    public boolean deleteFront() {
        if(currSize == 0)return false ;
        
        Node node = head.next ;
        head.next = node.next ;
        node.next.prev = head ;
        
        currSize-- ;
        return true ;
    }
    
    public boolean deleteLast() {
        if(currSize == 0)return false ;
        
        Node node = tail.prev ;
        tail.prev = node.prev ;
        node.prev.next = tail ;
        
        currSize-- ;
        return true ;
    }
    
    public int getFront() {
        if(currSize == 0)return -1 ;
        Node node = head.next ;
        return node.val ;
    }
    
    public int getRear() {
        if(currSize == 0)return -1 ;
        Node node = tail.prev ;
        return node.val ;
    }
    
    public boolean isEmpty() {
        if(currSize == 0 )return true ;
        return false ;
    }
    
    public boolean isFull() {
        if(currSize == size)return true ;
        return false ;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */