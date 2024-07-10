function majorityElement(nums: number[]): number {
    const occurrences: {[key: number]: number} ={};
    let result = -1;

    for (const num of nums) {
        if (occurrences[num] === undefined){
            occurrences[num] = 1;
        }else {
            occurrences[num]= occurrences[num] + 1;
        }

        if (occurrences[num] > nums.length / 2){
            result = num;
            break;
        }
    }

    return result;
}

console.log(majorityElement([2,2,1,1,1,2,2]));