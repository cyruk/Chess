package chess;

public class Empty extends Piece{
    public char color;
    public boolean ePos;
    public String name;

    public Empty(String hello)
    {
    	this.name = hello;
    	this.color = ' ';
    	this.ePos = false;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public char getColor()
    {
    	return color;
    }
}
