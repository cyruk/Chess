package chess;

public class Knight extends Piece{
	public String color;
    public boolean ePos;
    public String name;

    public Knight(String color, boolean ePos, String name)
    {
    	this.color = color;
    	this.ePos = ePos;
    	this.name = name;
    }
    
    public String isValid(int col1, int row1, int col2, int row2, Piece[][] board)
    {
		if(board[row1][col1].color == board[row2][col2].color)
		{
			return "No";
		}
		else
		{
			if(Math.abs(row1 - row2) == 1 && Math.abs(col1 - col2) == 2 || Math.abs(row1 - row2) == 2 && Math.abs(col1 - col2) == 1)
			{
				board[row1][col1] = board[row2][col2];
				//make it empty
				//board[row1][col1] = emptysomething;
				return "Yes";
			}
			else
			{
				return "No";
			}
		}
    }
    
    public String getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
