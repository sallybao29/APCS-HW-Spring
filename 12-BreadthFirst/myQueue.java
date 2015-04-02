import java.util.*;

public class myQueue{
    private Node head,tail;

    public myQueue(int x, int y){
	head = new Node(x, y);
	tail = head;
    }
    
    public void enqueue(int x, int y){
        Node tmp = new Node(x, y);
	tail.setNext(tmp);
	tail = tmp;
    }

    public int[] dequeue(){
	if (empty()){
	    throw new NullPointerException();
	}
	int[] point = new int[2];
	point[0] = head.getX();
	point[1] = head.getY();
	head = head.getNext();
	return point;
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
    /*
    public static void main(String[] args){
	myQueue q = new myQueue(1,7);
	q.enqueue(2,4);
	q.enqueue(2,6);
	q.enqueue(6,1);
	q.enqueue(2,4);
	System.out.println(q);
	System.out.println(Arrays.toString(q.dequeue()));
				
    }
    */
}
