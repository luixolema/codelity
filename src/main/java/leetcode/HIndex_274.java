package leetcode;

import java.util.Arrays;

/**
 * If we sorted the array, we can start counting the amount of elements that are >= of the citation value (in that position)
 * if the counter gets greater than the maxPossibleCitations value, then we can return the counter - 1 (or init the counter in 0)
 * the counter = the amount of elements which values are =< the maxHindex Possible in that position (the value of the element in the sorted array)
 *
 * a more natural way is to compare the counter and that value of each citation and take the minimum of both, but is not needed,
 * we can iterate only while the counter is =< than the value of the element in the sorted array, so the counter will be always the minimum
 * so we can actually ignore the values in the array and take directly the counter.
 * the value of the citation will always be >= to the counter (that is a condition to be a valid h-index)
 *
 */

public class HIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int maxCitationsCounter = 0;

        for (int i = citations.length-1; i >= 0; i--) {
            if (maxCitationsCounter + 1 > citations[i]) {
                break;
            }
            maxCitationsCounter++;
        }

        return maxCitationsCounter;
    }
}
