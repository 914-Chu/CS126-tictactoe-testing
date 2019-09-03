package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Joyce Chu
 */
public class TicTacToeTest {

    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }

    @Test
    public void outOfBoundary() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("O...X.X..."));
    }

    @Test
    public void name() {
    }
}