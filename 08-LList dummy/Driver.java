import java.util.*;
import java.io.*;

public class Driver{

    public static void main(String[] args){
	ArrayList<Integer> a = new ArrayList<Integer>();
	LList l = new LList();
	LinkedList<Integer> b = new LinkedList<Integer>();
	Random r = new Random();

	for (int i = 0; i < 2000000; i++){
	    a.add(r.nextInt());
	}

	for (int i = 0; i < 2000000; i++){
	    l.add(r.nextInt());
	}

	for (int i = 0; i < 2000000; i++){
	    b.add(r.nextInt());
	}


	//ArrayList
	long start = System.currentTimeMillis();
	int sum = 0;
	for (int i = 0; i < a.size(); i++){
	    sum += a.get(i);
	}
	long elapsed = System.currentTimeMillis() - start;
	System.out.println("ArrayList: " + elapsed);

	//LList
	long before = System.currentTimeMillis();
	int s = 0;
	for (int i = 0; i < a.size(); i++){
	    s += a.get(i);
	}
	long passed = System.currentTimeMillis() - before;
	System.out.println("LList: " + passed);

	//LinkedList
	long y = System.currentTimeMillis();
	int m = 0;
	for (int i = 0; i < a.size(); i++){
	    m += a.get(i);
	}
	long z = System.currentTimeMillis() - y;
	System.out.println("LinkedList: " + z);

    }
}
