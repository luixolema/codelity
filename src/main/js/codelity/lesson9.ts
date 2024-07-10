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

console.log(maxProfit([1, 2, 3, 4, 5]));


function MaxSliceSum(A: number[]) {
    let maxSliceSum = A[0];
    let sliceSum = maxSliceSum;

    for (let i = 1; i < A.length; i++) {
        const number = A[i];
        maxSliceSum = Math.max(sliceSum + number, number, maxSliceSum);
        if (sliceSum + number > 0) {
            if (number > sliceSum + number) {
                sliceSum = number
            } else {
                sliceSum += number;
            }
        } else {
            sliceSum = number;
        }
    }

    return maxSliceSum;


}

console.log(MaxSliceSum([3, -2, 3]));