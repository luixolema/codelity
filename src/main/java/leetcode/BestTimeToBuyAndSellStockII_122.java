package leetcode;


/**
 * If you can just buy and sell, all gains will be yours if you:
 *  - buy every day whenever checking the next day, the price goes up (so you accumulate profit)
 *  - sell whatever you have if you earned something. (you dont need to simulate the sell, just accumulate the profit)
 *  - repeat the first 2 steps until the end of the array.
 *
 */
public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length -1; i++) {
            if (prices[i] < prices[i+1]){
                profit+=prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}
