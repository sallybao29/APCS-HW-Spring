public class Node<E>{
    private int X, Y, pX, pY;
    private Node<E> next;

    public Node(int X, int Y, int pX , int pY){
	this.X = X;
	this.Y = Y;
	this.pX = pX;
	this.pY = pY;
	next = null;
    }

    public int getX(){
	return X;
    }

      public int getY(){
	return Y;
    }

      public int getPX(){
	return pX;
    }

      public int getPY(){
	return pY;
    }


    public void setNext(Node<E> n){
	next = n;
    }

    public Node<E> getNext(){
	return next;
    }

    public String toString(){
	return ""+data;
    }
}
