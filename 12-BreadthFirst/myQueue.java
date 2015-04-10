import java.util.*;

public class myQueue{
    private Node head,tail;

    public myQueue(int x, int y){
	head = new Node(x, y);
	tail = head;
    }

    public void enqueue(Node n){
	if (tail == null){
	    head = n;
	    tail = n;
	}
	else {
	    tail.setNext(n);
	    tail = n;
	}
    }

    public Pnode dequeue(){
	if (empty()){
	    throw new NoSuchElementException();
	}
        Pnode val = new Pnode(head.getX(),head.getY());
	val.setPrevious(head.getPrevious());
        head = head.getNext();
	if (head == null){
	    tail = head;
	}
        return val;
    }

    public boolean empty(){
	return head == null;
    }

    public String toString(){
	String s = "";
	for (Node tmp = head; tmp!= null; tmp = tmp.getNext()){
	    s =  tmp + "<----" + s;
	}
	s += "null";
	return s;
    }
    
}
