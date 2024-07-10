package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Spiral_Matrix_54 {

    public int[][] test1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};


    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(total);

        int columnIndex = 0;
        int rowIndex = 0;

        int maxColumn = matrix[0].length - 1;
        int minColum = 0;
        int maxRow = matrix.length - 1;
        int minRow = 1;

        boolean goRight = true;
        boolean goLeft = false;
        boolean goDown = false;
        boolean goUp = false;

        for (int i = 0; i < total; i++) {
            result.add(matrix[rowIndex][columnIndex]);

            if (goRight) {
                if (columnIndex + 1 > maxColumn) {
                    goRight = false;
                    rowIndex++;
                    goDown = true;
                    maxColumn--;
                } else {
                    columnIndex++;
                }
                continue;
            }

            if (goDown) {
                if (rowIndex + 1 > maxRow) {
                    goLeft = true;
                    columnIndex--;
                    goDown = false;
                    maxRow--;
                } else {
                    rowIndex++;
                }
                continue;
            }

            if (goLeft) {
                if (columnIndex - 1 < minColum) {
                    goUp = true;
                    rowIndex--;
                    goLeft = false;
                    minColum++;
                } else {
                    columnIndex--;
                }
                continue;
            }

            if (goUp) {
                if (rowIndex - 1 < minRow) {
                    goRight = true;
                    columnIndex++;
                    goUp = false;
                    minRow++;
                } else {
                    rowIndex--;
                }
            }
        }

        return result;
    }
}
