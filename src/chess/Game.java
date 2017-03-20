package chess;

public class Game  
{
	Board newGame = new Board();
	public Game()
	{
		
	}

	public String move(Player player, String thing)
	{
		System.out.println(thing);
		int[] cord = new int[4];
		cord = convert(thing);
		if (player.getColor() != newGame.getColor(cord[0], cord[1]))
		{
			return "illegal";
		}
		else
		{
			//checks if the move is valid
			if (newGame.getValid(cord[0], cord[1], cord[2], cord[3]).equals("yes"))
			{
				//actually moves the pieces
				newGame.changePieces(cord[0],cord[1],cord[2],cord[3]);
				//checks if this piece can reach the king
				if (newGame.check(cord[2], cord[3]).equals("yes"))
				{
					if (newGame.killCheck(cord[2], cord[3]).equals("yes") || newGame.moveCheck(cord[2], cord[3]).equals("yes"))
					{
						return "check";
					}
					else if (newGame.checkMate(cord[2],cord[3]).equals("yes"))
					{
						return "checkmate";
					}
				}
				
			}
			return null;
		}
	}

	public static int[] convert(String cdt)
	{
		int[] cord = new int[4];
		//row
		cord[0] = Math.abs(Character.getNumericValue(cdt.charAt(1)) - 8);
		//column
		cord[1] = Character.getNumericValue(cdt.charAt(0)) - 10;
		//row
		cord[2] = Math.abs(Character.getNumericValue(cdt.charAt(4)) - 8);
		//column
		cord[3] = Character.getNumericValue(cdt.charAt(3)) - 10;
		return cord;
	}    
	public void makeBoard()
	{
		newGame.toString();
	}

}

