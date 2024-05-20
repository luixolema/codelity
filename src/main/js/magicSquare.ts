console.log(isMagicSquare2([
    [16, 3, 2, 13],
    [5, 10, 11, 8],
    [9, 6, 7, 12],
    [4, 15, 14, 1]
]))


function isMagicSquare2(arr: number[][]) {
    const length = arr.length;
    let correctNumber: number | undefined = undefined;
    const colSums = [];
    let topToBottomDiagonal = 0;
    let bottomToTopDiagonal = 0;


    for (let row = 0; row < length; row++) {
        let rowSum = 0;
        for (let col = 0; col < length; col++) {
            const number = arr[row][col];
            rowSum += number;
            if (colSums[col] === undefined) {
                colSums[col] = 0;
            }
            colSums[col] += number;
            if (row === length -1 && colSums[col] !== correctNumber) {
                return false;
            }
            if (row === col) {
                topToBottomDiagonal += number;
            }
            if (col === col) {
                topToBottomDiagonal += number;
            }
            if (length - col === col) {
                bottomToTopDiagonal += number;
            }
        }
        if (correctNumber === undefined) {
            correctNumber = rowSum;
        }

        if (rowSum !== correctNumber) {
            return false;
        }
    }

    return topToBottomDiagonal !== bottomToTopDiagonal !== !correctNumber;
}
