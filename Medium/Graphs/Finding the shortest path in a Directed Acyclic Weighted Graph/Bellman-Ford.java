// https://leetcode.com/problems/network-delay-time/submissions/1230593076/


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] memo_table = createMemoTable(n, k);
        for (int x = 0; x < n - 1; x++) {
            for (int[] edge : times) {
                if (memo_table[edge[0]] != Integer.MAX_VALUE){
                    if (memo_table[edge[0]] + edge[2] < memo_table[edge[1]]) {
                        memo_table[edge[1]] = memo_table[edge[0]] + edge[2];
                    }
                }
            }
        }
        int max = 0;
        for (int x : memo_table) {
            if (x == Integer.MAX_VALUE) {
                max = -1;
                break;
            }
            max = (x > max) ? x : max;
        }
        return max;

    }

    private int[] createMemoTable(int n, int k) {
        int[] memo_table = new int[n + 1];
        for (int x = 0; x < n + 1; x++) {
            memo_table[x] = Integer.MAX_VALUE;
        }
        memo_table[0] = 0;
        memo_table[k] = 0;
        return memo_table;
    }

    private static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}