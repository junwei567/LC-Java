package org.example;

public class maxProfit {
    public int getMaxProfit(int[] prices) {

        int profit = 0;

        if (prices.length < 2) {
            // edge case, terminate immediately
            return profit;
        }

        int l = 0; // left pointer
        int r = 1; // right pointer
        while (r < prices.length) {
            if (prices[r] <= prices[l]) {
                // no profit, move left pointer
                l = r;
            } else if (r < prices.length - 1 && prices[r+1] <= prices[r]) {
                // sell before loss
                profit += (prices[r] - prices[l]);
                l = r;
            } else if (r == prices.length - 1 && prices[r-1] <= prices[r]) {
                // final day
                profit += (prices[r] - prices[l]);
                l = r;
            }
            r += 1;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        maxProfit maxProfit = new maxProfit();
        System.out.println(maxProfit.getMaxProfit(array));
    }
}
