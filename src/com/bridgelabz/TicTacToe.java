package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Workshop");
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] =' ';
            System.out.println(board[i]);
        }
        char player1 = choise();
        char computer;
        if (player1 == 'X'||player1=='x') {
            player1 = 'X';
            computer = 'O';
        } else {
            player1 = 'O';
            computer = 'X';
        }
        System.out.println("Player1 Chosen Letter is: " + player1);
        System.out.println("Computer Chosen Letter is: " + computer);
        showBoard(board);
    }

    public static char choise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Letter X or O:");
        char p1 = sc.next().charAt(0);
        return p1;
    }
    public static void showBoard(char[] board) {
        for (int i = 1; i < board.length; i=i+3) {
            System.out.println("|_"+board[i]+"_|_" + board[i + 1]+"_|_" + board[i + 2]+"_|");
        }
    }
}



