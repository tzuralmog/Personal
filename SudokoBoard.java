import java.util.ArrayList;
import java.lang.Math; 

public class SudokoBoard {
    static int cols = 9, rows = 9, groupSize = 3;
    int[][] board = new int[9][9];

    SudokoBoard(){
        // Empty mode

    }

    public int[][] getBoard(){
        return board;
    }
    public void printBoard(){
        System.out.println("+---+---+---+");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(j%3 == 0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println("|");
            if(i%3 == 2){
                System.out.println("+---+---+---+");
            }
            
        }
    }
    public void scramble(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = (int)(Math.random()*9)+1;
            }
        }
    }
    public void halfScramble(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(Math.random()>.5){
                    board[i][j] = (int)(Math.random()*9)+1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }

    public boolean isValid(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // for each space in the board
                if( board[i][j] != 0){
                    // checks if its a set number
                    for (int k = 0; k < cols; k++) {
                        // checks uniqness on y axis
                        if( board[k][j] == board[i][j]){
                            return false;
                        }
                        // checks uniqness on x axis
                        if( board[i][k] == board[i][j]){
                            return false;
                        }
                        
                    }
                    // checks uniqness in group.
                    for (int k = i/3; k < groupSize; k++) {
                        for (int l = j/3; l < groupSize; l++) {
                            if(board[k][l] == board[i][j] && i != k && j != l){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
