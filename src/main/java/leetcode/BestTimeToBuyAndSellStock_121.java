package leetcode;


/**
 *  is not that easy for me to understand, but if we try to buy at the lowest possible price and sell in the future, we end up with e maximum profit (from that point)
 *  but if we keep all the time searching the best timeToBuy and the maxProfit (with the so far best time to buy) we end up with the maximum profit
 *  supposing we wil find a good moment to sell in the future, all we need to find is the lower price to buy and comparing the best profit so far to keep it updated
 */
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int bestTimeToBuy = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - prices[bestTimeToBuy]);
            if (prices[i] < prices[bestTimeToBuy]) {
                bestTimeToBuy = i;
            }
        }

        return maxProfit;
    }
}
