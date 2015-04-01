public class myQueue<E>{
    private Node<E> head,tail;

    public myQueue(E data){
	head = new Node<E>(data);
	tail = head;
    }
    
    public void enqueue(E data){
        Node<E> tmp = new Node<E>(data);
	tail.setNext(tmp);
	tail = tmp;
    }

    public E dequeue(){
	if (empty()){
	    throw new NullPointerException();
	}
	E tmp = head.getData();
	head = head.getNext();
	return tmp;
    }

    public boolean empty(){
	return head == null;
    }

    public E head() {
	if (empty()){
	    throw new NullPointerException();
	}
	return head.getData();
    }

    public String toString(){
	String s = "" + head;
	for (Node tmp = head.getNext(); tmp!= null; tmp = tmp.getNext()){
	    s = tmp.getData() + " ---> " + s;
	}
	return s;
    }
}
