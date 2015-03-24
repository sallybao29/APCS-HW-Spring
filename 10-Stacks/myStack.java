import java.io.*;
import java.util.*;
public class myStack<E>{
    Node<E> l;
 
    public myStack(){
	l = new Node<E>();
    }

    public void push(E data){
        Node<E> temp = new Node<E>(data);
	temp.setNext(l.getNext());
	l.setNext(temp);
    }

    public E pop(){
	E temp = l.getNext().getData();
	l.setNext(l.getNext().getNext());
        return temp;
    }

    public boolean empty(){
	return l.getNext() == null;
    }

    public E top() {
        return l.getNext().getData();
    }
    public String toString(){
	String result = "";
	Node<E>temp = l.getNext();
	while(temp != null){
	    result = result + temp.getData() + "<---";
	    temp = temp.getNext();
	}
	return result;
    }
    

}
