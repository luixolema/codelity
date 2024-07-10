
function maxProfit(prices: number[]): number {
    let maxProfit = 0;
    let bestTimeToBuy = prices[0];
    for (const price of prices) {
        maxProfit = Math.max(maxProfit, price - bestTimeToBuy);
        bestTimeToBuy = Math.min(price,bestTimeToBuy);
    }

    return maxProfit;
}

console.log(maxProfit([2,1,2,0,1]));