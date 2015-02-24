import java.util.*;
import java.io.*;

public class LakeMaking{
    private int[][] pasture;
    private int row, col, elevation, n;

    public LakeMaking(String filename){
	Scanner sc = new Scanner(new File(filename));
	String info = sc.nextLine();
	String[] k = info.split(" ");
	row = Integer.parseInt(k[0]);
	col = Integer.parseInt(k[1]);
	elevation = Integer.parseInt(k[2]);
	n = Integer.parseInt(k[3]);
	for (int i = 0; i < row + 1; i++){

	}
    }


}
