import java.util.*;

public class BST{
    private Node r;

    public BST(Node n){
	r = n;
    }

    public BST(){
	r = null;
    }

    public String traverse(Node n){
	String ans = "";
	if (n == null){
	    ans += " ";
	    return ans;
	}
	else {
	    ans += n.getData() + "\n";
	    Node left = n.getLeft();
	    Node right = n.getRight();
	    ans += traverse(left) + " " + traverse(right);
	    return ans;

	}
    }

    public String toString(){
	return traverse(r);
    }

    /*
    public Node search(int i){
	Node t = r;
	while (t != null){
	    Node t2 = t;
	    if (t.getData() == i)
		return t;
	    else if (t.getData() < i)
		t = t.getRight();
	    else
		t = t.getLeft();
	}
	return t;
    }
    */

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


    /*------------------ Recursive -----------------------------*/
 
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
   

    public static void main(String[] args){
	BST b = new BST(new Node(20));
	Random r = new Random();
	/*for (int i = 0; i < 10; i++){
	    int a = r.nextInt(100);
	    b.insert(a);
	}
	*/
	b.insert(10);
	b.insert(40);
	b.insert(7);
	b.insert(13);
	b.insert(25);
	b.insert(70);
	b.insert(3);
	b.insert(16);
	System.out.println(b);
  
    }

}
