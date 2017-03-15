package samp;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Shah on 3/2/2017.
 */
public class Rook extends Piece {
    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;

    public Rook(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }
    public Rook(){}

    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        String dir = direction(row1,col1,row2,col2);
        String cl = br.board[row1][col1].getColor();
        System.out.println(dir);
        int i;
        if(dir.equals("invalid")){
            System.out.println("Diagonal move");
            return "No";
        }
        //System.out.println(dir);
        else if(dir.equals("nor")){
            for(i = row1-1;i>row2;i--){
                if(!(br.board[i][col2].getClass().isInstance(new Empty()))){
                    return "No";
                }
            }
        }
        else if(dir.equals("sou")){
            for(i = row1+1;i<row2;i++){
                if(!(br.board[i][col2].getClass().isInstance(new Empty()))){
                    return "No";
                }
            }
        }
        else if(dir.equals("ea")){
            for(i = col1+1;i<col2;i++){
                if(!(br.board[row2][i].getClass().isInstance(new Empty()))){
                    return "No";
                }
            }
        }
        else if(dir.equals("we")){
            for(i = col1-1;i>col2;i--){
                if(!(br.board[row2][i].getClass().isInstance(new Empty()))){
                    return "No";
                }
            }
        }
        if((br.board[row2][col2].getClass().isInstance(new Empty()))) {
            return "FreeMove";
        }
        else if(br.board[row2][col2].getColor().equals(cl)){
            return "No";
        }
        return "Kill";
    }

    public String direction(int row1,int col1, int row2, int col2){
        if(col1-col2 !=0 && row1-row2!=0){
            return "invalid";
        }
        if(col1-col2!=0){
            if(col1-col2 <0){
                return "ea";
            }
            else if(col1-col2>0){
                return "we";
            }
        }
        else if(row1-row2 != 0){
            if(row1-row2 >0){
                return "nor";
            }
            else if(row1-row2<0){
                return "sou";
            }
        }
        return "invalid";
    }
    public String getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
