public class Node{
    private int x, y;
    private Node previous;

    public Node(int x, int y){
	this.x = x;
	this.y = y;
	previous = null;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setPrevious(Node n){
	previous = n;
    }

    public Node getPrevious(){
	return previous;
    }

    public String toString(){
	return "[" + x + "," + y + "]";
    }

}
