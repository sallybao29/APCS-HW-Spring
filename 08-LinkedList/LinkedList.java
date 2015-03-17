public class LinkedList{
    private Node dummy = new Node("");
    private int len = 0;

 
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(dummy.getNext());
	dummy.setNext(tmp);
	len++;
    }
	
    public Node get(int n){
	int count = -1;
	Node tmp;
	if (n > len - 1 || n < -1){
	    return null;
	}
	else {
	    tmp = dummy;
	    while (count < n){
		tmp = tmp.getNext();
		count++;
	    }
	    return tmp;
	}
    }

    public void add(int index, String s){
	if (index >= 0 && index < len){
	    Node tmp = new Node(s);
	    Node before = get(index - 1); 
	    tmp.setNext(before.getNext());
	    before.setNext(tmp);
	    len++;
	}
    }
	
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp = dummy.getNext() ; tmp != null ; tmp = tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    public static void main(String[] args){
	LinkedList l = new LinkedList();
	l.add("A");
	l.add("B");
	l.add("D");
	l.add("C");
	System.out.println(l);
	System.out.println(l.get(2));
	l.add(2, "G");
	l.add(0, "Z");
	System.out.println(l);

    }
}
