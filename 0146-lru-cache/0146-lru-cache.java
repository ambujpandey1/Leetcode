class LRUCache {

    public class Node{
        int key,val;
        Node next;
        Node prev;

        Node(int k, int v){
            key=k;
            val=v;
            prev=next=null;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    
    Map<Integer,Node> map=new HashMap<>();
    
    int limit;
    public LRUCache(int capacity) {
        limit=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
    if (node == null) return -1;

    // Move the accessed node to the front
    removeNode(node);
    addNode(node);
    return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldn=map.get(key);
            removeNode(oldn);
            map.remove(key);
        }
        if(map.size()==limit){
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        
        Node newnode=new Node(key,value);
        addNode(newnode);
        map.put(key,newnode);
    }

    private void addNode(Node node){
      Node addnext=head.next;
      head.next=node;
      addnext.prev=node;
      node.next=addnext;
      node.prev=head;
    }

    private void removeNode(Node node){
        Node nodenext=node.next;
        Node nodeprev=node.prev;

        nodeprev.next=nodenext;
        nodenext.prev=nodeprev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */