import java.util.*;
import java.io.*;

public class LakeMaking{
    private int[][] pasture;
    private int[][] instr;
    private int row, col, elevation, n;


    public LakeMaking(String filename){
	Scanner sc = null;
	try{
	    sc = new Scanner(new File(filename));
	}
	catch(Exception e){
	    System.out.println("Missing file");
	}
	String info = sc.nextLine();
	String[] k = info.split(" ");
	row = Integer.parseInt(k[0]);
	col = Integer.parseInt(k[1]);
	elevation = Integer.parseInt(k[2]);
	n = Integer.parseInt(k[3]);
	pasture = new int[row][col];
	instr = new int[n][3];
	for (int i = 0; i < row + n; i++){       
	    for (int j = 0;j < col;j++){       
		if (i < row && j < col){
		pasture[i][j] = sc.nextInt();
		}
		else if (i > row - 1 && j < 3){
		    instr[i - row][j] = sc.nextInt();
		}
	    }
	}
    }

    public int max(int r, int c){
	int largest = pasture[r - 1][c - 1];
	for (int i = r - 1; i < r + 2; i++){
	    for (int j = c - 1; j < c + 2;j++){
		if (largest < pasture[i][j]){
		    largest = pasture[i][j];
		}
	    }
	}
	return largest;
    }

				 
    public void stomp(int r, int c, int count){
	int largest = max(r, c);
	for (int i = r - 1; i < r + 2; i++){
	    for(int j = c - 1; j < c + 2; j++){
		int num = count - (largest - pasture[i][j]);
		if (num > 0){
		    pasture[i][j] -= num;
		}
	    }
	}
    }

    public int makeLake(){
	for (int i = 0; i < instr.length; i++){
	    stomp(instr[i][0], instr[i][1], instr[i][2]);
	}
	int sum = 0;
	for (int i = 0; i < pasture.length; i++){
	    for (int j = 0; j < pasture[i].length; j++){
		pasture[i][j] = elevation - pasture[i][j];
		if (pasture[i][j] > 0){
		    sum += pasture[i][j];
		}
	    }
	}
	return sum * 72 * 72;
    }

    public static void main(String[] args){
	LakeMaking test = new LakeMaking("makelake.txt");
	System.out.println(Arrays.deepToString(test.pasture));
        System.out.println(test.makeLake());
    }
}
