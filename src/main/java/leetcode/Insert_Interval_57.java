package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Insert_Interval_57 {
    private boolean isOverlapping(int[] left, int[] right) {
        return !(left[1] < right[0] || left[0] > right[1]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            var current = intervals[i];
            if (newInterval[1] < current[0]){
                result.add(newInterval);
                List<int[]> remainingElements = Arrays.asList(intervals).subList(i, intervals.length);
                result.addAll(remainingElements);

                return result.toArray(new int[result.toArray().length][]);
            }
            if (isOverlapping(current, newInterval)) {
                newInterval[0] = Math.min(current[0], newInterval[0]);
                newInterval[1] = Math.max(current[1], newInterval[1]);
            }else{
                result.add(current);
            }
        }

        result.addAll(Arrays.asList(newInterval));

        return result.toArray(new int[result.toArray().length][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();
        var inserted = false;

        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.toArray().length][]);
        }

        if (newInterval[1] < intervals[0][0]) {
            result.add(newInterval);
            Collections.addAll(result, intervals);
            return result.toArray(new int[result.toArray().length][]);
        }

        for (int i = 0; i < intervals.length; i++) {
            var previous = result.isEmpty() ? null : result.get(result.size() - 1);
            var current = intervals[i];
            if (inserted) {
                addToList(result, current);
                continue;
            }

            if (previous == null) {
                inserted = addToList(result, current, newInterval);
            } else {
                inserted = addToList(result, previous, current, newInterval);
            }
        }

        if (!inserted){
            result.add(newInterval);
        }

        return result.toArray(new int[result.toArray().length][]);
    }

    private void addToList(ArrayList<int[]> result, int[] current) {
        var previous = result.get(result.size() - 1);
        if (isOverlapping(previous, current)) {
            var leftLimit = Math.min(current[0], previous[0]);
            var rightLimit = Math.max(current[1], previous[1]);
            result.set(result.size() - 1, new int[]{leftLimit, rightLimit});
        } else {
            result.add(current);
        }
    }

    private boolean addToList(ArrayList<int[]> result, int[] current, int[] newInterval) {
        if (newInterval[1] < current[0]) {
            result.add(newInterval);
            result.add(current);
            return true;
        }

        if (newInterval[0] > current[1]) {
            result.add(current);
            return false;
        }

        var leftLimit = Math.min(current[0], newInterval[0]);
        var rightLimit = Math.max(current[1], newInterval[1]);
        result.add(new int[]{leftLimit, rightLimit});
        return true;
    }

    private boolean addToList(ArrayList<int[]> result, int[] previous, int[] current, int[] newInterval) {
        if (newInterval[0] > current[1]) {
            addToList(result, current);
            return false;
        }

        if (isOverlapping(previous, newInterval)) {
            var leftLimit = Math.min(newInterval[0], previous[0]);
            var rightLimit = Math.max(newInterval[1], previous[1]);
            result.set(result.size() - 1, new int[]{leftLimit, rightLimit});
            this.addToList(result, current);
            return true;
        }

        if (isOverlapping(current, newInterval)) {
            var leftLimit = Math.min(newInterval[0], current[0]);
            var rightLimit = Math.max(newInterval[1], current[1]);
            result.add(new int[]{leftLimit, rightLimit});
            return true;
        }

        result.add(newInterval);
        result.add(current);
        return true;
    }
}
