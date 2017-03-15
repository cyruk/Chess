package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/8/2017.
 */
public class Game  {

    public Game(){
    }
    public Board move(Board br, String cr) throws IOException{
        int[] cor;
        int row1,col1,row2,col2;
        cor = convert(cr);
        Piece[] tmp = new Piece[1];
        row1 = cor[0];
        col1 = cor[1];
        row2 = cor[2];
        col2 = cor[3];
        System.out.println(row1+ "," + col1 + "-->" + row2 + "," + col2);
        String moveDetails = br.board[row1][col1].isValid(row1,col1,row2,col2,br);
        if(br.board[row1][col1].getClass().isInstance(new Pawn())) {
            if (moveDetails.equals("Yes")) {
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
            }
            else if (moveDetails.equals("Epos") && br.board[row1][col1].getColor().equals("White")) {
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
                br.board[row2 + 1][col2] = new Empty("##");
            }
            else if (moveDetails.equals("Epos") && br.board[row1][col1].getColor().equals("Black")) {
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
                br.board[row2 - 1][col2] = new Empty("##");
            }
            else if (moveDetails.equals("Kill")) {
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = new Empty("##");
            }
            else if (moveDetails.equals("KP") || moveDetails.equals("Pro")) {
                br.board[row2][col2] = new Queen("White", "wQ");
                br.board[row1][col1] = new Empty("##");
            }
        }
        else if(br.board[row1][col1].getClass().isInstance(new Rook())) {
            if(moveDetails.equals("FreeMove")){
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
                br.board[row2][col2].moved =true;
            }
            else if(moveDetails.equals("Kill")){
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = new Empty("##");
                br.board[row2][col2].moved =true;
            }
        }
        else if(br.board[row1][col1].getClass().isInstance(new Bishop())){
            if(moveDetails.equals("FreeMove")){
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
            }
            else if(moveDetails.equals("Kill")){
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = new Empty("##");
            }
        }
        else if(br.board[row1][col1].getClass().isInstance(new Knight())){
            if(moveDetails.equals("FreeMove")){
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
            }
            else if(moveDetails.equals("Kill")){
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = new Empty("##");
            }
        }
        else if(br.board[row1][col1].getClass().isInstance(new Queen())){
            if(moveDetails.equals("FreeMove")){
                tmp[0] = br.board[row2][col2];
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = tmp[0];
            }
            else if(moveDetails.equals("Kill")){
                br.board[row2][col2] = br.board[row1][col1];
                br.board[row1][col1] = new Empty("##");
            }
        }
        return br;
    }

    public int[] convert(String cdt){
        //  br = game.move(br,"a7 b5");
        int[] cor = new int[4];
        int[] rows = {7,6,5,4,3,2,1,0};
        int row = Character.getNumericValue(cdt.charAt(1));
        cor[0] = rows[row-1];
        switch (cdt.charAt(0)){
            case 'a':
                cor[1]=0;
                break;
            case 'b':
                cor[1]=1;
                break;
            case 'c':
                cor[1]=2;
                break;
            case 'd':
                cor[1]=3;
                break;
            case 'e':
                cor[1]=4;
                break;
            case 'f':
                cor[1]=5;
                break;
            case 'g':
                cor[1]=6;
                break;
            case 'h':
                cor[1]=7;
                break;
        }
        int row2 = Character.getNumericValue(cdt.charAt(4));
        cor[2] = rows[row2-1];

        switch (cdt.charAt(3)){
            case 'a':
                cor[3]=0;
                break;
            case 'b':
                cor[3]=1;
                break;
            case 'c':
                cor[3]=2;
                break;
            case 'd':
                cor[3]=3;
                break;
            case 'e':
                cor[3]=4;
                break;
            case 'f':
                cor[3]=5;
                break;
            case 'g':
                cor[3]=6;
                break;
            case 'h':
                cor[3]=7;
                break;
        }
        return  cor;
    }
    public Board swap(Board br, int row1, int col1, int row2, int col2) throws IOException{
        Piece[] tmp = new Piece[1];
        tmp[0] =br.board[row2][col2];
        br.board[row2][col2] = br.board[row1][col1];
        br.board[row1][col1] = tmp[0];
        br.board.toString();
        return br;
    }
}
