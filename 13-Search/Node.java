public class Node{
    private int x, y;
    private Node previous;
    private double priority;

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

    public double getPriority(){
	return priority;
    }

    public void setPriority(double d){
	priority = d;
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
