package com.buptcoder.acm;

public class SudukuValider {
//    private boolean isSolved = false;
//    private char[][] result;

    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
//        isSolved = false;
        if (!checkSuduku(board)) {
            return false;
        }
//        result = new char[9][];
//        for (int i = 0; i < 9; i++) {
//            result[i] = new char[9];
//        }
//        char[][] tmp = cloneBoard(board);
//        int count = getEmptyCount(tmp);
//        solveSudokuRecusive(tmp, count);
//        copy(board, result);
        return true;
    }

    private boolean checkSuduku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!validValue(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    private void solveSudokuRecusive(char[][] board, int count) {
//        if (count == 0 || isSolved) {
//            return;
//        } else {
//            int[] first = getFirstEmpty(board);
//            for (int i = 0; i < 9; i++) {
//                int tmpcount = count;
//                char[][] tmpboard = cloneBoard(board);
//                char tmp = (char) ('1' + i);
//                if (validValue(board, first[0], first[1], tmp)) {
//                    if (count == 1) {
//                        isSolved = true;
//                        tmpboard[first[0]][first[1]] = tmp;
//                        copy(result, tmpboard);
//                        return;
//                    }
//                    tmpboard[first[0]][first[1]] = tmp;
//                    solveSudokuRecusive(tmpboard, --tmpcount);
//                }
//            }
//        }
//    }

    public boolean validValue(char[][] board, int row, int column, char value) {
        boolean result = false;
        assert (value >= '1' && value <= '9');
        if (validRow(board, row,column, value) && validColumn(board, row, column, value)
                && validPiece(board, row, column, value)) {
            result = true;
        }
        return result;
    }

    private char[][] cloneBoard(char[][] old) {
        char[][] newboard = new char[9][];
        for (int i = 0; i < 9; i++) {
            newboard[i] = new char[9];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newboard[i][j] = old[i][j];
            }
        }
        return newboard;
    }

    private boolean validRow(char[][] board, int row, int column, char value) {
        boolean result = true;
        for (int i = 0; i < 9; i++) {
            if(i == column) {
                continue;
            }
            if (board[row][i] == value) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean validColumn(char[][] board, int row, int column, char value) {
        boolean result = true;
        for (int i = 0; i < 9; i++) {
            if(i == row) {
                continue;
            }
            if (board[i][column] == value) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean validPiece(char[][] board, int i, int j, char value) {
        boolean result = true;
        int x = i / 3;
        int y = j / 3;
        for (int p = x * 3; p < (x + 1) * 3; p++) {
            for (int q = y * 3; q < (y + 1) * 3; q++) {
                if( p == i && q == j) {
                    continue;
                }
                if (board[p][q] == value) {
                    return false;
                }
            }
        }
        return result;
    }

    private int getEmptyCount(char[][] board) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] getFirstEmpty(char[][] board) {
        int[] pointer = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    pointer[0] = i;
                    pointer[1] = j;
                    return pointer;
                }
            }
        }
        return null;
    }

    private void copy(char[][] a, char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    private void printResult(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String raw1 = "..9748...,7........,.2.1.9...,..7...24.,.64.1.59.,.98...3..,...8.3.2.,........6,...2759..";
        SudukuValider instantce = new SudukuValider();
        char[][] test1 = instantce.convertSudoku(raw1);
        String raw2 = "53..7....,6..195...,.98....6.,8...6...3,4..8.3..1,7...2...6,.6....28.,...419..5,....8..79";
        char[][] test2 = instantce.convertSudoku(raw2);

        instantce.isValidSudoku(test1);
        instantce.isValidSudoku(test2);

        instantce.printResult(test1);
        instantce.printResult(test2);
    }

    public char[][] convertSudoku(String rawString) {
        char[][] result = new char[9][];
        for (int i = 0; i < 9; i++) {
            result[i] = new char[9];
        }
        // String old = rawString.substring(1, rawString.length() - 1);
        String[] row = rawString.split(",");
        assert (row.length == 9);
        for (int i = 0; i < 9; i++) {
            assert (row[i].length() == 9);
            for (int j = 0; j < 9; j++) {
                result[i][j] = row[i].charAt(j);
            }
        }
        return result;
    }
}
