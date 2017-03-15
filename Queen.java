package samp;

/**
 * Created by Shah on 3/9/2017.
 */
public class Queen extends Piece {

    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;

    public Queen(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }

    public String getName(){
        return name;
    }
}