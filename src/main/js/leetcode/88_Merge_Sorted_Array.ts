/**
 The idea is to try to insert all elements of nums2 in nums1 (extracting them form nums2) find the correct index of nums1 to insert each element of nums2
 At the end we dont have more elements in nums2 or the index to insert in nums1 is the last possible index (m+insertedElements)
     in this last case we only need to add all remaining elements form nums2 to nums1.
 */
function mergeEasyToGet(nums1: number[], m: number, nums2: number[], n: number): void {
    let indexToInsertInNums1 = 0;
    let insertedElements = 0;

    while (nums2.length) {
        const elementToInsert = nums2[0]!;
        let inserted = false;


        while (indexToInsertInNums1 < m + insertedElements  && !inserted) {
            if (elementToInsert <= nums1[indexToInsertInNums1]) {
                insertedElements++;
                nums1.splice(indexToInsertInNums1, 0, elementToInsert);
                nums1.pop(); // removing the extra 0 value at the end
                inserted = true;
            }
            indexToInsertInNums1++;
        }

        if (inserted) {
            // removing the already inserted element of nums2
            nums2.shift();
        }

    }

    if (nums2.length) {
        // if there are still some elements to insert, remove all extra elements form nums1 (= the reminding amounts of elements to insert)
            // and add the remaining elements
        nums1.splice(indexToInsertInNums1, nums2.length, ...nums2)
    }
}

function mergeOptimal(nums1: number[], m: number, nums2: number[], n: number): void {
    let pointer1 = 0;
    let pointer2 = 0;
    let insertedElements = 0;

    while (pointer1 < m + insertedElements && pointer2 < n) {
        if (nums2[pointer2] <= nums1[pointer1]) {
            nums1.splice(pointer1, 0, nums2[pointer2]);
            pointer2++;
            pointer1++;
            insertedElements++;
        } else {
            pointer1++;
        }
    }

    if (insertedElements < n) {
        let remainingElements = nums2.slice(pointer2);
        nums1.splice(m + insertedElements, n, ...remainingElements);
    } else {
        nums1.splice(m + n, n);
    }
}

function mergeEasyWay(nums1: number[], m: number, nums2: number[], n: number): void {
    nums1.splice(m, n, ...nums2)
    nums1.sort((a, b) => a - b)
}

const number1 = [1, 2, 3, 0, 0, 0];
mergeEasyToGet(number1, 3, [1,1,1], 3);
console.log(number1);