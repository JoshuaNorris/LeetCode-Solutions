// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;

        for (int x = 1; x< prices.length; x++) {
            if (prices[x] < prices[min]) {
                min = x;
            } else if (prices[x]-prices[min] > profit) {
                profit = prices[x]-prices[min];
            }
        }
        return (profit>0) ? profit : 0;
    }
}