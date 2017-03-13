package samp;

/**
 * Created by Shah on 3/9/2017.
 */
public class Board  {
    Piece[][] board = new Piece[9][9];

    public Board(){
        String[] numbers = {"1", "2","3","4","5", "6","7","8"};
        String[] letters = {"a", "b","c","d","e", "f","g","h"};
        Piece wp1 = new Pawn("White","wp");
        Piece wp2 = new Pawn("White","wp");
        Piece wp3 = new Pawn("White","wp");
        Piece wp4 = new Pawn("White","wp");
        Piece wp5 = new Pawn("White","wp");
        Piece wp6 = new Pawn("White","wp");
        Piece wp7 = new Pawn("White","wp");
        Piece wp8 = new Pawn("White","wp");
        Piece wR1 = new Rook("White","wR");
        Piece wR2 = new Rook("White","wR");
        Piece wK = new King("White","wK");
        Piece wB1 = new Bishop("White","wB");
        Piece wB2 = new Bishop("White","wB");
        Piece wN1 = new Knight("White","wN");
        Piece wN2 = new Knight("White","wN");
        Piece wQ = new Queen("White","wQ");
        board[6][0] = wp1;
        board[6][1] = wp2;
        board[6][2] = wp3;
        board[6][3] = wp4;
        board[6][4] = wp5;
        board[6][5] = wp6;
        board[6][6] = wp7;
        board[6][7] = wp8;
        board[7][0] = wR1;
        board[7][1] = wN1;
        board[7][2] = wB1;
        board[7][3] = wQ;
        board[7][4] = wK;
        board[7][5] = wB2;
        board[7][6] = wN2;
        board[7][7] = wR2;

        Piece bp1 = new Pawn("Black","bp");
        Piece bp2 = new Pawn("Black","bp");
        Piece bp3 = new Pawn("Black","bp");
        Piece bp4 = new Pawn("Black","bp");
        Piece bp5 = new Pawn("Black","bp");
        Piece bp6 = new Pawn("Black","bp");
        Piece bp7 = new Pawn("Black","bp");
        Piece bp8 = new Pawn("Black","bp");
        Piece bR1 = new Rook("Black","bR");
        Piece bR2 = new Rook("Black","bR");
        Piece bK = new King("Black","bK");
        Piece bB1 = new Bishop("Black","bB");
        Piece bB2 = new Bishop("Black","bB");
        Piece bN1 = new Knight("Black","bN");
        Piece bN2 = new Knight("Black","bN");
        Piece bQ = new Queen("Black","bQ");
        board[1][0] = bp1;
        board[1][1] = bp2;
        board[1][2] = bp3;
        board[1][3] = bp4;
        board[1][4] = bp5;
        board[1][5] = bp6;
        board[1][6] = bp7;
        board[1][7] = bp8;
        board[0][0] = bR1;
        board[0][1] = bN1;
        board[0][2] = bB1;
        board[0][3] = bQ;
        board[0][4] = bK;
        board[0][5] = bB2;
        board[0][6] = bN2;
        board[0][7] = bR2;

        for(int i = 2;i <6;i++){
            for(int j = 0;j<8;j++){
                board[i][j] = new Empty("");
            }
        }
        board[8][8] = new Empty("");
        int x = 7;
        for(int i = 0;i<8;i++){
            board[i][8]= new Empty(numbers[x]);
            x--;
        }
        x = 0;
        for(int i = 0;i<8;i++){
            board[8][i]= new Empty(letters[x]);
            x++;
        }
    }

    public String toString(){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(i == 2 || i == 3||i==4||i==5)
                    System.out.printf("%-3s",board[i][j].getName());
                else if(i == 8){

                    System.out.printf("%-3s",board[i][j].getName());
                }
                else
                    System.out.print(board[i][j].getName() + " ");
            }
            System.out.println();
        }
        return "";
    }




}