public class KnightsTour{
    private int maxN;
    private String[][] board;
    private String grid = "#";
    private String pos = "$";
    private int count = 1;
    private boolean solved = false;
 
    public KnightsTour(){
	this(5);
    }

    public KnightsTour(int n){
	maxN = n;
	board = new String[maxN][maxN];
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
		board[i][j] = grid;
	    }
	}
    }

    public String toString(){
	String s = "[2J\n";
	for (int i = 0; i < maxN;i++){
	    for (int j = 0; j < maxN;j++){
	        s += String.format("%3s", board[i][j]);
	    }
	    s += "\n";
	}
	return s;
    }

    public void solve(int x, int y){
	if (x < 0 || x >= maxN ||
	    y < 0 || y >= maxN ||
	    board[x][y].equals(pos) ||
	    board[x][y].compareTo("0") > 0 ||
	    solved){
	    return;
	}
	if (count == maxN * maxN + 1){
	    System.out.println(this);
	    solved = true;
	}
	board[x][y] = pos;
	delay(500);
	System.out.println(this);
	if (!solved){
	    board[x][y] = "" + count;
	    count++;
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
	KnightsTour r = new KnightsTour(5);
	r.makeBoard();
	System.out.println(r);
        r.solve(3,4);
	System.out.println(r);
    }
    
    
}
