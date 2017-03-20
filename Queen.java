package chess;

public class Queen extends Piece{
	public char color;
    public String name;

    public Queen(char color, String name)
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
