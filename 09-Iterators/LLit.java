import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> t, t2;
    public LLit(Node<E> n){
	t = n;
	t2 = n.getNext();
    }

    public boolean hasNext(){
	return t2 != null;
    }

    public E next(){
	E retval = t2.getData();
	t = t2;
	t2 = t2.getNext();
	return retval;
    }

    public void remove(){
        
    }
}

