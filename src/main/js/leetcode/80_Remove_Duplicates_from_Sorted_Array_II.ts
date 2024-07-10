function removeDuplicates2(nums: number[]): number {
    let pointer1 = 0;
    let repeated = false;
    let result = 1;
    for (let i = 1; i < nums.length; i++) {
        const number = nums[i];
        if(number !== nums[pointer1]){
            ++pointer1;
            nums[pointer1] = number;
            result++;
            repeated = false;
        }else{
            if (!repeated){
                result++;
                repeated = true;
                pointer1 ++;
                nums[pointer1] = number;
            }
        }
    }
    return result;
}

function removeDuplicatesSimple(nums: number[]): number {
    if (nums.length <= 2) {
        return nums.length
    }
    let firstPointer = 1;
    for (let i = 2; i < nums.length; i++) {
        if (nums[i] !== nums[firstPointer] || nums[i] !== nums[firstPointer - 1]){
            firstPointer++;
            nums[firstPointer] = nums[i];
        }
    }
    return firstPointer + 1;
}

const arr = [0,0,1,1,1,1,2,3,3];
console.log(removeDuplicatesSimple(arr), arr);