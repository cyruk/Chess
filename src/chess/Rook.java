package chess;

import java.util.Objects;

/**
 * Created by Shah on 3/2/2017.
 */
public class Rook extends Piece {
	public char color;
    public String name;
	public Rook(char color, String name)
    {
    	this.color = color;
    	this.name = name;
    }
    
    public char getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
