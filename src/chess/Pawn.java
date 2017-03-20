package chess;

public class Pawn extends Piece{
	public char color;
    public String name;

    public Pawn(char color, String name)
    {
    	this.color = color;
    	this.name = name;
    }
    
    public char getColor(){
        return color;
    }
    
    public String isValid(int row1, int col1, int row2, int col2, Piece[][] board)
    {
  
		if(board[row1][col1].getColor() == board[row2][col2].getColor())
		{
			System.out.println(board[row1][col1].getName());
			System.out.println(board[row2][col2].getName());
			return "No";
		}
		else
		{
			if(Math.abs(row1 - row2) == 1 && col1 - col2 == 0)
			{
				board[row2][col2] = board[row1][col1];
				board[row1][col1] = new Empty("  ");
				return "Yes";
			}
			else
			{
				return "No";
			}
		}
    }

    public String getName(){
        return name;
    }
}
