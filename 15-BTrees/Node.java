public class Node<E>{
    private E data;
    private Node<E> left, right;


    public Node<E>(){
	data = null;
	left = null;
	right = null;
    }

    public String toString(){
	return "" + data;
    }
    
    public Node<E>(E i){
	this();
	data = i;
    }

    public E getData(){
	return data;
    }

    public void setData(E i){
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
