import java.io.*;
import java.util.*;

public class Maze{  
    private char[][] board;
    private Frontier f;
    private Node current, ex = null;

    private int maxX;
    private int maxY;
    private char path=' ';
    private char wall='#';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    
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

    public void findExit(){
	for (int j = 0; j < maxY; j++)
	    for (int i = 0; i < maxX; i++)
		if (board[i][j] == exit){
		    ex = new Node(i, j);
		}
    }


    public void getPath(){
	for (Node tmp = current; tmp != null; tmp = tmp.getPrevious()){
	    board[tmp.getX()][tmp.getY()] = me;
	    delay(100);
	    System.out.println(this);
	}
    }  

    public double findPriority(Node n){
	//Manhattan Distance
	return Math.abs(n.getX() - ex.getX()) + Math.abs(n.getY() + ex.getY());
	//Euclidean Distance
	//return Math.sqrt(Math.pow(n.getX() - ex.getX(), 2) + Math.pow(n.getY() - ex.getY(), 2));
    }

    public void addToFront(int tx, int ty){
	Node tmp = null;
	try{
	    if (board[tx][ty] == path || board[tx][ty] == exit){
		tmp = new Node(tx,ty);
		tmp.setPrevious(current);

		//Astar
		tmp.setPriority(findPriority(tmp) + current.getSteps());
		tmp.setSteps(current.getSteps()++);
       
		//BestFirst
		//tmp.setPriority(findPriority(tmp));
		f.add(tmp);
	    }
	} catch(Exception e){}
    }
   
 
    public void solve(int x, int y){ 
	findExit();
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
        getPath();
    }


  /*--------------------------------------------------------*/

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(2,2);
	System.out.println(m);
    }
}
