package com.sda.game3;

import java.util.Scanner;

import static java.lang.System.out;

public class Board {
    //set the default showBoard
    private String[][] sign = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    Scanner sc = new Scanner(System.in);
    //flag to end the game
    boolean end = false;
    //flag to accept or not a move of player
    boolean playerMove = false;

    //basic method to run
    public void run() {
        out.println("Welcome to game Circle and Cross.");
        //show and fill the board
        showBoard(sign);
        //while end flag is not true continue the game
        while (end == false) {
            out.println("Player X, make a move e.g.  1,1");
            //while playerMove flag is false continue
            while (playerMove == false) {
                //get the move, and split for table
                String[] move = getMove().split(",");
                //if table got 2  values, accept move and assign it to sign[][] table
                if (move.length == 2) {
                    assignMove("X", move[0], move[1]);
                }
            }
            //check for gameStatus, if true break the loop
            if (gameStatus() == true) {
                out.println("Won by X");
                break;
            }
            //set flag back to false
            playerMove = false;
            out.println("Player Y, make a move e.g.  3,2");
            //while playerMove flag is false continue
            while (playerMove == false) {
                //get the move, and split for table
                String[] move = getMove().split(",");
                //if table got 2  values, accept move and assign it to sign[][] table
                if (move.length == 2) {
                    assignMove("Y", move[0], move[1]);
                }
            }
            //check for gameStatus, if true break the loop
            if (gameStatus() == true) {
                out.println("Won by Y");
                break;
            }
            //set flag back to false
            playerMove = false;
        }
    }

    //assign the move to table
    private void assignMove(String XO, String x, String y) {
        //if method makeMove does not return null
        if ((makeMove(XO, x, y)) != null) {
            //show the board
            showBoard(sign);
            //set flag playerMove to true
            playerMove = true;
            //otherwise do nothing
        } else {
            out.println("Wrong move. Please try again.");
        }
    }

    //check the sign[][] for horizontal
    private boolean horizontalCheck(String XO) {
        for (int i = 0; i < sign.length; i++) {
            //basic counter for repeats
            int xOsign = 0;
            for (int j = 0; j < sign.length; j++) {
                //if value equals X or Y, add one counter
                if (sign[i][j].equals(XO)) {
                    xOsign++;
                }
                //if counter reaches 3 bounds, method return true
                if (xOsign == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    //check the sign[][] for vertical
    private boolean verticalCheck(String XO) {
        for (int i = 0; i < sign.length; i++) {
            //basic counter for repeats
            int xOsign = 0;
            for (int j = 0; j < sign.length; j++) {
                //if value equals X or Y, add one counter
                if (sign[j][i].equals(XO)) {
                    xOsign++;
                }
                //if counter reaches 3 bounds, method return true
                if (xOsign == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    //check the sign[][] for diagonals bounds
    private boolean diagonalCheck(String XO) {
        out.println(sign[0][0]);
        if (sign[0][0].contains(XO) == true
                && sign[1][1].contains(XO) == true
                && sign[2][2].contains(XO) == true) {
            return true;
        }
        if (sign[2][0].contains(XO) == true
                && sign[1][1].contains(XO) == true
                && sign[0][2].contains(XO) == true) {
            return true;
        }
        return false;
    }

    //gameStatus check
    private boolean gameStatus() {
        if (horizontalCheck("X") == true || horizontalCheck("Y") == true) {
            return true;
        }
        if (verticalCheck("X") == true || verticalCheck("Y") == true) {
            return true;
        }
        if (diagonalCheck("X") == true || diagonalCheck("Y") == true) {
            return true;
        }
        return false;
    }

    //show the showBoard
    private void showBoard(String[][] sign) {
        out.println("x\\y| 1 | 2 | 3 |");
        out.println(" 1 | " + sign[0][0] + " | " + sign[0][1] + " | " + sign[0][2] + " |");
        out.println(" 2 | " + sign[1][0] + " | " + sign[1][1] + " | " + sign[1][2] + " |");
        out.println(" 3 | " + sign[2][0] + " | " + sign[2][1] + " | " + sign[2][2] + " |");
    }

    //assign or not value to final table sign[][]
    private String[][] makeMove(String XO, String cordX, String cordY) {
        //check values if they both integers
        if (isInteger(cordX) == true && isInteger(cordY) == true) {
            //if yes, assign to temporary poles
            int cordXX = Integer.parseInt(cordX);
            int cordYY = Integer.parseInt(cordY);
            //another check for valid values
            if (isItValid03(cordXX) == true && isItValid03(cordYY) == true) {
                //if the value equals " ", assign the value
                if ((sign[cordXX - 1][cordYY - 1]).equals(" ")) {
                    sign[cordXX - 1][cordYY - 1] = XO;
                    //otherwise return null
                } else return null;
            } else return null;
        } else return null;
        //return sign[][]
        return sign;
    }

    //get User input
    private String getMove() {
        String move = sc.nextLine();
        return move;
    }

    //basic validator for Integer
    private boolean isInteger(String num) {
        if (num == null) {
            return false;
        }
        try {
            //Determine if given number is an Integer. If not return false.
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    //basic validator if number is between 1-3
    private boolean isItValid03(int num) {
        if (num >= 1 && num <= 3) {
            return true;
        } else return false;
    }
}
