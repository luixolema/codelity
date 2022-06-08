package solutions;

public class Lesson1 {

    public int BinaryGap(int N) {
        String s = Integer.toBinaryString(N);
        int sum = 0;
        int maxSum = 0;
        boolean startCounting = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                maxSum = Integer.max(maxSum, sum);
                startCounting = true;
                sum = 0;
            }

            if (s.charAt(i) == '0' && startCounting) {
                sum++;
            }
        }

        return maxSum;
    }

    public int binarySearch(int[] A, int key) {
        int start = 0;
        int end = A.length - 1;
        int middle = (start + end) / 2;

        while (start <= end) {
            if (A[middle] == key) {
                return middle;
            }

            if (A[middle] > key) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

            middle = (start + end) / 2;
        }

        return -1;
    }
}
