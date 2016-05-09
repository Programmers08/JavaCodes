import java.util.HashMap;

public class LRUCache {
    int maxsize;
    HashMap<Integer, DoubleNode> internalmap = new HashMap<Integer, DoubleNode>();
    DoubleNode head=null;
    DoubleNode end=null;
 
    public LRUCache(int maxsize) {
        this.maxsize = maxsize;
    }
    
    public void setHead(DoubleNode p){
        p.next = head;
        p.pre = null;
 
        if(head!=null)
            head.pre = p;
 
        head = p;
 
        if(end ==null)
            end = head;
    }
 
    public int get(int key) {
        if(internalmap.containsKey(key)){
            DoubleNode p = internalmap.get(key);
            remove(p);
            setHead(p);
            return p.value;
        }
 
        return 0;
    }
 
    public void set(int key, int value) {
        if(internalmap.containsKey(key)){
            DoubleNode present = internalmap.get(key);
            present.value = value;
            remove(present);
            setHead(present);
            
        }else{
            DoubleNode created = new DoubleNode(key, value);
            if(internalmap.size()>=maxsize){
                internalmap.remove(end.key);
                remove(end);
                setHead(created);
            }else{
                setHead(created);
            }    
 
            internalmap.put(key, created);
        }
    }
    
    public void remove(DoubleNode p){
        if(p.pre!=null){
            p.pre.next = p.next;
        }else{
            head = p.next;
        }
 
        if(p.next!=null){
            p.next.pre = p.pre;
        }else{
            end = p.pre;
        }
 
    }
}
class DoubleNode{
    int key;
    int value;
    DoubleNode pre;
    DoubleNode next;
 
    public DoubleNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
