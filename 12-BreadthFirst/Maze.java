import java.io.*;
import java.util.*;

public class Maze{  
    private char[][] board;
    private myQueue frontier, steps;
    private Pnode current;
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
		for (int i=0;i < line.length();i++){
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
   
    public void solve(int x, int y){
	frontier = new myQueue(x, y);
	while (!frontier.empty() && solved == false){
	    current = frontier.dequeue();
	    int cX = current.getX();
	    int cY = current.getY();
	    board[cX][cY] = visited;
	    outerloop:
	    for (int dX = -1; dX < 2; dX++){
	    	for (int dY = -1; dY < 2; dY++){
		    try{
			if (board[cX+dX][cY+dY] == exit){
			    solved = true;
			    break outerloop;
			}
			if (board[cX+dX][cY+dY] == path){
			    frontier.enqueue(cX+dX, cY+dY);
			    board[cX+dX][cY+dY] = processed;

	    		
			}
		    }catch (Exception e){}
	    	}
	    }	    
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(0,1);
	System.out.println(m);
    }
}
