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

    public Knight(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }
    public String isValid(int row1, int col1, int row2, int col22, Board br) throws IOException {return "";}

    public String getName(){
        return name;
    }
    public String getColor(){return color;}
}
