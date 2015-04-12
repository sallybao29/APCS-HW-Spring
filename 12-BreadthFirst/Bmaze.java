public class Bmaze extends Maze{
    private stackFrontier frontier;
    private char[][] board;
    private Pnode current;
    private Node n;

    private int maxX;
    private int maxY;
    private char processed = 'p';
    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;
        
    public Bmaze(){
	super(); 
    }
   
    public void steps(){
	String ans = "";
	for (Node tmp = current; tmp != null; tmp = tmp.getPrevious()){
	    ans = tmp + " ---> " + ans;
	    board[tmp.getX()][tmp.getY()] = me;
	}
	ans += "Exit";
	System.out.println(ans);
    }

    public void addNeighbors(int x, int y){
	try{
	    n = new Node(x, y);
	    n.setPrevious(current);
	    if (board[x][y] == exit){
		solved = true;
	    }
	    if (board[x][y] == path){
		frontier.add(n);
		board[x][y] = processed;	    		
	    }			
	}catch (Exception e){}
    }
   
    public void solve(int x, int y){ 
	frontier = new stackFrontier(x, y);
	while (!frontier.empty() && solved == false){
	    current = frontier.remove();
	    int cX = current.getX();
	    int cY = current.getY();
	    board[cX][cY] = visited;
	    addNeighbors(cX-1, cY);
	    addNeighbors(cX+1, cY);
	    addNeighbors(cX, cY-1);
	    addNeighbors(cX, cY+1);
	}
	steps();
    }
   

    public static void main(String[] args){
	Bmaze m = new Bmaze();
	System.out.println(m);
	m.solve(10,1);
	System.out.println(m);
    }
}
