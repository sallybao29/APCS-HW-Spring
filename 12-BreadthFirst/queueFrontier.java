public class queueFrontier extends myQueue{

    public queueFrontier(int x, int y){
	super(x, y);
    }

    public void add(Node n){
	super.enqueue(n);
    }

    public Pnode remove(){
	return super.dequeue();
    }
}
