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

    public void setBoard(int[][] newBoard) {
        board = newBoard.clone();
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

    // helper function for testing
    private void printInnerBoard(int[][] state) {
        System.out.println("+---+---+---+");
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(state[i][j]);
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

    // checks if valid, not if solvable
    public boolean isValid() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // for each space in the board
                if (board[i][j] != 0) {
                    // checks if its a set number
                    for (int k = 0; k < cols; k++) {
                        // checks uniqness on y axis
                        if (board[k][j] == board[i][j] && i != k) {
                            // System.out.println("i=" + i + " j=" + j + " k=" + k + " yaxis ");
                            return false;
                        }
                        // checks uniqness on x axis
                        if (board[i][k] == board[i][j] && j != k) {
                            // System.out.println("i=" + i + " j=" + j + " k=" + k + " xaxis ");
                            return false;
                        }

                    }
                    // checks uniqness in group.
                    int xDiff = (i / groupSize) * groupSize, yDiff = (j / groupSize) * groupSize;
                    for (int k = 0; k < groupSize; k++) {
                        for (int l = 0; l < groupSize; l++) {
                            if (board[k+xDiff][l+yDiff] == board[i][j] && i != k+xDiff && j != l+yDiff) {
                                // System.out.println("i=" + i + " j=" + j + " k=" + k + " l=" + l);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    // Todo:
    public boolean isSolvable() {
        return false;
    }

    public void generateValid() {
        this.clean();
        generateValidRecursive(board, 0, 0);
    }

    public void generateValidFromCurrent() {
        generateValidRecursive(board, 0, 0);
    }

    private int[][] deepCopy(int[][] copy) {
        int[][] newCopy = new int[copy.length][];
        for (int i = 0; i < copy.length; i++) {
            newCopy[i] = new int[copy[i].length];
            for (int j = 0; j < copy[i].length; j++) {
                newCopy[i][j] = copy[i][j];
            }
        }
        return newCopy;
    }

    private boolean generateValidRecursive(int[][] state, int x, int y) {
        // System.out.println(x + " " + y);
        // advance row by row
        if (x == rows) {
            board = state.clone();
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

        if (state[x][y] == 0) {
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
            // check to see if number has already been used
            for (int k = 0; k < cols; k++) {
                // int value of makes it remove the number, not the index of the array
                possibleSolutions.remove(Integer.valueOf(state[k][y]));
                possibleSolutions.remove(Integer.valueOf(state[x][k]));
            }
            // checks uniqness in group.
            // xdiif and ydiff find top left of group
            int xDiff = (x / groupSize) * groupSize, yDiff = (y / groupSize) * groupSize;
            for (int k = 0; k < groupSize; k++) {
                for (int l = 0; l < groupSize; l++) {
                    // k and l no work good fix please
                    possibleSolutions.remove(Integer.valueOf(state[k + xDiff][l + yDiff]));
                }
            }
            // if no solution is possible return false to start again
            if (possibleSolutions.size() == 0) {
                return false;
            }
            // choose numbers that havent been chosen yet
            while (possibleSolutions.size() != 0) {
                // gets random number from possible solutions
                // System.out.println(x + " " + y+ " " +possibleSolutions.size());
                int tempSol = possibleSolutions.get((int) (Math.random() * possibleSolutions.size()));
                possibleSolutions.remove(Integer.valueOf(tempSol));
                state[x][y] = tempSol;

                // printInnerBoard(state);
                // System.out.println();
                // System.out.println(x + " " + y+ " " + state[x][y]);
                if (generateValidRecursive(deepCopy(state), destX, destY)) {
                    return true;
                }
            }
            return false;
        }
        // System.out.println(x + " " + y+ " " + state[x][y]);
        // System.out.println("err");
        return generateValidRecursive(state, destX, destY);

    }
}
