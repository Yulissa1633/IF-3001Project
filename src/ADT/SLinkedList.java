package ADT;

import Business.ListBusiness;

public class SLinkedList {
	
	private Node head; 
	private Node tail; 
	private int size; 

	
	public SLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

	public int size() throws ListException {
		if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = head;
        int count = 0;
        
        while(aux!=null){
            count++;
            aux = aux.next;
        }
        return count;
	}

	public boolean isEmpty() {
		 return this.head==null;
	}

	public void addFirst(Node element) {
		Node newNode = element;
        if(this.isEmpty()){
            this.head = newNode;
        }
        else{
            newNode.next = this.head;
            this.head = newNode; 
        }
		
	}

	public void addLast(Node element) {
		Node newNode = element;
        if(this.isEmpty()){
            this.head = newNode;
        }
        else{
            Node aux = head;
           
            while(aux.next!=null){
                aux = aux.next;
            }
           
            aux.next = newNode;
            this.tail = newNode;
            newNode.prev = aux;
        }
		
	}

	public void InsertBefore(Node element, Node element2) {
		Node newNode = element;
		Node exist = element2;
        Node aux = head;
           
        
            while(!ListBusiness.equals(aux.element, element2.getData())&&aux.next!=null){     
                aux = aux.next;
            }
            
        
           
            newNode.prev = aux.prev;
            aux.prev.next = newNode;
            aux.prev = newNode;
            newNode.next = aux;
            
	}

	public void InsertAfter(Node element, Node element2) {
		Node newNode = element;
		Node exist = element2;
        Node aux = head;
           
            while(!ListBusiness.equals(aux.element, element2.getData())&&aux.next!=null){
                aux = aux.next;
            }
           
            aux.next = newNode;   
		
	}

	public Object removeFirst() throws ListException {
		 if(this.isEmpty()){
	            throw new ListException("Singly Linked List is Empty");
	        }
	        Object element = this.head.element;
	        this.head = this.head.next; 
	        return element;
	}

	public Object removeLast() throws ListException {
		 if(this.isEmpty()){
	            throw new ListException("Singly Linked List is Empty");
	        }
	        Node aux = this.head;
	        Node aux2 = head; 
	        while(aux.next!=null){
	            aux2 = aux; 
	            aux = aux.next; 
	        }
	       
	        Object element = aux.element;
	        aux2.next = null; 
	        this.tail = null;
	        return element;
	}

	public Object getFirst() throws ListException {
		 if(this.isEmpty()){
	            throw new ListException("Singly Linked List is Empty");
	        }
	        return this.head.element;
	}

	public Object getLast() throws ListException {
		 if(this.isEmpty()){
	            throw new ListException("Singly Linked List is Empty");
	        }
	        return this.tail.element;
	}

	public Object getPrev(Object element) throws ListException {
		if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }      
        if(ListBusiness.equals(head.element, element)){
            return "Es el inicio, no tiene anterior";
        }        
        Node aux = head;
        while(aux.next!=null){
            if(ListBusiness.equals(aux.next.element, element)){
                return aux.element;
            }
            aux = aux.next;
        }
        return "El elemento no existe en la lista";
	}

	public Object getNext(Object element) throws ListException {
		if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = head;
        while(aux!=null){
            if(ListBusiness.equals(aux.element, element)){
                if(aux.next!=null){
                    return aux.next.element;
                }else{
                    return "no tiene";
                }
            }
            aux = aux.next;
        }
        return "El elemento no existe en la lista";
	}

	public Node getNode(int index) throws ListException {
		 if(this.isEmpty()){
	            throw new ListException("Singly Linked List is Empty");
	        }
	        Node aux = head;
	        int i = 1; 
	        while(aux!=null){
	            if(i == index){
	                return aux; 
	            }
	            i++;
	            aux = aux.next;
	        }
	        return null; 
	}
}
