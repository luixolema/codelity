function maxProfit(A: number[]): number {
    let maxProfit = 0;
    let min = 9999999999;
    for (const stockValue of A) {

        let profit = stockValue - min;

        if (profit > maxProfit) {
            maxProfit = stockValue - min;
        }

        if (stockValue < min) {
            min = stockValue;
        }

    }

    return maxProfit;
}

console.log(maxProfit([1,2,3,4,5]));
