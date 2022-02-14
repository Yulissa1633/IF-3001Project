package ADT;

public class Node {
    public Object element; 
    public Node next; 
    public Node prev; 
    
    
    public Node(Object element){
        this.element = element;
        this.next = this.prev = null;
    }
    
    
    public Node(){
        this.prev = this.next = null;
    }

    public Object getData() {
        return element;
    }

    public void setData(Object data) {
        this.element = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
}
