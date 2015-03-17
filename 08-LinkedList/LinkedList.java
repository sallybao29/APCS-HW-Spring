public class LinkedList{
    private Node dummy = new Node("");
    private Node l = null;
    private int len = 0;
    dummy.setNext(l);

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
	len++;
    }
	
    public Node get(int n){
	int count = 0;
	Node tmp;
	for (tmp = l; tmp != null; tmp = tmp.getNext()){
	    if (count == n){
		return tmp;
	    }
	    count++;
	}
	return null;
    }

    public void add(int index, String s){
	Node tmp = new Node(s);
        Node before = find(index - 1); 
	Node after = before.getNext();
	tmp.setNext(after);
	before.setNext(tmp);
	len++;
    }
	
    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
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
	System.out.println(l.find(2));
	l.add(2, "G");
	System.out.println(l);

    }
}
