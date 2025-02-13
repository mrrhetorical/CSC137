package pkgAssignment3_Driver;

import static pkgTTTBackend.CBIOManager.*;

public class Driver {
    public static void main(String[] args) {
        pkgTTTBackend.CBTTTBoard my_board = new pkgTTTBackend.CBTTTBoard();

        initPrompt();
        printBoard(my_board);
        my_board.testPlay();
        System.out.println("\nStart interactive play");
        my_board.clearBoard();
        my_board.play();
    }
}  // public class Driver


