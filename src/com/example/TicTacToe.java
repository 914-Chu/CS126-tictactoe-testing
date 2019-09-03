package com.example;
import java.util.*;

public class TicTacToe {

    private static char winner;
    private static char[] array;
    private static int XCount = 0;
    private static int OCount = 0;

    public TicTacToe() {

    }

    public static Evaluation evaluateBoard(String boardState) {

        array = boardState.toLowerCase().toCharArray();
        int length = boardState.length();
        boolean result = checkWin(array);
        count(array);


        if(length > 9 || length < 0) {

            return Evaluation.InvalidInput;
        }else if(!checkReach(array)) {

            return Evaluation.UnreachableState;
        } else if(!checkWin(array) || checkNull(array)) {

            return Evaluation.NoWinner;
        }else if(checkWin(array)) {

            if(winner == 'x') return Evaluation.Xwins;
            else if (winner == 'o') return Evaluation.Owins;
        }
        return null;
    }

    private static boolean checkReach(char[] c) {

        if(Math.abs(XCount - OCount) > 1) return false;
        else return true;
    }

    private static boolean checkWin(char[] c) {

        if(checkCol(c) || checkRow(c) || checkDia(c)) {

            return true;
        }else return false;
    }

    private static boolean checkCol(char[] c) {

        for(int i = 0; i < 7; i+=3) {

            if(checkChar(c[i])) {
                if(c[i] == c[i+1] && c[i+1] == c[i+2]) {

                    winner = c[i];
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
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDia(char[] c) {

        if(checkChar(c[0])) {

            if(c[0] == c[4] && c[4] == c[8]) {

                winner = c[0];
                return true;
            }
        }else if(checkChar(c[2])) {

            if(c[2] == c[4] && c[4] == c[6]) {

                winner = c[2];
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

        if(c == 'x' || c == 'o') return true;
        else return false;
    }

    private static void count(char[] c) {

        for(int i = 0; i < 9; i++) {

            if(c[i] == 'x') XCount++;
            else if(c[i] == 'o') OCount++;
        }
    }


}
