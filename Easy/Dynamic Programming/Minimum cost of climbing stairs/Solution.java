// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int result = 0;
        if (cost.length > 2) {
            for (int x = 2; x < cost.length; x++) {
                cost[x] = Math.min(
                    cost[x - 1] + cost[x],
                    cost[x - 2] + cost[x]
                );
                if (x == cost.length - 1) {
                    result = Math.min(cost[x], cost[x-1]);
                }
            }
        } else if (cost.length == 2){
            return Math.min(cost[1], cost[0]);
        } else if (cost.length == 1) {
            return cost[0];
        } else {
            return 0;
        }
        return result;
    }
}