package chess;

public class Knight extends Piece{
	public char color;
    public String name;

    public Knight(char color, String name)
    {
    	this.color = color;
    	this.name = name;
    }
    
    public String isValid(int row1, int col1, int row2, int col2, Piece[][] board)
    {
  
		if(board[row1][col1].getColor() == board[row2][col2].getColor())
		{
			return "No";
		}
		else
		{
			if(Math.abs(row1 - row2) == 1 && Math.abs(col1 - col2) == 2 || Math.abs(row1 - row2) == 2 && Math.abs(col1 - col2) == 1)
			{
				return "Yes";
			}
			else
			{
				return "No";
			}
		}
    }
    
    public char getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
