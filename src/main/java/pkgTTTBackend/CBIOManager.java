package pkgTTTBackend;

import java.util.Scanner;

public class CBIOManager {
	private CBIOManager () {}
	private static Scanner myScanner = new Scanner(System.in);

	public static void cellNotFreeMessage(int row, int col) {
		System.out.printf("Cell [%d, %d] is not available!\n", row, col);
	}

	public static void rowColPrompt() {
		System.out.println("Enter row col numbers (space separated):");
	}

	public static boolean readQuitInput() {
		return !myScanner.hasNextInt() && myScanner.hasNext() && myScanner.next().equalsIgnoreCase("q");
	}

	public static void boardCompleteMessage() {
		System.out.println("All entries in the board are filled!");
	}

	public static int[] readIntegerInput(int count) {
		int[] inputs = new int[count];
		for (int i = 0; i < count; i++) {
			if (myScanner.hasNextInt()) {
				inputs[i] = myScanner.nextInt();
			} else {
				myScanner.next();
				return null;
			}
		}

		return inputs;
	}

	public static void invalidEntryMessage() {
		System.out.println("Invalid input! Try again.");
	}

	public static void printBoard(CBTTTBoard board) {
		char[][] ttt_board = board.getBoard();
		for (int r = 0; r < 3; r++) {
			System.out.printf("%s   %s   %s\n", ttt_board[r][0], ttt_board[r][1], ttt_board[r][2]);
		}
		System.out.println();
	}

	public static void initPrompt() {
		System.out.println("Welcome to your unproductive time of the day!");
	}

	public static void quitGameMessage() {
		System.out.println("Good bye - game over, come again ASAP and waste more time!");
	}
}
