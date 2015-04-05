import java.io.*;
import java.util.*;

public class Maze{  
    private char[][] board;
    private myQueue frontier;
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
    
    public Maze()
    {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e){}	 
    }
    
    public String toString()
    {
	String s = "[2J\n";
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return s;
    }
   
    public void solve(int x, int y){
	frontier = new myQueue(x, y);
	while (!frontier.empty(){
	    String c = frontier.dequeue();
	    cX = current.substring(0,1);
	    cY = current.substring(1,2);
	    if (board[cX][cY] == exit){
	    	solved = true;
	    	return;
	    }
	    current = new Node(cX, cY);
	    board[cX][cY] = visited;
	    for (int dX = -1; dX < 2; dX++){
	    	for (int dy = -1; dY < 2; dY++){
	    		try{
	    			if (board[cX+dX][cY+dY] == path &&
	    			    board[cX+dX][cY+dY] != visited &&
	    			    board[cX+dX][cY+dY] != processed){
	    			    	Node n = new Node(cX+dX, cY+dY);
	    			    	frontier.enqueue(n);
	    			    	n.setPrevious(current);
	    			    	board[cX+dX][cY+dY] = processed;
	    		
	    			    }
	    		}
	    		catch (IndexOutofBoundsException e){}
	    	}
	    }
	    
	}
    }
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}
