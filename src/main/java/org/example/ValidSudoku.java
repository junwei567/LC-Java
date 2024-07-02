package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> square = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // check for eligible number
                if (Character.getNumericValue(board[i][j]) < 1 || Character.getNumericValue(board[i][j]) > 9) {
                    return false;
                }
                // create the pair to identify which square the number is in
                // 9 possible squares -> (0,0), (0,1), (0,2), (1,0), ..., (2,2)
                int[] pair = {Math.floorDiv(i, 3), Math.floorDiv(j, 3)};
                String strPair = Arrays.toString(pair); // String is immutable, serve as the Key
                if ( (row.containsKey(i) && row.get(i).contains(board[i][j])) ||
                        (col.containsKey(j) && col.get(j).contains(board[i][j])) ||
                        (square.containsKey(strPair) && square.get(strPair).contains((board[i][j])))
                ) {
                    return false;
                }

                if (!row.containsKey(i)) {
                    row.put(i, new HashSet<>());
                }
                row.get(i).add(board[i][j]);
                if (!col.containsKey(j)) {
                    col.put(j, new HashSet<>());
                }
                col.get(j).add(board[i][j]);
                if (!square.containsKey(strPair)) {
                    square.put(strPair, new HashSet<>());
                }
                square.get(strPair).add(board[i][j]);
            }
        }
        // when the loop finish executing without any number conflicts, it is a valid sudoku
        return true;
    }
}
