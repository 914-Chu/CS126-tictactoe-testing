package com.example;
import java.util.*;

public class TicTacToe {

    private char[] array = new char[9];
    private String currentState;

    public TicTacToe() {

        Arrays.fill(array,'-');
        convert(array);
    }

    public String getCurrentState() {

        return currentState;
    }

    public char[] getArray() {

        return array;
    }

    public void upDate(int position, char c) {

        array[position] = c;
        convert(array);
    }

    private void convert(char[] a) {

        currentState = String.valueOf(a);
    }


    public static Evaluation evaluateBoard(String boardState) {
        // implement your code here
        return Evaluation.InvalidInput;
    }
}
