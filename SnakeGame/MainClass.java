package Snake_Game;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		char[][] board = new char[n][n];
		for(char[] x : board) {
			Arrays.fill(x, '*');
		}
		board[0][0] = '.';
		board[0][1] = 'X';
		board[2][2] = 'X';
		board[3][4] = 'X';
		
		String res = Snake_Board.start_game(board, 0 , 0);
		System.out.println(res);
		

	}

}
