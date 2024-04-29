// https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return getStartingPoint(gas, cost);
    }

    private int getStartingPoint(int[] gas, int[] cost) {
        int current_sum = 0;
        int index = -1;
        int total_sum = 0;
        for (int x=0; x<gas.length; x++) {
            if ( current_sum == 0 ) { index = x; }
            
            total_sum += gas[x]-cost[x];
            current_sum += gas[x]-cost[x];
            
            if (current_sum < 0) {
                current_sum = 0;
                index = -1;
            }
        }
        if (total_sum >= 0) { return index; }
        else { return -1; }
    }
}