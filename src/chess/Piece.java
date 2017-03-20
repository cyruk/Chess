package chess;

/**
 * Created by Shah on 3/1/2017.
 */
public class Piece{

    public char color;
    public boolean ePos;
    public String name;

    public String getName(){
        return name;
    }
    
    public char getColor()
    {
    	return color;
    }

	public String isValid(int row1, int col1, int row2, int col2, Piece[][] board) {
		// TODO Auto-generated method stub

			System.out.println("hello");
		return null;
	}
	
	public int[] returnSlope(int row1, int col1, int row2, int col2)
	{
		return null;
	}
}
