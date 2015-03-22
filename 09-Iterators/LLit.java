import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> t, t2, first;
    boolean removed;

    public LLit(Node<E> n){
	first = n;
	t = n;
	t2 = n.getNext();
	removed = false;
    }

    public boolean hasNext(){
	return t2 != null;
    }

    public E next(){
	removed = false;
	E retval = t2.getData();
	t = t2;
	t2 = t2.getNext();	
	return retval;
    }

    public void remove(){
	if (removed == false){
	    int i = 0;
	    Node<E> tmp = first;
	    while (tmp.getNext() != t){
		tmp = tmp.getNext();
	    }
	    tmp.setNext(tmp.getNext().getNext());
	    removed = true;
	}
	else {
	    throw new IllegalStateException();
	}
    }
}

