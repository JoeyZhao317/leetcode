package com.buptcoder.acm;

import static org.junit.Assert.*;

import org.junit.Test;

public class SodukuTest {

    @Test
    public void testValidValue() {
        String raw1 = "..9748...,7........,.2.1.9...,..7...24.,.64.1.59.,.98...3..,...8.3.2.,........6,...2759..";
        Sudoku instantce = new Sudoku();
        char[][] test1 = instantce.convertSudoku(raw1);
        assertTrue(instantce.validValue(test1, 0, 0, '3'));
        assertTrue(instantce.validValue(test1, 0, 0, '1'));
        assertTrue(instantce.validValue(test1, 0, 0, '5'));
        assertTrue(instantce.validValue(test1, 0, 0, '6'));
        assertFalse(instantce.validValue(test1, 0, 0, '2'));
        assertFalse(instantce.validValue(test1, 0, 0, '4'));
        assertFalse(instantce.validValue(test1, 0, 0, '7'));
        assertFalse(instantce.validValue(test1, 0, 0, '8'));
        assertFalse(instantce.validValue(test1, 0, 0, '9'));
        assertTrue(instantce.validValue(test1, 0, 1, '3'));
        assertTrue(instantce.validValue(test1, 0, 1, '1'));
        assertTrue(instantce.validValue(test1, 0, 1, '5'));
        assertFalse(instantce.validValue(test1, 0, 1, '8'));
    }

    @Test
    public void testSudoResolve() {
        String raw1 = "..9748...,7........,.2.1.9...,..7...24.,.64.1.59.,.98...3..,...8.3.2.,........6,...2759..";
        String rawResult1 = "519748632,783652419,426139875,357986241,264317598,198524367,975863124,832491756,641275983";

        String raw2 = "53..7....,6..195...,.98....6.,8...6...3,4..8.3..1,7...2...6,.6....28.,...419..5,....8..79";
        String rawResult2 = "534678912,672195348,198342567,859761423,426853791,713924856,961537284,287419635,345286179";

        String raw3 = ".265...9.,5...79..4,3...1....,6.....8.7,.75.2..1.,.1....4..,...3.89.2,7...6..4.,.3.2..1..";
        String rawResult3 = "426583791,581679234,397412586,643195827,975824613,218736459,164358972,752961348,839247165";

        String raw4 = "...2...63,3....54.1,..1..398.,.......9.,...538...,.3.......,.263..5..,5.37....8,47...1...";
        String rawResult4 = "854219763,397865421,261473985,785126394,649538172,132947856,926384517,513792648,478651239";

        String raw5 = "1...7..3.,83.6.....,..29..6.8,6....49.7,.9.....5.,3.75....4,2.3..91..,.....2.43,.4..8...9";
        String rawResult5 = "169875432,834621795,572943618,625134987,498267351,317598264,283459176,956712843,741386529";

        Sudoku instantce = new Sudoku();

        char[][] test1 = instantce.convertSudoku(raw1);
        char[][] testResult1 = instantce.convertSudoku(rawResult1);
        instantce.solveSudoku(test1);
        assertTrue(compareSudu(test1, testResult1));

        char[][] test2 = instantce.convertSudoku(raw2);
        char[][] testResult2 = instantce.convertSudoku(rawResult2);
        instantce.solveSudoku(test2);
        assertTrue(compareSudu(test2, testResult2));

        char[][] test3 = instantce.convertSudoku(raw3);
        char[][] testResult3 = instantce.convertSudoku(rawResult3);
        instantce.solveSudoku(test3);
        assertTrue(compareSudu(test3, testResult3));

        char[][] test4 = instantce.convertSudoku(raw4);
        char[][] testResult4 = instantce.convertSudoku(rawResult4);
        instantce.solveSudoku(test4);
        assertTrue(compareSudu(test4, testResult4));

        char[][] test5 = instantce.convertSudoku(raw5);
        char[][] testResult5 = instantce.convertSudoku(rawResult5);
        instantce.solveSudoku(test5);
        assertTrue(compareSudu(test5, testResult5));
    }

    private boolean compareSudu(char[][] a, char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
