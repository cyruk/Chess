package chess;

public class Bishop {
	public String color;
    public boolean ePos;
    public String name;

    public Bishop(String color, boolean ePos, String name)
    {
    	this.color = color;
    	this.ePos = ePos;
    	this.name = name;
    }
	public String isValid(int col1, int row1, int col2, int row2, Piece[][] board)
    {
		int outLoop = 0;
		int inLoop = 0;
		if(board[row1][col1].color == board[row2][col2].color)
		{
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
				for(int i = min1; i < max1; i++)
				{
					holder += outLoop;
					holder1 += inLoop;
					//is empty or something
					if(!(board[holder][holder1].equals("")||board[holder][holder1].equals("##")))
					{
						return "No";
					}
				}
				board[row2][col2] = board[row1][col1];
				//make it empty
				//board[row1][col1] = "";
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
