package pkgTTTBackend;

import java.util.Scanner;

public class CBTTTBoard {

	private final char machine_char = 'C';
	private final char ROW = 3;
	private int totalValidentries;
	private char winner_char;
	private final char default_char = '-';
	private final char COL = 3;
	private final char[][] ttt_board = new char[ROW][COL];
	private final char player_char = 'P';


	public char[][] getBoard() {
		return ttt_board;
	}

	public void testPlay() {
		throw new RuntimeException();
	}

	public void clearBoard() {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				ttt_board[r][c] = default_char;
			}
		}
	}

	private boolean updateBoard(int row, int col) {
		throw new RuntimeException();
	}

	public void play() {
		while (!isFull()) {
			playPlayerTurn();
			printBoard();
		}
	}


	private final Scanner scanner;

	public CBTTTBoard() {
		scanner = new Scanner(System.in);
		clearBoard();
	}

	public void printBoard() {
		for (int r = 0; r < 3; r++) {
			System.out.printf("%s   %s   %s\n\n", ttt_board[r][0], ttt_board[r][1], ttt_board[r][2]);
		}
	}

	public boolean isFull() {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (ttt_board[r][c] != default_char) {
					return false;
				}
			}
		}
		return true;
	}

	public void playPlayerTurn() {

		int row = -1, col = -1;
		while (row == -1 || col == -1 || ttt_board[row][col] != default_char) {
			System.out.println("Enter the row and col for your entry - space (only) separated:");
			row = scanner.nextInt();
			col = scanner.nextInt();

			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("Enter a valid row and col for your entry - space (only) separated:");
				continue;
			}

			if (ttt_board[row][col] != default_char) {
				System.out.println("The cell is already marked. Please try again.");
			}
		}

		ttt_board[row][col] = player_char;
	}

	public void playComputerTurn() {

	}
}
