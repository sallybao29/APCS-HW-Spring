public class Node{
    private int x, y;
    private Node next, previous;

    public Node(int x, int y){
	this.x = x;
	this.y = y;
	next = null;
	previous = null;
    }

    public String getData(){
return "" + x + y;
}

    public void setNext(Node n){
	next = n;
    }

    public void setPrevious(Node n){
	previous = n;
    }

    public Node getNext(){
	return next;
    }

    public Node getPrevious(){
	return previous;
    }

    public String toString(){
	return "[" + x + "," + y + "]";
    }

    public static void main(String[]args){
	Node n = new Node(2,5);
	System.out.println(n);
    }
}
