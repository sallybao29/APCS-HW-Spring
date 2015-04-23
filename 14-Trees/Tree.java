public class Tree{
    private Node T = null, T2 = null;

    public Node search(Node T, Integer i){
	while (T! = null){
	    T2 = T;
	    int c = T.getData().compareTo(i);
	    if (c == 0){
		return T;
	    }
	    else if (c > 0){
		T = T.getRight();
	    }
	    else {
		T = T.getLeft();
	    }
	}
    }
}
