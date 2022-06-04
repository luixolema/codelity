package solutions;

public class Lesson1 {

    public int BinaryGap(int N){
        String s = Integer.toBinaryString(N);
        int sum=0;
        int maxSum = 0;
        boolean startCounting = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                maxSum = Integer.max(maxSum, sum);
                startCounting = true;
                sum = 0;
            }

            if (s.charAt(i) == '0' && startCounting){
                sum++;
            }
        }

        return maxSum;
    }
}
