public class LList{
    private Node dummy = new Node(-1);
    private int len = 0;

    public int size(){
	return len;
    }
    
    public void add(int i){
	Node tmp = new Node(i);
	tmp.setNext(dummy.getNext());
	dummy.setNext(tmp);
	len++;
    }
	
    private Node find(int n){
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

      public int get(int n){
	  return find(n).getData();
    }

    public void add(int index, int i){
	if (index >= 0 && index < len){
	    Node tmp = new Node(i);
	    Node before = find(index - 1); 
	    tmp.setNext(before.getNext());
	    before.setNext(tmp);
	    len++;
	}
    }

    public boolean remove(int i){
	Node tmp;
	for (tmp = dummy; tmp != null; tmp = tmp.getNext()){
	    if (tmp.getNext() != null && tmp.getNext().getData() == i){
		tmp.setNext(tmp.getNext().getNext());
		return true;
	    }
	}
	return false;
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
	LList l = new LList();
	l.add(1);
	l.add(2);
	l.add(3);
	l.add(4);
	System.out.println(l);
	System.out.println(l.remove(1));
	System.out.println(l);      

    }
}
