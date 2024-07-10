import * as buffer from "buffer";

function FrogRiverOne(X: number, A: number[]) {
    const existingLeaves = new Set<number>();
    for (let i = 0; i < A.length; i++) {
        const second = i;
        const element: number = A[i];
        if (element <= X) {
            existingLeaves.add(element);
            if (existingLeaves.size === X) {
                return second;
            }
        }
    }

    return -1;
}

// console.log(FrogRiverOne(5, [1, 3, 1, 4, 2, 3, 5, 4]));


function PermCheck(A: number[]) {
    const IS_PERM = 1;
    const IS_NOT_PERM = 0;
    const set = new Set<number>()

    for (const number of A) {
        if (number > A.length) {
            return IS_NOT_PERM;
        }
        if (set.has(number)) {
            return IS_NOT_PERM;
        }
        set.add(number);
    }

    return set.size === A.length ? IS_PERM : IS_NOT_PERM;
}

console.log(PermCheck([4, 1, 3, 2]));


function MaxCounters(N: number, A: number[]) {
    let minValue = 0;
    let maxValue = 0;
    const solution = new Array(N).fill(0);

    for (const counter of A) {
        if (counter > N) {
            minValue = maxValue;
        } else {
            const index = counter - 1;
            let value = solution[index];
            if (value < minValue) {
                value = minValue;
            }
            ++value;
            if (value > maxValue) {
                maxValue = value;
            }
            solution[index] = value;
        }
    }

    return solution.map(e => e < minValue ? minValue : e);
}

console.log(MaxCounters(5, [3, 4, 4, 6, 1, 4, 4]))

function MissingInteger(A: number[]) {
    const N = A.length;
    const present = new Set<number>(); // Track present numbers

    for (const num of A) {
        if (num > 0 && num <= N) {
            present.add(num);
        }
    }

    for (let i = 1; i <= N; i++) {
        if (!present.has(i)) {
            return i;
        }
    }

    return N + 1;
}

console.log(MissingInteger([-1, -3]));

