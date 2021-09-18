import java.util.ArrayList;
import java.lang.Math;

public class SudokoBoard {
    static int cols = 9, rows = 9, groupSize = 3;
    int[][] board = new int[9][9];

    SudokoBoard() {
        // Empty mode

    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println("|");
            if (i % 3 == 2) {
                System.out.println("+---+---+---+");
            }

        }
    }

    public void scramble() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
    }

    public void halfScramble() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (Math.random() > .5) {
                    board[i][j] = (int) (Math.random() * 9) + 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public void clean() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = 0;
            }
        }
    }

    public boolean isValid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // for each space in the board
                if (board[i][j] != 0) {
                    // checks if its a set number
                    for (int k = 0; k < cols; k++) {
                        // checks uniqness on y axis
                        if (board[k][j] == board[i][j]) {
                            return false;
                        }
                        // checks uniqness on x axis
                        if (board[i][k] == board[i][j]) {
                            return false;
                        }

                    }
                    // checks uniqness in group.
                    for (int k = i / 3; k < groupSize; k++) {
                        for (int l = j / 3; l < groupSize; l++) {
                            if (board[k][l] == board[i][j] && i != k && j != l) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void generateValid() {
        this.clean();
        // done recursivly to maintain memory of viable numbers
        generateValidRecursive(0, 0);
    }

    private boolean generateValidRecursive(int x, int y) {
        // advance row by row
        if (x == rows) {
            return true;
        }
        int destX, destY;
        if (y == cols - 1) {
            destX = x + 1;
            destY = 0;
        } else {
            destX = x;
            destY = y + 1;
        }
        if (board[x][y] == 0) {
            // make list of possible numbers to input
            ArrayList<Integer> possibleSolutions = new ArrayList<Integer>();
            possibleSolutions.add(1);
            possibleSolutions.add(2);
            possibleSolutions.add(3);
            possibleSolutions.add(4);
            possibleSolutions.add(5);
            possibleSolutions.add(6);
            possibleSolutions.add(7);
            possibleSolutions.add(8);
            possibleSolutions.add(9);
            // check to see if number have already ben used
            for (int k = 0; k < cols; k++) {
                // todo: make it so it remove the number, not the index of the array
                // EX: remove the number 6, not the 6th element
                possibleSolutions.remove(board[k][y]);
                possibleSolutions.remove(board[x][k]);
            }
            // checks uniqness in group.
            for (int k = x / 3; k < groupSize; k++) {
                for (int l = y / 3; l < groupSize; l++) {
                    possibleSolutions.remove(board[k][l]);
                }
            }
            // if no solution is possible return false to start again
            if (possibleSolutions.size() == 0) {
                return false;
            }
            // choose numbers that havent been chosen yet
            while (possibleSolutions.size() != 0) {
                // gets random number from possible solutions
                int tempSol = possibleSolutions.get((int) (Math.random() * possibleSolutions.size()));
                possibleSolutions.remove(tempSol);
                board[x][y] = tempSol;
                if (generateValidRecursive(destX, destY)) {
                    return true;
                }
            }
            return false;
        }
        System.out.println(x + " " + y);
        return generateValidRecursive(destX, destY);

    }
}
