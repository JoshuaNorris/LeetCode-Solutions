// https://leetcode.com/problems/maximal-score-after-applying-k-operations/submissions/1239302458/

import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<IntPair> queue = new PriorityQueue();

        for (int x=0; x<nums.length; x++) {
            queue.offer(new IntPair(nums[x], x));
        }

        long result = 0;
        for (int x=0; x<k; x++) {
            IntPair next = queue.poll();
            result+=next.number;
            int ceiling = (next.number % 3 != 0) ? 1 : 0;
            next.number = next.number / 3 + ceiling;
            queue.offer(next);
        }
        return result;
        
    }


    class IntPair implements Comparable<IntPair> {
        public int number;
        public int index;

        public IntPair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        // Implementing compareTo method for comparing IntPairs
        @Override
        public int compareTo(IntPair other) {
            // Compare based on the first element of the pair
            if (this.number > other.number) { return -1; }
            else if (this.number == other.number) {return 0; }
            else {return 1;}
        }

        @Override
        public String toString() {
            return "number: " + number + " index: " + index;
        }
    }
}