public class LLit{
    private Node l;

    public LLit(Node n){
	l = n;
    }

    public boolean hasNext(){
	return l != null;
    }

    public int next(){
	int i = l.getData();
	l = l.getNext();
	return i;
    }
}
