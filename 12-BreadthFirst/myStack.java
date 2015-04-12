import java.io.*;
import java.util.*;
public class myStack{
    Node l;
 
    public myStack(int x, int y){
	l = new Node(x,y);
    }

    public void push(Node n){
	n.setNext(l);
	l = n;
    }

    public Pnode pop(){
	if (empty()){
	    throw new NoSuchElementException();
	}
	Pnode temp = new Pnode(l.getX(),l.getY());
	temp.setPrevious(l.getPrevious());
	l = l.getNext();
        return temp;
    }

    public boolean empty(){
	return l == null;
    }

    public String toString(){
	String result = "";
	Node temp = l;
	while(temp != null){
	    result = result + temp + "<---";
	    temp = temp.getNext();
	}
	result += "null";
	return result;
    }

    public static void main(String[]args){
	myStack s = new myStack(2,3);
	s.push(new Node(1,2));
	s.push(new Node(3,4));
	s.push(new Node(8,3));
	System.out.println(s);
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.empty());
    }
    

}
