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
		return ttt_board.clone();
	}

	public void testPlay() {
		CBIOManager.printBoard(this);
		while (!isFull()) {
			int status = testPlayPlayerTurn();
			if (status == 0) {
				CBIOManager.printBoard(this);
			} else if (status == 1) {
				break;
			}
		}
		CBIOManager.quitGameMessage();
	}

	public void clearBoard() {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				ttt_board[r][c] = default_char;
			}
		}
	}

	// It's not clear what this is supposed to do from the UML. this is my best guess.
	private boolean updateBoard(int row, int col) {
		if (isOccupied(row, col)) {
			return false;
		}

		ttt_board[row][col] = player_char;
		return true;
	}

	public void play() {
		CBIOManager.printBoard(this);
		while (!isFull()) {
			int status = playPlayerTurn();
			if (status == 0) {
				CBIOManager.printBoard(this);
			} else if (status == 1) {
				break;
			}
		}
		CBIOManager.quitGameMessage();
	}


	public CBTTTBoard() {
		clearBoard();
	}

	public void printBoard() {

	}

	public boolean isFull() {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (ttt_board[r][c] == default_char) {
					return false;
				}
			}
		}
		return true;
	}

	private int testPlayPlayerTurn() {
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (isOccupied(r, c))
					continue;

				if (updateBoard(r, c))
					return 0;
			}
		}
		return 1;
	}

	/**
	 * @return 0 if the game is not over, or 1 if the player quits
	 * */
	private int playPlayerTurn() {

		int row = -1, col = -1;
		boolean validEntry = false;

		while (!validEntry) {
			CBIOManager.rowColPrompt();
			if (CBIOManager.readQuitInput()) {
				return 1;
			}

			int[] inputs = CBIOManager.readIntegerInput(2);
			if (inputs == null || inputs.length != 2 || inputs[0] < 0 || inputs[0] > 2 || inputs[1] < 0 || inputs[1] > 2) {
				CBIOManager.invalidEntryMessage();
				continue;
			}
			row = inputs[0];
			col = inputs[1];
			if (isOccupied(row, col)) {
				CBIOManager.cellNotFreeMessage(row, col);
				continue;
			}


			validEntry = true;
		}

		updateBoard(row, col);

		return 0;
	}

	private void playComputerTurn() {}

	private boolean isOccupied(int row, int col) {
		return getBoard()[row][col] != default_char;
	}
}
