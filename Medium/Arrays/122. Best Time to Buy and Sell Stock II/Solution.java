// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int x=1; x<prices.length; x++) {
            count += (prices[x-1] < prices[x]) ? prices[x]-prices[x-1] : 0;
        }
        return count; 
    }
}