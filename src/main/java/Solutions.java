import java.util.*;
import java.util.stream.Collectors;

public class Solutions {
    public int binarySearch(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        int middle = (start + end) / 2;

        while (start <= end) {
            if (value > a[middle]) {
                start = middle + 1;
            } else if (value == a[middle]) {
                return middle;
            } else {
                end = middle - 1;
            }
            middle = (start + end) / 2;
        }

        return -1;
    }


    /**
     * Given a gird for sudoku it checks if the gird is valid or not
     * considering the gird full of valid values (9x9 grid with numbers from 1-9
     * <p>
     * example of valid grid:
     * {
     * {7, 9, 2,   1, 5, 4,   3, 8, 6},
     * {6, 4, 3,   8, 2, 7,   1, 5, 9},
     * {8, 5, 1,   3, 9, 6,   7, 2, 4},
     * <p>
     * {2, 6, 5,   9, 7, 3,   8, 4, 1},
     * {4, 8, 9,   5, 6, 1,   2, 7, 3},
     * {3, 1, 7,   4, 8, 2,   9, 6, 5},
     * <p>
     * {1, 3, 6,   7, 4, 8,   5, 9, 2},
     * {9, 7, 4,   2, 1, 5,   6, 3, 8},
     * {5, 2, 8,   6, 3, 9,   4, 1, 7}
     * }
     */
    public boolean isValidSudokuGrid(int[][] grid) {
        if (!allRowsAreValid(grid)) {
            return false;
        }

        if (!allColumnsAreValid(grid)) {
            return false;
        }

        if (!allSubGridsAreValid(grid)) {
            return false;
        }

        return true;
    }

    private boolean allColumnsAreValid(int[][] grid) {
        for (int colum = 0; colum < 9; colum++) {
            ArrayList<Integer> elementsToCheck = new ArrayList<>();

            for (int row = 0; row < 9; row++) {
                elementsToCheck.add(grid[row][colum]);
            }
            if (!isValidSudokuSet(elementsToCheck)) {
                return false;
            }
        }

        return true;
    }

    private boolean allRowsAreValid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            List<Integer> sudokuSet = Arrays.stream(grid[i]).boxed().collect(Collectors.toList());
            if (!isValidSudokuSet(sudokuSet)) {
                return false;
            }
        }

        return true;
    }

    private boolean allSubGridsAreValid(int[][] grid) {
        for (int subGrid = 0; subGrid < 9; subGrid += 3) {
            for (int row = 0; row < 9; row += 3) {
                int[] row1 = grid[row];
                int[] row2 = grid[row + 1];
                int[] row3 = grid[row + 2];

                ArrayList<Integer> elementsToCheck = new ArrayList<>();


                for (int colum = 0; colum < 3; colum++) {
                    elementsToCheck.add(row1[colum + subGrid]);
                    elementsToCheck.add(row2[colum + subGrid]);
                    elementsToCheck.add(row3[colum + subGrid]);
                }

                if (!isValidSudokuSet(elementsToCheck)) {
                    return false;
                }

            }

        }

        return true;
    }

    public boolean isValidSudokuSet(List<Integer> set) {
        HashSet<Integer> aux = new HashSet<>();

        while (!set.isEmpty()) {
            if (!aux.add(set.remove(0))) {
                return false;
            }
        }

        return true;
    }
}
