function removeElement(nums: number[], val: number): number {
    const originalSize = nums.length;
    let occurrences = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === val) {
            occurrences++;
            nums.splice(i, 1);
            i--;
        }
    }
    return originalSize - occurrences;
}


function removeElement2Pointers(nums: number[], val: number) {
    let slowerPointer = 0;
    let occurrences = 0;

    for (let i = 0; i < nums.length; i++) {
        let number = nums[i];
        if (number === val) {
            occurrences++;
        } else {
            if (nums[slowerPointer] === val) {
                // if its not necessary I dont swap the values
                nums[slowerPointer] = number
                nums[i] = val;
            }
            slowerPointer++;
        }
    }

    return nums.length - occurrences;
}

function removeElementMinimalistic(nums: number[], val: number): number {
    let j = 0
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            const temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++
        }
    }
    return j

}

let arr = [1, 2, 1, 2, 2, 2, 2, 1, 1, 2];
let solution = removeElement2Pointers(arr, 2);
console.log(solution, arr);
