package leetcode;

import java.util.*;

public class Valid_Soduku_36 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();

        for (int subSquare = 0; subSquare < 9; subSquare++) {
            int startRow = (subSquare / 3) * 3;
            var startColumn = (subSquare % 3) * 3;
            Set<Character> subSquareSet = new HashSet<>();

            var val0 = board[startRow][startColumn];
            var val1 = board[startRow][startColumn + 1];
            var val2 = board[startRow][startColumn + 2];
            Set<Character> rowSet0 = this.getSetForIndex(rowMap, startRow);
            Set<Character> colSet0 = this.getSetForIndex(columnMap, startColumn);
            Set<Character> colSet1 = this.getSetForIndex(columnMap, startColumn + 1);
            Set<Character> colSet2 = this.getSetForIndex(columnMap, startColumn + 2);
            if (
                    !this.checkAndAddValidValues(rowSet0, new char[]{val0, val1, val2}) ||
                            !this.checkAndAddValidValues(colSet0, new char[]{val0}) ||
                            !this.checkAndAddValidValues(colSet1, new char[]{val1}) ||
                            !this.checkAndAddValidValues(colSet2, new char[]{val2})
            ) {
                return false;
            }


            var val3 = board[startRow + 1][startColumn];
            var val4 = board[startRow + 1][startColumn + 1];
            var val5 = board[startRow + 1][startColumn + 2];
            Set<Character> rowSet1 = this.getSetForIndex(rowMap, startRow + 1);
            Set<Character> colSet3 = this.getSetForIndex(columnMap, startColumn);
            Set<Character> colSet4 = this.getSetForIndex(columnMap, startColumn + 1);
            Set<Character> colSet5 = this.getSetForIndex(columnMap, startColumn + 2);

            if (
                    !this.checkAndAddValidValues(rowSet1, new char[]{val3, val4, val5}) ||
                            !this.checkAndAddValidValues(colSet3, new char[]{val3}) ||
                            !this.checkAndAddValidValues(colSet4, new char[]{val4}) ||
                            !this.checkAndAddValidValues(colSet5, new char[]{val5})
            ) {
                return false;
            }


            var val6 = board[startRow + 2][startColumn];
            var val7 = board[startRow + 2][startColumn + 1];
            var val8 = board[startRow + 2][startColumn + 2];
            Set<Character> rowSet2 = this.getSetForIndex(rowMap, startRow + 2);
            Set<Character> colSet6 = this.getSetForIndex(columnMap, startColumn);
            Set<Character> colSet7 = this.getSetForIndex(columnMap, startColumn + 1);
            Set<Character> colSet8 = this.getSetForIndex(columnMap, startColumn + 2);
            if (
                    !this.checkAndAddValidValues(rowSet2, new char[]{val6, val7, val8}) ||
                            !this.checkAndAddValidValues(colSet6, new char[]{val6}) ||
                            !this.checkAndAddValidValues(colSet7, new char[]{val7}) ||
                            !this.checkAndAddValidValues(colSet8, new char[]{val8})
            ) {
                return false;
            }


            if (!this.checkAndAddValidValues(subSquareSet, new char[]{val0, val1, val2, val3, val4, val5, val6, val7, val8})) {
                return false;
            }
        }

        return true;
    }


    public boolean isValidSudoku2(char[][] board) {
        for (int subSquare = 0; subSquare < 9; subSquare++) {
            int startRow = (subSquare / 3) * 3;
            var startColumn = (subSquare % 3) * 3;
            Set<Character> subSquareSet = new HashSet<>();

            var val0 = board[startRow][startColumn];
            var val1 = board[startRow][startColumn + 1];
            var val2 = board[startRow][startColumn + 2];

            var val3 = board[startRow + 1][startColumn];
            var val4 = board[startRow + 1][startColumn + 1];
            var val5 = board[startRow + 1][startColumn + 2];

            var val6 = board[startRow + 2][startColumn];
            var val7 = board[startRow + 2][startColumn + 1];
            var val8 = board[startRow + 2][startColumn + 2];

            if (!this.checkAndAddValidValues(subSquareSet, new char[]{val0, val1, val2, val3, val4, val5, val6, val7, val8})) {
                return false;
            }
        }

        for (int row = 0; row < 9; row++) {
            Set<Character> rowSet = new HashSet<>();
            for (int col = 0; col < 9 ; col++) {
                char character = board[row][col];
                if (character != '.' && rowSet.contains(character)) {
                    return false;
                }
                rowSet.add(character);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> colSet = new HashSet<>();
            for (int row = 0; row < 9 ; row++) {
                char character = board[row][col];
                if (character != '.' && colSet.contains(character)) {
                    return false;
                }
                colSet.add(character);
            }
        }

        return true;
    }

    private boolean checkAndAddValidValues(Set<Character> set, char[] chars) {
        for (char character : chars) {
            if (character != '.' && set.contains(character)) {
                return false;
            }
            set.add(character);
        }
        return true;
    }

    private Set<Character> getSetForIndex(Map<Integer, Set<Character>> map, int index) {
        if (!map.containsKey(index)) {
            map.put(index, new HashSet<>());
        }

        return map.get(index);
    }
}