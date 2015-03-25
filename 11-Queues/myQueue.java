public class myQueue<E>{
    private Node<E> head,tail;

    public myQueue<E>(){
	head = new Node<E>();
	tail = head;
    }
    
    public void enqueue(E data){
        Node<E> tmp = new Node<E>(data);
	tail.setNext(tmp);
	tail = tmp;
    }

    public E dequeue(){
	if (head == null){

	}
	E tmp = head.getData();
	head = head.getNext();
	return tmp;
    }

    public boolean empty(){
	return head == null;
    }

    public E head() {
	return head.getData();
    }
}
