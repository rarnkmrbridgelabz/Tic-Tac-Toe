package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[10];
    static char player1, computer, turn;
    static int isEnd = 0;
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe workshop");
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        choice();
        toss();
        while (isEnd != 1) {
            if (turn == player1) {
                System.out.println("Player1's turn");
                userMove();
                showBoard();
                checkResult();
            } else {
                System.out.println("Computer's turn");
                winMove();
            }
        }
        gameOver();
        anotherGame();
    }

    public static void choice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select either X or O ");
        player1 = sc.next().charAt(0);
        if (player1 == 'X' || player1 == 'x') {
            player1 = 'X';
            computer = 'O';
        } else {
            player1 = 'O';
            computer = 'X';
        }
        System.out.println("Player1 letter is : " + player1);
        System.out.println("Computer letter is : " + computer);
    }

    public static void showBoard() {
        for (int i = 1; i < board.length; i = i + 3) {
            System.out.println("|" + board[i] + "|" + board[i + 1] + "|" + board[i + 2] + "|");
            System.out.println("|_|_|_|");
        }
    }

    public static void userMove() {
        System.out.println("Select the index from 1 to 9 to make the move ");
        Scanner sc = new Scanner(System.in);
        int move = sc.nextInt();
        isSpaceFree(move);
    }

    public static void isSpaceFree(int move) {
        if (board[move] == ' ') {
            board[move] = player1;
        }
        else {
            System.out.println("Selected space is already occupied, select some other index");
            userMove();
        }
    }

    public static void toss() {
        int coin = (int) (Math.random()*2);
        if (coin == 1) {
            System.out.println("Toss decided Player1 will start first");
            turn = player1;
        }
        else {
            System.out.println("Toss decided Computer will start first");
            turn = computer;
        }
    }

    public static void checkResult() {
        //check if anyone won
        //horizontal winning positions
        for (int i = 1; i < board.length; i = i + 3) {
            if ((board[i] == board[i + 1] && board[i + 1] == board[i + 2]) && board[i] != ' ') {
                if (board[i] == player1)
                    System.out.println("Player1 won");
                else
                    System.out.println("Computer won");
                isEnd = 1;
                break;
            }
        }
        //vertical winning positions
        if (isEnd != 0) {
            for (int i = 1; i < 4; i++) {
                if ((board[i] == board[i + 3] && board[i + 3] == board[i + 6]) && board[i] != ' ') {
                    if (board[i] == player1)
                        System.out.println("Player1 won");
                    else
                        System.out.println("Computer won");
                    isEnd = 1;
                    break;
                }
            }
        }
        //diagonal winning position
        if (isEnd != 1) {
            if ((board[1] == board[5] && board[5] == board[9] ||
                    board[3] == board[5] && board[5] == board[7]) && board[5] != ' ') {
                if (board[5] == player1 )
                    System.out.println("Player1 won");
                else
                    System.out.println("Computer won");
                isEnd = 1;
            }
        }
        // if no winner then check if any cell is blank
        int isBlank = 0;
        if (isEnd != 1) {
            for (int i = 1; i < board.length; i++) {
                if (board[i] == ' ') {
                    System.out.println("Change the turn");
                    //Changing the turn
                    if (turn == player1)
                        turn = computer;
                    else
                        turn = player1;
                    isBlank = 1;
                    break;
                }
            }
        }
        if (isBlank == 0 && isEnd != 1) {
            System.out.println("Game Tie");
            isEnd = 1;
        }
    }

    public static void winMove () {
        int compMove = 0;
        //code for position 1
        if ( ( (board[2] == board[3] && board[2] == computer) ||
                (board[4] == board[7] && board[4] == computer) ||
                (board[5] == board[9] && board[5] == computer) ) && board[1] == ' ') {
            board[1] = computer;
            compMove = 1;
        }
        //code for position 2
        else if ( ( (board[1] == board[3] && board[1] == computer) ||
                (board[5] == board[8] && board[5] == computer) ) && board[2] == ' ') {
            board[2] = computer;
            compMove = 1;
        }
        //code for position 3
        else if ( ( (board[2] == board[3] && board[2] == computer) ||
                (board[4] == board[7] && board[4] == computer) ||
                (board[5] == board[9] && board[5] == computer) ) && board[3] == ' ') {
            board[3] = computer;
            compMove = 1;
        }
        //code for position 4
        else if ( ( (board[1] == board[7] && board[1] == computer) ||
                (board[5] == board[6] && board[5] == computer) ) && board[4] == ' ') {
            board[4] = computer;
            compMove = 1;
        }
        //code for position 5
        else if ( ( (board[2] == board[8] && board[2] == computer) ||
                (board[4] == board[6] && board[4] == computer) ||
                (board[1] == board[9] && board[1] == computer) ||
                (board[3] == board[7] && board[3] == computer)) && board[5] == ' ') {
            board[5] = computer;
            compMove = 1;
        }
        //code for position 6
        else if ( ( (board[4] == board[5] && board[4] == computer) ||
                (board[3] == board[9] && board[3] == computer) ) && board[6] == ' ') {
            board[6] = computer;
            compMove = 1;
        }
        //code for position 7
        else if ( ( (board[1] == board[4] && board[1] == computer) ||
                (board[8] == board[9] && board[8] == computer) ||
                (board[3] == board[5] && board[3] == computer) ) && board[7] == ' ') {
            board[7] = computer;
            compMove = 1;
        }
        //code for position 8
        else if ( ( (board[7] == board[9] && board[7] == computer) ||
                (board[2] == board[5] && board[2] == computer) ) && board[8] == ' ') {
            board[8] = computer;
            compMove = 1;
        }
        //code for position 9
        else if ( ( (board[7] == board[8] && board[7] == computer) ||
                (board[1] == board[5] && board[1] == computer) ||
                (board[3] == board[6] && board[3] == computer) ) && board[9] == ' ') {
            board[9] = computer;
            compMove = 1;
        }
        if (compMove == 1) {
            showBoard();
            checkResult();
        }
        else
            blockMove(compMove);
    }

    public static void blockMove(int compMove) {
        //code for position 1
        if ( ( (board[2] == board[3] && board[2] == player1) ||
                (board[4] == board[7] && board[4] == player1) ||
                (board[5] == board[9] && board[5] == player1) ) && board[1] == ' ') {
            board[1] = computer;
            compMove = 1;
        }
        //code for position 2
        else if ( ( (board[1] == board[3] && board[1] == player1) ||
                (board[5] == board[8] && board[5] == player1) ) && board[2] == ' ') {
            board[2] = computer;
            compMove = 1;
        }
        //code for position 3
        else if ( ( (board[2] == board[3] && board[2] == player1) ||
                (board[4] == board[7] && board[4] == player1) ||
                (board[5] == board[9] && board[5] == player1) ) && board[3] == ' ') {
            board[3] = computer;
            compMove = 1;
        }
        //code for position 4
        else if ( ( (board[1] == board[7] && board[1] == player1) ||
                (board[5] == board[6] && board[5] == player1) ) && board[4] == ' ') {
            board[4] = computer;
            compMove = 1;
        }
        //code for position 5
        else if ( ( (board[2] == board[8] && board[2] == player1) ||
                (board[4] == board[6] && board[4] == player1) ||
                (board[1] == board[9] && board[1] == player1) ||
                (board[3] == board[7] && board[3] == player1)) && board[5] == ' ') {
            board[5] = computer;
            compMove = 1;
        }
        //code for position 6
        else if ( ( (board[4] == board[5] && board[4] == player1) ||
                (board[3] == board[9] && board[3] == player1) ) && board[6] == ' ') {
            board[6] = computer;
            compMove = 1;
        }
        //code for position 7
        else if ( ( (board[1] == board[4] && board[1] == player1) ||
                (board[8] == board[9] && board[8] == player1) ||
                (board[3] == board[5] && board[3] == player1) ) && board[7] == ' ') {
            board[7] = computer;
            compMove = 1;
        }
        //code for position 8
        else if ( ( (board[7] == board[9] && board[7] == player1) ||
                (board[2] == board[5] && board[2] == player1) ) && board[8] == ' ') {
            board[8] = computer;
            compMove = 1;
        }
        //code for position 9
        else if ( ( (board[7] == board[8] && board[7] == player1) ||
                (board[1] == board[5] && board[1] == player1) ||
                (board[3] == board[6] && board[3] == player1) ) && board[9] == ' ') {
            board[9] = computer;
            compMove = 1;
        }
        if (compMove == 1) {
            showBoard();
            checkResult();
        }
        else
            availableCorner(compMove);
    }

    public static void availableCorner(int compMove) {
        if (board[1] == ' ') {
            board[1] = computer;
            compMove = 1;
        }
        else if (board[3] == ' ') {
            board[3] = computer;
            compMove = 1;
        }
        else if (board[7] == ' ') {
            board[7] = computer;
            compMove = 1;
        }
        else if (board[9] == ' ') {
            board[9] = computer;
            compMove = 1;
        }
        if (compMove == 1) {
            showBoard();
            checkResult();
        }
        else
            subsequentChoice();
    }

    public static void subsequentChoice() {
        //Middle position
        if (board[5] == ' ')
            board[5] = computer;
            //All remaining sides
        else if (board[2] == ' ')
            board[2] = computer;
        else if (board[4] == ' ')
            board[4] = computer;
        else if (board[6] == ' ')
            board[6] = computer;
        else if (board[8] == ' ')
            board[8] = computer;
        showBoard();
    }

    public static void gameOver() {
        System.out.println("Game Over");
    }

    public static void anotherGame() {
        System.out.println("Ready for another game \n1.Yes\n2.No");
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 1) {
            for (int i = 1; i < board.length; i++) {
                board[i] = ' ';
            }
            isEnd = 0;
            choice();
            toss();
            while (isEnd != 1) {
                if (turn == player1) {
                    System.out.println("Player1's turn");
                    userMove();
                    showBoard();
                    checkResult();
                } else {
                    System.out.println("Computer's turn");
                    winMove();
                }
            }
            gameOver();
            anotherGame();
        }
        else
            System.out.println("Thank you !");
    }

}



