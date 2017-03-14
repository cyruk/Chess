package chess;
import java.util.Scanner;

public class Chess {
	static String[][] board = new String[9][9];
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String mMove = "";
		String mMove2 = "";
		makeBoard();
		System.out.println();
		System.out.print("move: ");
		mMove = sc.next();
		mMove2 = sc.next();
		move(mMove, mMove2);
		
		//Character.getNumericValue(bottom) - 10 = column number
		//abs(sidenumbers - 8) = row number
		sc.close();
	}
	
	public static void makeBoard()
	{
		int count = 8;
		int count2 = 10;
		//row
		for(int i = 0; i < 9; i++)
		{
			//column
			for(int j = 0; j < 9; j++)
			{
				if (i ==0 || i == 7)
				{
					if (j == 0 || j == 7)
					{
						if (i == 0)
						{
							board[i][j] = "bR";
						}
						else
						{
							board[i][j] = "wR";
						}
					}
					else if(j == 1 || j == 6)
					{
						if (i == 0)
						{
							board[i][j] = "bN";
						}
						else
						{
							board[i][j] = "wN";
						}
					}
					else if (j == 2 || j == 5)
					{
						if (i == 0)
						{
							board[i][j] = "bB";
						}
						else
						{
							board[i][j] = "wB";
						}
					}
					else if (j == 3)
					{
						if (i == 0)
						{
							board[i][j] = "bQ";
						}
						else
						{
							board[i][j] = "wQ";
						}
					}
					else if (j == 4)
					{
						if (i == 0)
						{
							board[i][j] = "bK";
						}
						else
						{
							board[i][j] = "wK";
						}
					}
				}
				if ((i == 1 || i == 6) && j < 8)
				{
					if(i == 1)
					{
						board[i][j] = "bp";
					}
					else
					{
						board[i][j] = "wp";
					}
				}
				if (j == 8 && i < 8)
				{
					board[i][j] = Integer.toString(count);
					count--;
				}
				if (i == 8 && j < 8)
				{
					char d = Character.forDigit(count2, 36);
					String asdf = Character.toString(d);
					board[i][j] = " " + asdf;
					count2++;
				}
				if (i >= 2 && i <= 5 && j < 8)
				{
					if ((j % 2 == 1 && i % 2 == 0) || (j % 2 == 0 && i % 2 == 1))
					{
						board[i][j] = "##";
					}
					else
					{
						board[i][j] = "  ";
					}
				}
				board[8][8] = "";
				if (j == 0 && i != 0)
				{
					System.out.println();
				}
				System.out.print(board[i][j] + " ");	
			}
		}
	}
	
	public static void move(String start, String move)
	{
		int row;
		int column;
		column = Character.getNumericValue(start.charAt(0)) - 10;
		row = Math.abs(Character.getNumericValue(start.charAt(1)) - 8);
		System.out.println(board[row][column]);
	}
	
	public static void knight()
	{
		
	}
	
	public static void bishop()
	{
		
	}
}
