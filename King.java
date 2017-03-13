package samp;

/**
 * Created by Shah on 3/8/2017.
 */
public class King extends Piece {
    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;


    public King(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }/*

    public String isValid(int x1, int y1, int x2, int y2, Piece[][] board){
        if(
    }*/

    public String getName(){
        return name;
    }
}
