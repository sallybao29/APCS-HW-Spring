public class LList{
    private Node l = null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }
	
    public Node find(int n){
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

    public void insert(int index, String s){
	Node tmp = new Node(s);
        Node before = find(index - 1); 
	Node after = before.getNext();
	tmp.setNext(after);
	before.setNext(tmp);
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
	LList l = new LList();
	l.add("A");
	l.add("B");
	l.add("D");
	l.add("C");
	System.out.println(l);
	System.out.println(l.find(2));
	l.insert(2, "G");
	System.out.println(l);

    }
}
