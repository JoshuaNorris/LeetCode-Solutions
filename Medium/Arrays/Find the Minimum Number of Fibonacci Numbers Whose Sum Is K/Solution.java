// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

class Solution {
    public int findMinFibonacciNumbers(int k) {
        long[] fibo = createFibo(k);
        long ans=0;
        int index = 44;

        while (k > 0) {
            k -= fibo[getIndexOfHighestFiboNum(k, fibo)];
            ans++;
        }

        return (int) ans;
    }

    private int getIndexOfHighestFiboNum(int k, long[] fibo) {
        int x = 44;
        while (x >=0) {
            if (fibo[x] == 0 || fibo[x] > k) { x--; }
            else { break; }
        }
        System.out.println("FIBO " +fibo[x]);
        return x;
    }

    private long[] createFibo(int k) {
        long[] sums = new long[45]; //45 is the highest index given the current constraints
        sums[0] = 1;
        sums[1] = 1;
        int index = 2;
        while (index<=44) {
            sums[index] = sums[index-1] + sums[index-2];
            index++;
        }
        return sums;
    }
}