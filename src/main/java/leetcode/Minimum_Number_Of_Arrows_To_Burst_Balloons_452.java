package leetcode;

import java.util.Arrays;

public class Minimum_Number_Of_Arrows_To_Burst_Balloons_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        var currentArrowAt = points[0][1];
        var arrows = 1;

        for (int i = 1; i < points.length; i++) {
            var leftLimit = points[i][0];
            if (currentArrowAt < leftLimit) {
                arrows++;
                currentArrowAt = points[i][1];
            }
        }

        return arrows;
    }
}
