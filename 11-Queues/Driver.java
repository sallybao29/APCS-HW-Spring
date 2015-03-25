public class Driver{
    public static void main(String[] args){
	myQueue<Integer> q = new myQueue<Integer>(0);
	System.out.println(q);
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	System.out.println(q);
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());

	System.out.println(q);


    }
}
