public class myStack{
    Node<E> l;
    // You decide how the node(s) are declared
    // make whatever constructor(s) you need
    public myStack(){
	l = Node<E>();
    }
    public void push(E data){
	Node<E> temp = new Node<E>(data);
	temp.setNext(l.getNext());
	l.setNext(temp);
    }
    public E pop(){
	// remove and return the top item from the stack
    }
    public boolean empty(){
    }
    public E top() {
	// return the top item from the stack
    }
}
