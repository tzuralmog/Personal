

public class Sudoko {



    public static void main(String[] args) {
        SudokoBoard mainBoard = new SudokoBoard();
        int[][] board = mainBoard.getBoard();
        mainBoard.printBoard();
    }

}
