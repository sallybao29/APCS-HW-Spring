import java.util.*;

public class BTree{
    private Node r;

    public BTree(Node n){
	r = n;
    }

    public BTree(){
	r = null;
    }

    public String traverse(Node n){
	if (n == null){
	    return "";
	}
	else {
	    Node left = n.getLeft();
	    Node right = n.getRight();
	    return traverse(left) + n.getData() + " " + traverse(right);
	}
    }

    public String toString(){
	return traverse(r);
    }
  
    public void insert(int i){
	Node n = new Node(i);
	Node t2 = null;
	Node t = r;
	if (r == null){
	    r = n;
	    return;
	}
	while (t != null){
	    t2 = t;
	    if (t.getData() == i)
		return;
	    else if (t.getData() < i)
		t = t.getRight();
	    else
		t = t.getLeft();
	}
	if (i > t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);	
    }

    /*
    public void insert(int i){
	Random rand = new Random();
	Node n = new Node(i);
	Node t = r;
	Node t2 = null;
	if (r == null){
	    r = n;
	    return;
	}
	while (t != null){
	    t2 = t;
	    if (t.getRight() == null)
		t = t.getRight();
	    else if (t.getLeft() == null)
		t = t.getLeft();
	    else{
		int a = rand.nextInt(2);
		if (a == 0)
		    t = t.getRight();
		else
		    t = t.getLeft();
	    }
	}
	if (t2.getLeft() == null)
	    t2.setLeft(n);
	else
	    t2.setRight(n);
    }
    */

    public void remove(Node t, int i){
	Node t2 = null;
	while (t.getData() != i){
	    t2 = t;
	    if (t.getData() < i)
		t = t.getRight();
	    else
		t = t.getLeft();
	}
	if (t.getLeft() == null){
	    if (t2.getLeft() == t)
		t2.setLeft(t.getRight());
	    else 
		t2.setRight(t.getRight());
	}
	else if (t.getRight() == null){
	    if (t2.getLeft() == t)
		t2.setLeft(t.getLeft());		
	    else 
		t2.setRight(t.getLeft());		
	}
	else{
	    Node l = t.getLeft();
	    while (l.getRight() != null){
		l = l.getRight();
	    }
	    int data = l.getData();
	    remove(t, l.getData());
	    t.setData(data);
	}
    }

    public void remove(int i){
	remove(r, i);
    }

    public Node search(Node t, int i){
	if (t == null || t.getData() == i)
	    return t;
	else if (t.getData() < i)
	    return search(t.getRight(), i);
	else
	    return search(t.getLeft(), i);
    }

    public String search(int i){
	String ans = "" + search(r, i);
	if (ans == null)
	    return "Not Found";
	else
	    return ans;
    }

    /*------------------------- BT methods -------------------------------*/

    public int numNodes(Node t){
	if (t == null)
	    return 0;
	else 
	    return 1 + numNodes(t.getRight()) + numNodes(t.getLeft());
    }

    public int maxValue(Node t, int current){
	int max = current;
	if (t == null)
	    return max;
	if (max < t.getData())
	    max = t.getData();
	int left = maxValue(t.getLeft(), max);
	int right = maxValue(t.getRight(), max);
	if (left > right)
	    return left;
	else 
	    return right;
    }

    public int maxValue(Node t){
	return maxValue(t, Integer.MIN_VALUE);
    }
    
    public int height(Node t){
	if (t == null)
	    return 0;
	int a = height(t.getRight());
	int b = height(t.getLeft());
	if (a > b)
	    return 1 + a;
	else 
	    return 1 + b;
    }
    

    public void splitDupes(Node t){
        if (t == null)
	    return;
	if (t.getRight() != null && t.getData() == t.getRight().getData()){
	    Node n = new Node(t.getRight().getData() - 1);
	    n.setRight(t.getRight());
	    t.setRight(n);
	}
	else if (t.getLeft() != null && t.getData() == t.getLeft().getData()){
	    Node n = new Node(t.getLeft().getData() - 1);
	    n.setRight(t.getLeft());
	    t.setLeft(n);
	}    
	splitDupes(t.getRight());
	splitDupes(t.getLeft());
    }



    /*-------------------------------------------------------------------*/
   

    public static void main(String[] args){
	Node n = new Node(20);
	BTree b = new BTree(n);
	Random r = new Random();

	b.insert(10);
	b.insert(40);
	b.insert(7);
	b.insert(13);
	b.insert(25);
	b.insert(70);
	b.insert(3);
	b.insert(8);
	b.insert(16);
	b.insert(2);
	b.insert(1);
	b.insert(62);
	System.out.println(b);
	System.out.println(b.numNodes(n));
	System.out.println(b.maxValue(n));
	System.out.println(b.height(n));

  
    }

}
