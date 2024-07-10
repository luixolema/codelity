function frog(X: number, Y: number, D: number) {
    if (Y - X < D) {
        return 1;
    }
    if (X === Y){
        return 0;
    }

    const result = Math.floor((Y - X) / D);
    return (Y - X) % D > 0 ? result + 1 : result;

}

function PermMissingElem(A: number[]) {
    let missing = 1;
    A.sort().find((e, index) => {
        if (index + 1 !== e) {
            missing = index + 1;
        }
    });

    return missing;
}


console.log(PermMissingElem( [2, 3, 1, 5]))

function TapeEquilibrium(A: number[]) {
    const totalSum = A.reduce((previousValue, currentValue) => {
        return previousValue + currentValue
    }, 0);

    let minDiff = Math.abs(totalSum - A[0]);

    let sum = 0
    for (let i = 0; i < A.length - 1; i++) {
        const e = A[i];
        sum+=e;
        const diff = Math.abs(sum - (totalSum - sum));
        if (diff<minDiff){
            minDiff = diff;
        }
    }

    return minDiff;
}

console.log(TapeEquilibrium([0,0,0,1,1,1,-1,-1,-1]));
