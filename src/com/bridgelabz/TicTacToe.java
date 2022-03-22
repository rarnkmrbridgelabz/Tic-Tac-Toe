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
        showBoard();
        userMove();
        checkResult();
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
        System.out.println("Select the index from 1 to 9 to make th move for "+turn);
        Scanner sc = new Scanner(System.in);
        int move = sc.nextInt();
        isSpaceFree(move);
    }

    public static void isSpaceFree(int move){
        if (board[move] == ' ') {
            board[move] = player1;
        }
        else {
            System.out.println("Selected space is already occupied, select some other index");
            userMove();
        }
    }

    public static void toss(){
        int coin = (int) (Math.random()*2);
        if (coin == 1) {
            System.out.println("Player1 will start first");
            turn = player1;
        }
        else {
            System.out.println("Computer will start first");
            turn = computer;
        }
    }

    public static void checkResult(){
        // first check if any cell is blank
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' '){
                //System.out.println("Change the turn");
                isEnd = 0;
                //Changing the turn
                if (turn == player1)
                    turn = computer;
                else
                    turn = player1;
                break;
            }
        }
        //check who won or is tie
        int isTie = 1;
        if (isEnd == 1) {
            //horizontal winning positions
            for (int i = 1; i < board.length; i = i + 3) {
                if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                    if (board[i] == player1)
                        System.out.println("Player1 won");
                    else
                        System.out.println("Computer won");
                    isTie = 0;
                    break;
                }
            }
            //vertical winning positions
            for (int i = 1; i < 4; i++) {
                if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                    if (board[i] == player1)
                        System.out.println("Player1 won");
                    else
                        System.out.println("Computer won");
                    isTie = 0;
                    break;
                }
            }
            //diagonal winning position
            if (board[1] == board[5] && board[5] == board[9] ||
                    board[3] == board[5] && board[5] == board[7]) {
                if (board[1] == player1 || board[3] == player1)
                    System.out.println("Player1 won");
                else
                    System.out.println("Computer won");
                isTie = 0;
            }
            if (isTie==1) {
                System.out.println("Game Tie");
            }
        }
    }

}



