// https://leetcode.com/problems/knight-probability-in-chessboard/description/

import java.util.Arrays;

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double [][][] prob_table = createProbTable(n, k);

        return recursiveKnightProbability(n, k, row, column, prob_table);
    }

    public double recursiveKnightProbability(int n, int k, int row, int column, double[][][] prob_table) {
        if (!isOnBoard(n, column, row)) { return 0; }
        else if (k == 0) { return 1; }
        else if (prob_table[k][column][row] != -1) { return prob_table[k][column][row];}
        else {
            double result = calculateAverage(
                recursiveKnightProbability(n, k - 1, column-1, row-2, prob_table),
                recursiveKnightProbability(n,k - 1, column-1, row+2, prob_table),
                recursiveKnightProbability(n,k - 1,column-2, row-1, prob_table),
                recursiveKnightProbability(n,k - 1,column-2, row+1, prob_table),
                recursiveKnightProbability(n,k - 1,column+1, row-2, prob_table),
                recursiveKnightProbability(n,k - 1,column+1, row+2, prob_table),
                recursiveKnightProbability(n,k - 1,column+2, row-1, prob_table),
                recursiveKnightProbability(n,k - 1,column+2, row+1, prob_table)
            );
            prob_table[k][column][row] = result;
            return result;
        }
    }

    private double[][][] createProbTable(int n, int k) {
        // Making it k+1 so I don't have to worry about changing the k value
        // which will never be 0... so prob_table[0] will never be touched.
        double [][][] prob_table = new double[k+1][n][n];
        for (int x = 0; x <= k; x++) {
            for (int x2 = 0; x2 < n; x2++) {
                double [] array = new double[n];
                Arrays.fill(array, -1.0); 
                prob_table[x][x2] = array;
            }
        }
        return prob_table;
    }

    private boolean isOnBoard(int n, int column, int row) {
        if (column < 0 || column >= n || row < 0 || row >= n) {
            return false;
        } else  {
            return true;
        } 
    }

    private static void printArray(double[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }

    public static double calculateAverage(double... values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}



