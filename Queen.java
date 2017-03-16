package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/9/2017.
 */
public class Queen extends Piece {

    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;
    public int id;

    public Queen(String color, String name, int id){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
        this.id = id;
    }
    public Queen(){}
    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        if(rook.isValid(row1,col1,row2,col2,br).equals("No") && bishop.isValid(row1,col1,row2,col2,br).equals("No")){
            return "No";
        }
        else if(rook.isValid(row1,col1,row2,col2,br).equals("FreeMove") || bishop.isValid(row1,col1,row2,col2,br).equals("FreeMove")){
            return "FreeMove";
        }
        else if(rook.isValid(row1,col1,row2,col2,br).equals("Kill") || bishop.isValid(row1,col1,row2,col2,br).equals("Kill")){
            return "Kill";
        }
        return "No";
    }

    public String getName(){
        return name;
    }
    public String getColor(){return color;}
    public int getId(){
        return id;
    }
}