import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {

	LList<String> l = new LList<String>();
	//ArrayList<String> l = new ArrayList<String>();
	//LinkedList<String> l = new LinkedList<String>();

	//LList<Integer> l2 = new LList<Integer>();
	//ArrayList<Integer> l2 = new ArrayList<Integer>();
	//LinkedList<Integer> l2 = new LinkedList<Integer>();


	l.add("Hello");
	l.add("world");
	l.add("abc");
	l.add("something");
	l.add("else");

	System.out.println(l);


	Iterator<String> i = l.iterator();
        if (i.hasNext()){
	    System.out.println(i.next());
	    i.remove();
	}
	System.out.println(l);			
		
				
    }
}
