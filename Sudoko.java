

public class Sudoko {



    public static void main(String[] args) {
        SudokoBoard mainBoard = new SudokoBoard();
        // mainBoard.generateValid();
        // mainBoard.halfScramble();
        // while(!mainBoard.isValid()){
        //     mainBoard.halfScramble();
        // }
        do {
            mainBoard.halfScramble();
        } while (!mainBoard.isValid());
        mainBoard.printBoard();
        mainBoard.generateValidFromCurrent();

        mainBoard.printBoard();
        System.out.println(mainBoard.isValid());
    }

}
