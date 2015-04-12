public class stackFrontier extends myStack{

    public stackFrontier(int x, int y){
	super(x,y);
    }

    public void add(Node n){
	super.push(n);
    }

    public Pnode remove(){
	return super.pop();
    }
}
