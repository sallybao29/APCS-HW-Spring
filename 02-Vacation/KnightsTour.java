public class KnightsTour{
    private int maxN;
    private int[][] board;
    private int visited = 1;
    private boolean solved = false;
 
    public KnightsTour(){
	this(5);
    }

    public KnightsTour(int n){
	maxN = n;
	board = new int[maxN][maxN];
    }

    public void delay(int n){
	try{
	    Thread.sleep(n);
	}
	catch (Exception e){}
    }

    public void makeBoard(){
	for (int i = 0; i < maxN;i++){
	    for (int j = 0; j < maxN;j++){
		board[i][j] = 0;
	    }
	}
    }

    public String toString(){
	String s = "[2J\n";
	for (int i = 0; i < maxN;i++){
	    for (int j = 0; j < maxN;j++){
	        s += String.format("%3d", board[i][j]);
	    }
	    s += "\n";
	}
	return s;
    }

    public void solve(int x, int y){
	if (x < 0 || x >= maxN ||
	    y < 0 || y >= maxN ||
	    board[x][y] > 0 ||
	    solved){
	    return;
	}
	if (visited == maxN * maxN + 1){
	    System.out.println(this);
	    solved = true;
	}
	delay(500);
	System.out.println(this);
	if (!solved){
	    board[x][y] = visited;
	    visited ++;
	}
	solve(x + 2, y + 1);
	solve(x + 2, y - 1);
	solve(x - 2, y + 1);
	solve(x - 2, y - 1);
	solve(x + 1, y + 2);
	solve(x + 1, y - 2);
	solve(x - 1, y + 2);
	solve(x - 1, y - 2);
    }

    public static void main(String[] args){
	KnightsTour r = new KnightsTour(7);
	System.out.println(r);
        r.solve(3,4);
	System.out.println(r);
    }
    
    
}
