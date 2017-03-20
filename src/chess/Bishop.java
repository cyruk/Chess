package chess;

public class Bishop extends Piece {
	public char color;
    public String name;

    public Bishop(char color, String name)
    {
    	this.color = color;
    	this.name = name;
    }
    
	public String isValid(int row1, int col1, int row2, int col2, Piece[][] board)
    {
		int outLoop = 0;
		int inLoop = 0;
		if(board[row1][col1].getColor() == board[row2][col2].getColor())
		{
			System.out.println("hello3");
			return "No";
		}
		else
		{
			if(Math.abs(row1 - row2) == Math.abs(col1 - col2))
			{
				if (row1 - row2 < 0 && col1 - col2 > 0)
				{
					outLoop = 1;
					inLoop = -1;
				}
				else if (row1 - row2 > 0 && col1 - col2 > 0)
				{
					outLoop = -1;
					inLoop = -1;
				}
				else if (row1 - row2 < 0 && col1 - col2 < 0)
				{
					outLoop = 1;
					inLoop = 1;
				}
				else if (row1 - row2 > 0 && col1 - col2 < 0)
				{
					outLoop = -1;
					inLoop = 1;
				}
				int max1 = Math.max(row1, row2);
				int min1 = Math.min(row1, row2);
				int holder = row1;
				int holder1 = col1;
				for(int i = min1; i < max1 - 1; i++)
				{
					holder += outLoop;
					holder1 += inLoop;
					//is empty or something
					if(!(board[holder][holder1] instanceof Empty))
					{
						System.out.println("hello");
						return "No";
					}
				}
				board[row2][col2] = board[row1][col1];
				board[row1][col1] = new Empty("  ");
				return "Yes";
			}
			else
			{
				System.out.println("hello2");
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
