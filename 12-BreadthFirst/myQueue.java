import java.util.*;

public class myQueue{
    private Node head,tail;

    public myQueue(int x, int y){
	head = new Node(x, y);
	tail = head;
    }
    
    public void enqueue(int x, int y){
        Node tmp = new Node(x, y);
	if (tail == null){
	    head = tmp;
	    tail = tmp;
	}
	else {
	tail.setNext(tmp);
	tail = tmp;
	}
    }

    public Pnode dequeue(){
	if (empty()){
	    throw new NoSuchElementException();
	}
        Pnode val = new Pnode(head.getX(),head.getY());
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
	String s = "" + head;
	for (Node tmp = head.getNext(); tmp!= null; tmp = tmp.getNext()){
	    s = tmp + " ---> " + s;
	}
	return s;
    }
  
    public static void main(String[] args){
	myQueue q = new myQueue(1,7);
	q.enqueue(2,4);
	q.enqueue(2,6);
	q.enqueue(6,1);
	q.enqueue(2,4);
	System.out.println(q);
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	q.enqueue(1,2);
	q.enqueue(3,9);
	System.out.println(q);
				
    }
    
}
