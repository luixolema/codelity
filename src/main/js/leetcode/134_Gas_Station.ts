/**
 * if we go through the difference array (the gas that remains to get to the next station)
 * if we found that at that position the value < 0 then the previous start position is not a valid solution,
 * it happens that if the sum of the differences are >0 then there is one solution, so instead of finding the correct one
 * we discard all the wrong ones (the ones that for sure wont be a starting point because then can not reach the next stations)
 * at the end we end up with a position where the sum of differences doest become 0, or the last position, in any case
 * that would be the solution, because all the others are not valid.
 */
function canCompleteCircuit(gas: number[], cost: number[]): number {
    const diff: number[] = [];
    let total = 0;

    for (let i = 0; i < gas.length; i++) {
        diff[i]= gas[i] - cost[i];
        total+=diff[i];
    }

    if (total < 0){
        return -1;
    }

    let tank = 0;
    let startPosition = 0;
    for (let i = 0; i < diff.length; i++) {
        tank += diff[i];
        if (tank < 0){
            tank = 0;
            startPosition = i+1;
        }
    }

    return startPosition;
}

console.log(canCompleteCircuit([5,8,2,8],[6,5,6,6]));