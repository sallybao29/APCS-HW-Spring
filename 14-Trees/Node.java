public class Node{
    private Integer data;
    private Node left, right;


    public Node(){
	data = null;
	left = null;
	right = null;
    }

    public String toString(){
	return "" + data;
    }
    
    public Node(Integer i){
	this();
	data = i;
    }

    public Integer getData(){
	return data;
    }

    public void setData(Integer i){
	data = i;
    }

    public Node getLeft(){
	return left;
    }

    public void setLeft(Node n){
	left = n;
    }

    public Node getRight(){
	return right;
    }

    public void setRight(Node n){
	right = n;
    }

    
}
