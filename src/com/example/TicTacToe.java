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
        }else if(checkTurns(array) || checkDuplicate(array)) {

            return Evaluation.UnreachableState;
        } else if(!checkWin(array) || checkNull(array)) {

            return Evaluation.NoWinner;
        }else if(checkWin(array)) {

            if(winner == 'x') return Evaluation.Xwins;
            else if (winner == 'o') return Evaluation.Owins;
        }
        return null;
    }

    private static boolean checkTurns(char[] c) {

        count(c);
        return(Math.abs(XCount - OCount) > 1);
    }

    private static boolean checkDuplicate(char[] c) {

        return(checkWin(c) && winCount > 1);
    }

    private static boolean checkWin(char[] c) {

        return(checkCol(c) || checkRow(c) || checkDiaLeft(c) || checkDiaRight(c));
    }

    private static boolean checkCol(char[] c) {

        for(int i = 0; i < 7; i+=3) {

            if(checkChar(c[i])) {
                if(c[i] == c[i+1] && c[i+1] == c[i+2]) {

                    winner = c[i];
                    winCount++;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkRow(char[] c) {

        for(int i = 0; i < 3; i++) {

            if(checkChar(c[i])) {

                if (c[i] == c[i + 3] && c[i + 3] == c[i + 6]) {

                    winner = c[i];
                    winCount++;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiaLeft(char[] c) {

        if(checkChar(c[0])) {

            if(c[0] == c[4] && c[4] == c[8]) {

                winner = c[0];
                winCount++;
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiaRight(char[] c) {

        if(checkChar(c[2])) {

            if(c[2] == c[4] && c[4] == c[6]) {

                winner = c[2];
                winCount++;
                return true;
            }
        }
        return false;
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

        for(int i = 0; i < 9; i++) {

            if(c[i] == 'x') XCount++;
            else if(c[i] == 'o') OCount++;
        }
    }


}
