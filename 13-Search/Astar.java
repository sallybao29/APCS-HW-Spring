import java.io.*;
import java.util.*;

public class Astar extends Maze{  
    private char[][] board;
    private Frontier f;
    private Node current, ex = null;
    private int steps = 1;

    private int maxX;
    private int maxY;
    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    


    public void addToFront(int tx, int ty){
	Node tmp = null;
	try{
	    if (board[tx][ty] == path || board[tx][ty] == exit){
		tmp = new Node(tx,ty);
		tmp.setPrevious(current);
		tmp.setSteps(steps);
		tmp.setPriority(findPriority(tmp) + tmp.getSteps());
		f.add(tmp);
	    }
	} catch(Exception e){}
    }

    public void astar(int x, int y){
	super.BestFirst(x,y);
    }



  /*--------------------------------------------------------*/

    public static void main(String[] args){
	Astar a = new Astar();
	System.out.println(a);
	a.astar(5,0);
	System.out.println(a);
    }
}


