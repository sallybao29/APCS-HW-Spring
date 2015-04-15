import java.util.*;

public class Frontier{
    public LinkedList<Node> l = new LinkedList<Node>();

    public void add(Node n){
	double p = n.getPriority();
	int i = 0;
	Node tmp = null;
	Iterator<Node> it = l.iterator();
	while (it.hasNext()){
	    it = l.iterator();
	    tmp = it.next();
	    if (p < tmp.getPriority()){
		l.add(i, n);
	    }
	    i++;
	}
	l.add(i,n);
    }

    public Node remove(){
	return l.remove(0);
    }

    public boolean isEmpty(){
	return l.isEmpty();
    }

    public static void main(String[]args){
	Frontier f = new Frontier();
	Node a = new Node(1,2);
	a.setPriority(16);
	Node b = new Node(6,1);
	b.setPriority(1);
	Node c = new Node(10,2);
	c.setPriority(4);
	f.add(a);
	f.add(b);
	f.add(c);
	System.out.println(f);
    }
}

