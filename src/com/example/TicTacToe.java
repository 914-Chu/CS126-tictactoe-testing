package com.example;
import java.util.*;

public class TicTacToe {

    private char[] array = new char[9];
    private char[] lowerCase = new char[9];
    private String currentState;
    private String winPos;
    private char winner;

    public TicTacToe() {

        Arrays.fill(array,'-');
        convert();
        toLower();
    }

    public String getCurrentState() {

        return currentState;
    }

    public char[] getArray() {

        return array;
    }

    public char getWinner(){

        return winner;
    }

    public void initialize() {

        Arrays.fill(array, '-');
        convert();
        toLower();
    }

    public void upDate(int position, char c) {

        array[position] = c;
        convert();
        toLower();
    }

    public boolean checkWin() {

        if(checkCol() || checkRow() || checkDia()) {

            return true;
        }else return false;
    }

    private void convert() {

        currentState = String.valueOf(array);
    }

    private void toLower() {

        lowerCase = currentState.toLowerCase().toCharArray();
    }

    private boolean checkCol() {

        for(int i = 0; i < 7; i+=3) {

            if(lowerCase[i] == lowerCase[i+1] && lowerCase[i+1] == lowerCase[i+2]) {

                winner = lowerCase[i];
                winPos = "Col" + i;
                return true;
            }
        }
        return false;
    }

    private boolean checkRow() {

        for(int i = 0; i < 3; i++) {

            if(lowerCase[i] == lowerCase[i+3] && lowerCase[i+3] == lowerCase[i+6]){

                winner = lowerCase[i];
                winPos = "Row" + i;
                return true;
            }
        }
        return false;
    }

    private boolean checkDia() {

        if(lowerCase[0] == lowerCase[4] && lowerCase[4] == lowerCase[8]) {

            winner = lowerCase[0];
            winPos = "Left Diagonals";
            return true;
        }else if(lowerCase[2] == lowerCase[4] && lowerCase[4] == lowerCase[6]) {

            winner = lowerCase[2];
            winPos = "Right Diagonals";
            return true;
        }else return false;
    }

    public static Evaluation evaluateBoard(String boardState) {
        // implement your code here
        return Evaluation.InvalidInput;
    }
}
