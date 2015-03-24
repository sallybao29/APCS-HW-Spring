public class Driver{
    public static void main(String[] args){

	myStack<Integer> a = new myStack<Integer>();
	a.push(8);
	a.push(3);
	a.push(5);
	System.out.println(a);
	System.out.println(a.pop());
	System.out.println(a);
	System.out.println(a.empty());
	System.out.println(a.top());

	/*
	myStack2<Integer> b = new myStack2<Integer>();
	b.push(8);
	b.push(3);
	b.push(5);
	System.out.println(b);
	System.out.println(b.pop());
	System.out.println(b.pop());
	System.out.println(b.pop());
	System.out.println(b);
	*/
    }

}
