package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Joyce Chu
 */
public class TicTacToeTest {
    
    @Test
    public void outOfBoundary() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("O...X.X..."));
    }

    @Test
    public void missingEntry() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("OO...X"));
    }

    @Test
    public void noEntry() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(""));
    }

    @Test
    public void allX() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXXXXXXXX"));
    }

    @Test
    public void unequalTurns() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("OOOOOOXX."));
    }

    @Test
    public void duplicateRowWinner() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("OOOXXX..."));
    }

    @Test
    public void duplicateColWinner() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("OX.OX.OX."));
    }

    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }
    
    @Test
    public void emptyBoardWithOtherSymbols() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("n2siEl!d-"));
    }

    @Test
    public void noWinnerFullBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("OXOXXOXOX"));
    }

    @Test
    public void XWinsCol() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XO.XXOXO."));
    }

    @Test
    public void XWinsDiaLeft() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XO..XOXOX"));
    }

    @Test
    public void OWinsRow() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("X..OOOX.."));
    }

    @Test
    public void OWinsDiaRight() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard(".XOXO.O.."));
    }

    @Test
    public void OWinsCaseInsensitive() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard(".xOXo.O.."));
    }
}