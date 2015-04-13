import java.io.*;
import java.util.*;

public class Maze{  
    private char[][] board;
    private Frontier f;
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
	f = new Frontier();
	f.add(x,y);
	while (!f.empty()){   
	    delay(100);
	    System.out.println(this);
	    current = f.remove();
	    int cX = current.getX();
	    int cY = current.getY();
	    board[cX][cY] = visited;
	    addNeighbors(cX-1, cY);
	    addNeighbors(cX+1, cY);
	    addNeighbors(cX, cY-1);
	    addNeighbors(cX, cY+1);
	}
	//steps();
    }

    public void addToFront(int tx, int ty){
	Node tmp = null;
	    if (board[tx][ty] == exit || board[tx][ty] == path){
	    tmp = new Node(tx,ty);
	    f.add(tmp);
	}
    }
    /*
    public void bfs(int x, int y, Node){
	f = new Frontier();
	f.add(new Node(x,y));
	while (!f.isEmpty()){
	    
	    delay(100);
	    System.out.println(this);
	    
	    Node current = f.remove();
	    int cx = current.getX();
	    int cy = current.getY();
	    
	    board[cx][cy] = me;
	    if (board[cx][cy] == exit){
		break;
	    }
	    addToFront(cx-1, cy);
	    addToFront(cx+1, cy);
	    addToFront(cx, cy-1);
	    addToFront(cx, cy+1);
	}
    }

    */

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.bfs(10,1);
	System.out.println(m);
    }
}
