// https://leetcode.com/problems/k-th-smallest-prime-fraction/description/

import java.util.PriorityQueue;


class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] result = new int[2];
        PriorityQueue<PrimeFraction> queue = new PriorityQueue();

        for (int x=0; x< arr.length; x++) {
            for (int y=x+1; y<arr.length; y++) {
                queue.offer(
                    new PrimeFraction(
                        (double)arr[x] / (double)arr[y],
                        new int[]{arr[x], arr[y]}
                    )
                );
            }
        }

        for (int x=0; x<k; x++) {
            result = queue.poll().nums;
        }





        return result;
    }

    static class PrimeFraction implements Comparable<PrimeFraction> {
        public double priority;
        public int[] nums;

        PrimeFraction(double priority, int[] nums) {
            this.priority = priority;
            this.nums = nums;
        }

        @Override
        public int compareTo(PrimeFraction other) {
            return Double.compare(this.priority, other.priority);
        }
    }
}
