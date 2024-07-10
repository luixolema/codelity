package leetcode;


/**
 * What is kleber in here is to realize that we can start inserting the bigger numbers at the end of the array,
 * that way we dont have to insert in the middle and push all the next elements inside the array to new positions.
 *
 * We just pick the biggest number (pointers at the end of each array) and insert it at the end of the array (pointer at the end of the first array).
 * We need to insert all elements of the array 2 into the array 1, after that we know that we finish.
 *
 * (At the point we have to overwrite a number in array1 that number was already inserted in the right position)
 */
public class MergeSorteArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var biggestEelemntInArrayNums1Index = m - 1;
        var biggestEelemntInArrayNums2Index = n - 1;
        var insertionPointer = nums1.length - 1;
        if (n == 0) {
            return;
        }

        while (biggestEelemntInArrayNums2Index >= 0) {
            int num1 = biggestEelemntInArrayNums1Index >= 0 ? nums1[biggestEelemntInArrayNums1Index] : Integer.MIN_VALUE;
            int num2 = nums2[biggestEelemntInArrayNums2Index];

            if (num1 > num2) {
                nums1[insertionPointer] = num1;
                biggestEelemntInArrayNums1Index--;
            } else {
                nums1[insertionPointer] = num2;
                biggestEelemntInArrayNums2Index--;
            }

            insertionPointer--;
        }
    }
}
