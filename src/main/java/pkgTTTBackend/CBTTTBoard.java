package pkgTTTBackend;

import java.util.Scanner;

public class CBTTTBoard {

	private enum CellState {
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

	private enum GameState {
		PLAYER_TURN, COMPUTER_TURN, GAME_OVER
	}

	private final CellState[][] board = new CellState[3][3];

	private GameState gameState = GameState.PLAYER_TURN;
	private final Scanner scanner;

	public CBTTTBoard() {
		scanner = new Scanner(System.in);
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				board[r][c] = CellState.EMPTY;
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
				if (board[r][c] != CellState.EMPTY) {
					n++;
				}
			}
		}
		return n == 9;
	}

	public void play() {
		while (gameState != GameState.GAME_OVER) {
			switch (gameState) {
				case PLAYER_TURN:
					playPlayerTurn();
					// todo: make computer turn once we create the computer turn probably in another assignment
					// gameState = GameState.COMPUTER_TURN;
					break;
				case COMPUTER_TURN:
					playComputerTurn();
					gameState = GameState.PLAYER_TURN;
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + gameState);
			}
			// Post-turn, so printing the board
			printBoard();
			// End the game if the board is full
			if (isFull()) {
				gameState = GameState.GAME_OVER;
			}
		}
	}

	public void playPlayerTurn() {

		int row = -1, col = -1;
		while (row == -1 || col == -1 || board[row][col] != CellState.EMPTY) {
			System.out.println("Enter the row and col for your entry - space (only) separated:");
			row = scanner.nextInt();
			col = scanner.nextInt();

			if (row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("Enter a valid row and col for your entry - space (only) separated:");
				continue;
			}

			if (board[row][col] != CellState.EMPTY) {
				System.out.println("The cell is already marked. Please try again.");
			}
		}

		board[row][col] = CellState.PLAYER;
	}

	public void playComputerTurn() {

	}
}
