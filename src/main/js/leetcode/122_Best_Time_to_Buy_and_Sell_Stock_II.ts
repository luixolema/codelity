/**
 * the key is to realize that in the way the problem is set, you can earn all possible profit, so:
 * every time the price goes up, that is a profit to add to the total profit.
 */
function maxProfit(prices: number[]): number {
    let profit = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i-1]){
            profit+= prices[i] - prices[i-1];
        }
    }

    return profit;
}

console.log(maxProfit([2,1,2,0,1]));