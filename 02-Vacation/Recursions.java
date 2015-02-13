public class Recursions{
    private int[][] board;
    private char knight = '$';
    private int visited = 1;
 

    public void fill(int n){
	board = new int[n][n];
	for (int i = 0; i < board.length;i++){
	    for (int j = 0; j < board[i].length;j++){
		board[i][j] = 0;
	    }
	}
    }

    public void printBoard(){
	for (int i = 0; i < board.length;i++){
	    for (int j = 0; j < board[i].length;j++){
		System.out.printf();
	    }
	}
    }

    public static void main(String[] args){
	Recursions r = new Recursions();
	r.fill(5);
	System.out.println();
    }
    
    
}
