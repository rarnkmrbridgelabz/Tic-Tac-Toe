package com.bridgelabz;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Workshop");
        char[] board = new char[10];
        for(int i=1;i< board.length;i++){
            board[i]=' ';
            System.out.println(board[i]);
        }
    }
}
