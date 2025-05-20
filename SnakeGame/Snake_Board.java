package Snake_Game;

import java.util.*;

public class Snake_Board {
	static Queue<Node> list = new LinkedList<>();
	static Scanner s = new Scanner(System.in);
	
	public static String start_game(char[][] board, int row, int col) {

		if(row < 0 || col < 0 || row >= board.length || col >= board[0].length ) {
			System.out.println("Game Over!!");
			System.exit(0);
		}
		for (Node node : list) {
			if (node.row == row && node.col == col) {
				System.out.println("Game Over!!");
				System.exit(0);
			}
		}
		
		if (board[row][col] != 'X' && !list.isEmpty()) {
			Node tail = list.poll();
			board[tail.row][tail.col] = '*';			
		}

		list.add(new Node(row, col));
		board[row][col]='.';
	
		display_board(board);
			
	while(true)

	{
		char dir = s.next().charAt(0);
		switch (dir) {
		case 'R':
			start_game(board,  row, col+1);
			break;
		case 'L':
			start_game(board, row, col-1);
			break;
		case 'U':
			start_game(board, row-1, col);
			break;
		case 'D':
			start_game(board, row+1, col);
			break;
		default:
            System.out.println("Invalid move! Use R, L, U, D.");
		}
	 }
	}

	private static void display_board(char[][] board) {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
