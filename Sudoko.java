

public class Sudoko {



    public static void main(String[] args) {
        SudokoBoard mainBoard = new SudokoBoard();
        mainBoard.generateValid();
        // System.out.println(mainBoard.isValid());
        // do {
        //     mainBoard.halfScramble();
        // } while (!mainBoard.isValid());
        mainBoard.printBoard();
    }

}
