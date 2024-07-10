function removeDuplicatesFirstThought(nums: number[]): number {
    let lastUniqueElementIndex = 0;
    let uniqueElements = nums.length;

    for (let i = 1; i < uniqueElements; i++) {
        const number = nums[i];
        const lastUniqueElement=nums[lastUniqueElementIndex];

        if (number === lastUniqueElement){
            let removed = nums.splice(i,1);
            nums.push(...removed);
            uniqueElements--;
            i--;
        }else{
            lastUniqueElementIndex = i;
        }
    }

    return uniqueElements;
}

/**
 * be aware that the array is sorted
 * when I go through the array with 2 pointers, one for the last unique element and one for exploring the rest
 * Im interested on the unique elements (the new unique elements are those that are not equal to the last one [the array is sorted])
 * if I found that new unique element I can put it as the next element to the last unique element pointed by the first pointer
 * the amount of unique elements will be the last unique element index + 1
 */
function removeDuplicatesSecondThought(nums: number[]): number {
    let lastUniqueElementIndex = 0;

    for (let i = 1; i < nums.length; i++) {
        const number = nums[i];
        const lastUniqueElement=nums[lastUniqueElementIndex];

        if (number !== lastUniqueElement){
            lastUniqueElementIndex++;
            nums[lastUniqueElementIndex] = nums[i];
        }
    }

    return lastUniqueElementIndex + 1;
}

const arr = [0,0,1,1,1,2,2,3,3,4];
console.log(removeDuplicatesSecondThought(arr), arr);