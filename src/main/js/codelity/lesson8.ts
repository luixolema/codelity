function Dominator(A: number[]) {
    const occurrences: { [key: number]: number } = {};
    const minDominatorAmount = A.length / 2;

    for (let i = 0; i < A.length; i++) {
        let number = A[i];
        occurrences[number] = occurrences[number] ? occurrences[number] + 1 : 1;
        if (occurrences[number] > minDominatorAmount) {
            return i;
        }
    }

    return -1;
}

function EquiLeader(A: number[]) {
    function leaderAndOcurrences(A: number[]): { leader: number, totalLeaderOccurrences: number } {
        const occurrences: { [key: number]: number } = {};
        let totalLeaderOccurrences = 0
        let leader = 0;
        for (const number of A) {
            occurrences[number] = occurrences[number] ? occurrences[number] + 1 : 1;
            if (occurrences[number] > totalLeaderOccurrences) {
                leader = number;
                totalLeaderOccurrences = occurrences[number];
            }
        }

        return {leader, totalLeaderOccurrences};
    }

    const {leader, totalLeaderOccurrences} = leaderAndOcurrences(A);
    let leaderOccurrences = 0;
    const equiLeaders: number[] = [];

    for (let i = 0; i < A.length - 1; i++) {
        if (A[i] === leader) {
            leaderOccurrences++;
        }
        const otherHalfLeaderOccurrences = totalLeaderOccurrences - leaderOccurrences;
        const totalNumbersInOtherHalf = A.length - (i + 1);

        let isLeaderStillLeaderInSecondHalf = otherHalfLeaderOccurrences > Math.floor(totalNumbersInOtherHalf / 2);

        if (!isLeaderStillLeaderInSecondHalf) {
            continue;
        }

        let isLeaderTheLeaderInFirstHalf = leaderOccurrences > Math.floor((i + 1) / 2);

        if (isLeaderTheLeaderInFirstHalf && isLeaderStillLeaderInSecondHalf) {
            equiLeaders.push(i);
        }
    }

    return equiLeaders.length;
}

console.log(EquiLeader( [4, 4, 2, 5, 3, 4, 4, 4]))