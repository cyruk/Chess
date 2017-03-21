package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/9/2017.
 */
public class Knight extends Piece {
    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;
    public int id;

    public Knight(String color, String name,int id){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
        this.id = id;
    }
    public Knight(){}
    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        boolean properMove = properMove(row1,col1,row2,col2);
        String cl = br.board[row1][col1].getColor();
        if(properMove == false){
            return "No";
        }
        else{
            if(br.board[row2][col2].getClass().isInstance(new Empty())){
                return "FreeMove";
            }
            else if(br.board[row2][col2].getColor().equals(cl)){
                return "No";
            }
        }
        return "Kill";
    }

    public boolean properMove(int row1, int col1, int row2, int col2){
        if(row2 ==row1-2 && col2 == col1-1){
            return true;
        }
        else if(row2 ==row1-1 && col2 == col1-2){
            return true;
        }
        else if(row2 ==row1-2 && col2 == col1+1){
            return true;
        }
        else if(row2 ==row1-1 && col2 == col1+2){
            return true;
        }
        else if(row2 ==row1+1 && col2 == col1+2){
            return true;
        }
        else if(row2 ==row1+2 && col2 == col1+1){
            return true;
        }
        else if(row2 ==row1+2 && col2 == col1-1){
            return true;
        }
        else if(row2 ==row1+1 && col2 == col1-2){
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }
    public String getColor(){return color;}
    public int getId(){
        return id;
    }
}
