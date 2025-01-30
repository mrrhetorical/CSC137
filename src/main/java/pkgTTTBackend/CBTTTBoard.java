package pkgTTTBackend;

import java.util.Scanner;

public class CBTTTBoard {

	private enum State {
		PLAYER, COMPUTER, EMPTY;
		@Override
		public String toString() {
			return switch (this) {
				case PLAYER -> "P";
				case COMPUTER -> "C";
				case EMPTY -> "-";
			};
		}
	}

	private final State[][] board = new State[3][3];

	public CBTTTBoard() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				board[r][c] = State.EMPTY;
			}
		}
	}

	public void printBoard() {
		for (int r = 0; r < 3; r++) {
			System.out.printf("%s   %s   %s\n\n", board[r][0].toString(), board[r][1].toString(), board[r][2].toString());
		}
	}

	public boolean isFull() {
		int n = 0; // non-empty spaces
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (board[r][c] != State.EMPTY) {
					n++;
				}
			}
		}
		return n == 9;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);

		while (!isFull()) {

			int row = -1, col = -1;
			while(row == -1 || col == -1 || board[row][col] != State.EMPTY) {
				System.out.println("Enter the row and col for your entry - space (only) separated:");
				row = scanner.nextInt();
				col = scanner.nextInt();

				if (row < 0 || row > 2 || col < 0 || col > 2) {
					System.out.println("Enter a valid row and col for your entry - space (only) separated:");
					continue;
				}

				if (board[row][col] != State.EMPTY) {
					System.out.println("The cell is already marked. Please try again.");
				}
			}

			board[row][col] = State.PLAYER;
			printBoard();
		}
		scanner.close();
		System.out.println("Game over!");
	}
}
