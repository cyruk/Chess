package chess;

public class King extends Piece{
	public char color;
    public String name;

    public King(char color, String name)
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
