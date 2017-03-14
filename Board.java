package samp;

/**
 * Created by Shah on 3/9/2017.
 */
public class Board  {
    Piece[][] board = new Piece[9][9];

    public Board(){
        String[] numbers = {"1", "2","3","4","5", "6","7","8"};
        String[] letters = {"a", "b","c","d","e", "f","g","h"};
        Pawn wp1 = new Pawn("White","wp");
        Pawn wp2 = new Pawn("White","wp");
        Pawn wp3 = new Pawn("White","wp");
        Pawn wp4 = new Pawn("White","wp");
        Pawn wp5 = new Pawn("White","wp");
        Pawn wp6 = new Pawn("White","wp");
        Pawn wp7 = new Pawn("White","wp");
        Pawn wp8 = new Pawn("White","wp");
        Rook wR1 = new Rook("White","wR");
        Rook wR2 = new Rook("White","wR");
        King wK = new King("White","wK");
        Bishop wB1 = new Bishop("White","wB");
        Bishop wB2 = new Bishop("White","wB");
        Knight wN1 = new Knight("White","wN");
        Knight wN2 = new Knight("White","wN");
        Queen wQ = new Queen("White","wQ");
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

        Pawn bp1 = new Pawn("Black","bp");
        Pawn bp2 = new Pawn("Black","bp");
        Pawn bp3 = new Pawn("Black","bp");
        Pawn bp4 = new Pawn("Black","bp");
        Pawn bp5 = new Pawn("Black","bp");
        Pawn bp6 = new Pawn("Black","bp");
        Pawn bp7 = new Pawn("Black","bp");
        Pawn bp8 = new Pawn("Black","bp");
        Rook bR1 = new Rook("Black","bR");
        Rook bR2 = new Rook("Black","bR");
        King bK = new King("Black","bK");
        Bishop bB1 = new Bishop("Black","bB");
        Bishop bB2 = new Bishop("Black","bB");
        Knight bN1 = new Knight("Black","bN");
        Knight bN2 = new Knight("Black","bN");
        Queen bQ = new Queen("Black","bQ");
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
                if(isHash(i,j))
                    board[i][j] = new Empty("##");
                else if (isHash(i,j)==false){
                    board[i][j] = new Empty("");
                }
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
                if(board[i][j].getClass().isInstance(new Empty())) {
                    if(isHash(i,j))
                        board[i][j].setName("##");
                    else if(isHash(i,j)==false &&isNumOrLetter(board[i][j].getName())==false) {
                        board[i][j].setName("");
                    }
                    System.out.printf("%-3s", board[i][j].getName());
                }
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

    public boolean isHash(int row, int col){
        if (row == 8 || col == 8){
            return false;
        }
        if (row % 2 == 0){
            if (col % 2 != 0){
                return true;
            }
        }
        else if (row % 2 != 0){
            if (col % 2 == 0){
                return true;
            }
        }
        return false;
    }
    public boolean isNumOrLetter(String str){
        if(str.isEmpty()){
            return false;
        }
        char c = str.charAt(0);
        if(Character.isLetter(c)|| Character.isDigit(c)){
            return true;
        }
        return false;
    }
}