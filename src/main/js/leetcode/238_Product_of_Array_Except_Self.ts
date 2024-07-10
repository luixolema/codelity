function productExceptSelf(nums: number[]): number[] {
    const productsFromLeftToRight: number[] = [];
    const productsFromRightToLeft: number[] = [];


    let result: number = 1;
    for (const num of nums) {
        result *= num;
        productsFromLeftToRight.push(result);
    }
    result = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        result *= nums[i];
        productsFromRightToLeft.splice(0, 0, result)
    }

    const response: number[] = [];
    for (let i = 0; i < nums.length; i++) {
        let previousIndex = i - 1;
        let nextIndex = i + 1;
        const productsFromLeft = previousIndex >= 0 ? productsFromLeftToRight[previousIndex] : 1;
        const productsFromRight = nextIndex < nums.length ? productsFromRightToLeft[nextIndex] : 1;
        response.push(productsFromLeft * productsFromRight)
    }

    return response;
}

/**
 * The most optimal solution comes when you realize that you can store the prefix where is needed in the response array
 * (the prefix result for the number in position 3, is the stored in position 3)
 * and later accumulate the postfixes and multiply them for the prefix stored in the desired position, that is the response
 * (the postfix result for the number in position 3 is used with the prefix of that number (stored also in position 3) )
 * for each position of the response array (multiplicationPrefix * multiplicationPostfix)
 * (the response for the number in position 3 is the prefix (stored in position 3 * the postfix of that number) the result is stored in position 3)
 */
function productExceptSelf_ComplexOptimal(nums: number[]): number[] {
    const response: number[] = [1];
    // the first prefixMultiplication actually is not important,
    // it won't the prefix of any element because there is no element before the first position (so is not a prefix of anything)
    // here is initialized = 1 because will be used for multiply the postfix later (for not to throw the error)

    let accumulativePrefix: number = 1;
    for (let i = 0; i < nums.length - 1; i++) {
        accumulativePrefix*=nums[i];
        response[i+1] = accumulativePrefix;
    }

    // the last postFixMultiplication actually is not important,
    // it won't the postFix of any element because there is no element after the last position (so is not a postfix of anything)
    let accumulativePostfix = 1;
    for (let i = nums.length - 1; i > 0; i--) {
        accumulativePostfix *= nums[i];
        // so far the response array contains the multiplicationPrefixes stored in the position that matters
        // so now we can multiply by the accumulative Postfix for that position
        response[i-1] = response[i-1] * accumulativePostfix;
    }


    return response;
}

console.log(productExceptSelf_ComplexOptimal([1, 2, 3, 4]), "expected: [24,12,8,6]")
console.log(productExceptSelf_ComplexOptimal([-1, 1, 0, -3, 3]), "expected: [0,0,9,0,0]")