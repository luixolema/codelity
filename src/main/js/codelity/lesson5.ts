import * as punycode from "punycode";

function PasssingCars(A: number[]) {
    let passing = 0;
    let carsToEst = 0;
    for (const car of A) {
        if (car === 0) {
            carsToEst++;
        } else if (car === 1) {
            passing += carsToEst
        }

        if (passing > 1000000000) {
            return -1;
        }
    }

    return passing;

}

function CountDiv(A: number, B: number, K: number): number {
    const divBetween_0_and_A = Math.floor(A / K);
    const divBetween_0_and_B = Math.floor(B / K);
    let result = divBetween_0_and_B - divBetween_0_and_A;
    if (A % K === 0) {
        result++;
    }
    return result;
}

console.log(CountDiv(2, 11, 2));

function GenomicRangeQuery(S: string, P: number[], Q: number[]): number[] {
    const aExistence = [];
    let aSum = 0;
    const cExistence = [];
    let cSum = 0;
    const gExistence = [];
    let gSum = 0;
    for (let i = 0; i < S.length; i++) {
        if (S.charAt(i) === 'A') {
            aSum++;
        } else if (S.charAt(i) === 'C') {
            cSum++;
        } else if (S.charAt(i) === 'G') {
            gSum++;
        }
        aExistence[i] = aSum;
        cExistence[i] = cSum;
        gExistence[i] = gSum;
    }

    const result = [];
    for (let i = 0; i < P.length; i++) {
        const init = P[i];
        const end = Q[i];
        if (end - init === 0) {
            const value = S[end];
            if (value == 'A') {
                result.push(1);
            } else if (value == 'C') {
                result.push(2);
            } else if (value == 'G') {
                result.push(3);
            } else {
                result.push(4);
            }
            continue;
        }

        if (aExistence[end] - aExistence[init] > 0) {
            result.push(1);
        } else if (cExistence[end] - cExistence[init] > 0) {
            result.push(2);
        } else if (gExistence[end] - gExistence[init] > 0) {
            result.push(3);
        } else {
            result.push(4);
        }
    }

    return result;
}

console.log(GenomicRangeQuery('CAGCCTA', [2, 5, 0], [4, 5, 6]))

