import java.util.ArrayList;

public class SudokoBoard {
    static int cols = 9, rows = 9, groups = 3;
    int[][] board = new int[9][9];

    SudokoBoard(){
        // Empty mode

    }

    public int[][] getBoard(){
        return board;
    }
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
            // for (int j = 0; j < board[i].length; j++) {
            //     System.out.print("+-");
            // }
            // System.out.println("+");
        }
    }
}
