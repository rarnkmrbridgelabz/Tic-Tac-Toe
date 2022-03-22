package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[10];
    static char player1,computer;

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Workshop");

        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
            System.out.println(board[i]);
        }
        choise();
        showBoard();
        toss();
        int move = userMove();
        checkFreeSpace(move);
    }
    public  static void choise() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a Letter X or O:");
            player1 = sc.next().charAt(0);
            if (player1 == 'X' || player1 == 'x') {
                player1 = 'X';
                computer = 'O';
            } else {
                player1 = 'O';
                computer = 'X';
            }
            System.out.println("Player1 Chosen Letter is: " + player1);
            System.out.println("Computer Chosen Letter is: " + computer);
        }


    public static void showBoard() {
        for (int i = 1; i < board.length; i=i+3) {
            System.out.println("|_"+board[i]+"_|_" + board[i + 1]+"_|_" + board[i + 2]+"_|");
        }
    }

    public static int userMove() {
        System.out.println("Make a move by selecting any board index position from 1 to 9:");
        Scanner sc = new Scanner(System.in);
        int move = sc.nextInt();
        return move;
    }
    public static void checkFreeSpace(int move){
        if(board[move]== ' '){
            board[move]= player1;
        }
        else{
            System.out.println("Space already Occupied,Select anyother board index position from 1 to 9:");
            move=userMove();
            checkFreeSpace(move);
        }
    }
    public static void toss(){
        int coin = (int) (Math.random()*2);
        if(coin == 1){
            System.out.println("Player 1 won the Toss and start:");
        }
        else{
            System.out.println("Computer won the Toss and start:");
        }
    }

}



