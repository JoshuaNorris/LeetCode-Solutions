https://leetcode.com/problems/sudoku-solver/

import java.util.ArrayList;

class Solution {
    public void solveSudoku(char[][] board) {
        int[][] columns = new int[9][10];
        int[][] rows = new int[9][10];
        int[][] boxes = new int[9][10];
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (board[col][row] != '.') {
                    int num = Character.getNumericValue(board[col][row]);
                    columns[col][num] = 1;
                    rows[row][num] = 1;
                    int box = getBox(col, row);
                    boxes[box][num] = 1;
                }
            }
        }
        solveSudokuHelper(board, columns, rows, boxes, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int[][] columns, int[][] rows, int[][] boxes, int column, int row) {
        if (column == 9) {
            return true; // Reached the end of the board
        }
        int nextRow = (row + 1) % 9;
        int nextColumn = column + (nextRow == 0 ? 1 : 0);

        if (board[column][row] != '.') {
            return solveSudokuHelper(board, columns, rows, boxes, nextColumn, nextRow);
        } else {
            for (int num = 1; num <= 9; num++) {
                int box = getBox(column, row);
                if (columns[column][num] == 0 && rows[row][num] == 0 && boxes[box][num] == 0) {
                    board[column][row] = (char) ('0' + num);
                    columns[column][num] = 1;
                    rows[row][num] = 1;
                    boxes[box][num] = 1;
                    if (solveSudokuHelper(board, columns, rows, boxes, nextColumn, nextRow)) {
                        return true;
                    }
                    // Backtrack
                    board[column][row] = '.';
                    columns[column][num] = 0;
                    rows[row][num] = 0;
                    boxes[box][num] = 0;
                }
            }
            return false; // No valid number found for this cell
        }
    }

    private static int getBox(int column, int row) {
        return (column / 3) * 3 + row / 3;
    }

    private static void printArray(char[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
