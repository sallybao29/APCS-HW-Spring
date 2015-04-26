public class BST{
    private Node r, t2;

    public BST(Node n){
	r = n;
    }

    public void print(Node n){
	if (n == null){
	    System.out.print(" ");
	    return;
	}
	else {
	    System.out.println(n);
	}
	print(n.getLeft());
	print(n.getRight());
    }

    public Node search(Node t, int i){
	Node tmp = t;
	while (tmp != null){
	    t2 = tmp;
	    int c = tmp.getData().compareTo(i);
	    if (c == 0){
		return tmp;
	    }
	    else if (c > 0){
		tmp = tmp.getRight();
	    }
	    else{
		tmp = tmp.getLeft();
	    }
	}
	return tmp;
    }


    public void insert(Node t, int i){
	Node n = new Node(i);
	if (t == null){
	    t = n;
	    return;
	}
	Node tmp = search(t, i);
	if (t2.getRight() == null || t2.getLeft() == null){
	    if (t2.getRight() == null){
		t2.setLeft(n);
	    }
	    else{
		t2.setRight(n);
	    }
	}
        else {
	    if  (i > t.getData()){
		t2.setRight(n);
	    }
	    else {
		t2.setLeft(n);
	    }
	}
    }


    /*------------------ Recursive -----------------------------*/
    /*
    public Node search(Node t, int i){
	Node tmp = t;
	t2 = tmp;
	int c = tmp.getData().compareTo(i);
	if (c == null || c == 0){
	    return tmp;
	}
	else if (c > 0){
	    return search(tmp.getRight(), i);
	}
	else{
	    return search(tmp.getLeft(), i);
	}
    }
    */

    public static void main(String[] args){
	Node r = new Node(20);
	BST b = new BST(r);
	b.insert(r,10);
	b.insert(r,40);
	b.insert(r,7);
	b.insert(r,16);
	b.insert(r, 25);
	b.insert(r,70);
	b.print(r);
  
    }

}
