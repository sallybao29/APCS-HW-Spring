public class Tree{
    private Node r, T2;

    public Node search(Node T, int i){
	while (T != null){
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
	return T;
    }

    public void insert(Node T, int i){
	Node n = new Node(i);
	if (T == null){
	    T = n;
	    return;
	}
	T = r;
	T = search(T, i);
	if (T2.getRight() == null){
	    T2.setRight(n);
	}
	else{
	    T2.setLeft(n);
	}
    }

}
