package com.example;

public class TicTacToe {

    private static char winner;
    private static int winCount = 0;
    private static int XCount = 0;
    private static int OCount = 0;

    public TicTacToe() {

    }

    public static Evaluation evaluateBoard(String boardState) {

        char[] array = boardState.toLowerCase().toCharArray();
        int length = boardState.length();
        count(array);


        if(length != 9) {

            return Evaluation.InvalidInput;
        }else if(checkTurns(array)) {

            return Evaluation.UnreachableState;
        }else if(checkDuplicate(array)) {

            return Evaluation.UnreachableState;
        }else if(!checkWin(array)) {

            return Evaluation.NoWinner;
        }else if(checkNull(array)) {

            return Evaluation.NoWinner;
        }else if(checkWin(array)) {

            if(winner == 'x') return Evaluation.Xwins;
            else if (winner == 'o') return Evaluation.Owins;
        }
        return null;
    }

    private static boolean checkTurns(char[] c) {

        return(Math.abs(XCount - OCount) > 1);
    }

    private static boolean checkDuplicate(char[] c) {

        winCount = checkCol(c) + checkRow(c) + checkDiaLeft(c) + checkDiaRight(c);
        return(winCount > 1);
    }

    private static boolean checkWin(char[] c) {

        return(winCount == 1);
    }

    private static int checkCol(char[] c) {

        int colCount = 0;

        for(int i = 0; i < 7; i+=3) {

            if(checkChar(c[i])) {
                if(c[i] == c[i+1] && c[i+1] == c[i+2]) {

                    winner = c[i];
                    colCount++;
                }
            }
        }

        return colCount;
    }

    private static int checkRow(char[] c) {

        int rowCount = 0;

        for(int i = 0; i < 3; i++) {

            if(checkChar(c[i])) {

                if (c[i] == c[i + 3] && c[i + 3] == c[i + 6]) {

                    winner = c[i];
                    rowCount++;
                }
            }
        }

        return rowCount;
    }

    private static int checkDiaLeft(char[] c) {

        int diaL = 0;

        if(checkChar(c[0])) {

            if(c[0] == c[4] && c[4] == c[8]) {

                winner = c[0];
                diaL++;
            }
        }

        return diaL;
    }

    private static int checkDiaRight(char[] c) {

        int diaR = 0;

        if(checkChar(c[2])) {

            if(c[2] == c[4] && c[4] == c[6]) {

                winner = c[2];
                diaR++;
            }
        }

        return diaR;
    }

    private static boolean checkNull(char[] c) {

        boolean state = true;

        for(char s : c) {

            if(checkChar(s)) {

                state = false;
            }
        }

        return state;
    }

    private static boolean checkChar(char c) {

        return (c == 'x' || c == 'o');
    }

    private static void count(char[] c) {

        for(int i = 0; i < c.length; i++) {

            if(c[i] == 'x') XCount++;
            else if(c[i] == 'o') OCount++;
        }
    }


}
