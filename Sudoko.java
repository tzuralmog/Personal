

public class Sudoko {



    public static void main(String[] args) {
        SudokoBoard mainBoard = new SudokoBoard();
        int[][] board = mainBoard.getBoard();
        // mainBoard.printBoard();
        // System.out.println();
        // mainBoard.scramble();
        // mainBoard.printBoard();
        // System.out.println(mainBoard.isValid());
        // System.out.println();
        // mainBoard.halfScramble();
        // mainBoard.printBoard();
        // System.out.println(mainBoard.isValid());
        do {
            mainBoard.halfScramble();
        } while (!mainBoard.isValid());
        mainBoard.printBoard();
    }

}
