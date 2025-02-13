package pkgTTTBackend;

import java.util.Scanner;

public class CBIOManager {
	private CBIOManager () {}
	private static Scanner myScanner = new Scanner(System.in);
	public static void cellNotFreeMessage(int row, int col) {
		throw new RuntimeException();
	}
	public static void rowColPrompt() {
		throw new RuntimeException();
	}
	public static void readQuitInput() {
		throw new RuntimeException();
	}
	public static void boardCompleteMessage() {
		throw new RuntimeException();
	}
	public static int[] readIntegerInput(int count) {
		int[] inputs = new int[count];
		for (int i = 0; i < count; i++) {
			if (myScanner.hasNextInt()) {
				inputs[i] = myScanner.nextInt();
			} else {
				System.out.printf("Please enter %d integers!\n", count);
				myScanner.next();
			}
		}
		return inputs.clone();
	}

	public static void invalidEntryMessage() {
		System.out.println("The cell is already marked. Please try again.");
	}

	public static void printBoard(CBTTTBoard board) {
		throw new RuntimeException();
	}

	public static void initPrompt() {
		throw new RuntimeException();
	}

	public static void quitGameMessage() {
		throw new RuntimeException();
	}
}
