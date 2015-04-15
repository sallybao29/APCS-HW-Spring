import java.io.*;
import java.util.*;

public class Maze{  
    private char[][] board;
    private Frontier f;
    private Node current;

    private int maxX;
    private int maxY;
    private char processed = 'p';
    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;
    
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
    
    public Maze(){
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("maze.dat"));
	    int j = 0;
	    while (sc.hasNext()){
		String line = sc.nextLine();
		for (int i = 0;i < line.length();i++){
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	}catch (Exception e){}	 
    }
    
    public String toString(){
	String s = "[2J\n";
	for (int y = 0;y < maxY;y++){
	    for (int x = 0;x < maxX;x++){
		s = s + board[x][y];
	    }
	    s=s+"\n";
	}
	return s;
    }

    /*------------------------ DF Recursive Solver -----------------------*/

    public void solve(int x, int y){
	if (board[x][y]==wall ||
	    board[x][y]==me ||
	    board[x][y]==visited ||
	    solved){
	    return;
	}

	if (board[x][y]==exit){
	    System.out.println(this);
	    solved = true;
	}
	delay(100);
	System.out.println(this);
	board[x][y]=me;
	solve(x+1,y);
	solve(x-1,y);
	solve(x,y+1);
	solve(x,y-1);
	if (!solved){
	    board[x][y]=visited;
	}
    }

  /*-----------------------------------------------------------------------*/

    public void addToFront(int tx, int ty){
	Node tmp = null;
	try{
	    if (board[tx][ty] == path || board[tx][ty] == exit){
		tmp = new Node(tx,ty);
		tmp.setPrevious(current);
		f.add(tmp);
	    }
	} catch(Exception e){}
    }


    public void getPath(){
	for (Node tmp = current; tmp != null; tmp = tmp.getPrevious()){
	    board[tmp.getX()][tmp.getY()] = me;
	    delay(100);
	    System.out.println(this);
	}
    }  

  /*------------------------ BF Solver -----------------------*/

    public void bfs(int x, int y){ 
	f = new Frontier();
	f.add(new Node(x,y));
	current = null;
	while (!f.isEmpty()){
	    delay(100);
	    System.out.println(this);

	    current = f.remove();
	    int cX = current.getX();
	    int cY = current.getY();
	    if (board[cX][cY] == exit){
		break;
	    }
	    board[cX][cY] = visited;

	    addToFront(cX-1, cY);
	    addToFront(cX+1, cY);
	    addToFront(cX, cY-1);
	    addToFront(cX, cY+1);
	}   
	//path   
        getPath();
    }

  /*------------------------ DF Solver -----------------------*/

    public void dfs(int x, int y){ 
	f = new StackFront();
	f.add(new Node(x,y));
        current = null;
	while (!f.isEmpty()){
	    delay(100);
	    System.out.println(this);

	    current = f.remove();
	    int cX = current.getX();
	    int cY = current.getY();
	    if (board[cX][cY] == exit){
		break;
	    }
	    board[cX][cY] = visited;

	    addToFront(cX-1, cY);
	    addToFront(cX+1, cY);
	    addToFront(cX, cY-1);
	    addToFront(cX, cY+1);
	}   
	//path   
        getPath();
    }

  /*-------------------------------- -----------------------*/

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.bfs(11,1);
	System.out.println(m);
    }
}
