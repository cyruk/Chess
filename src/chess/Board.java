package chess;

/**
 * Created by Shah on 3/9/2017.
 */
public class Board  
{
    Piece[][] board = new Piece[9][9];
    int[] wKing = {7, 4};
    int[] bKing = {0, 4};

    public Board()
    {
        String[] numbers = {"1", "2","3","4","5", "6","7","8"};
        String[] letters = {"a", "b","c","d","e", "f","g","h"};
        Piece wp1 = new Pawn('w',"wp");
        Piece wp2 = new Pawn('w',"wp");
        Piece wp3 = new Pawn('w',"wp");
        Piece wp4 = new Pawn('w',"wp");
        Piece wp5 = new Pawn('w',"wp");
        Piece wp6 = new Pawn('w',"wp");
        Piece wp7 = new Pawn('w',"wp");
        Piece wp8 = new Pawn('w',"wp");
        Piece wR1 = new Rook('w',"wR");
        Piece wR2 = new Rook('w',"wR");
        Piece wK = new King('w',"wK");
        Piece wB1 = new Bishop('w',"wB");
        Piece wB2 = new Bishop('w',"wB");
        Piece wN1 = new Knight('w',"wN");
        Piece wN2 = new Knight('w',"wN");
        Piece wQ = new Queen('w',"wQ");
        board[6][0] = wp1;
        board[6][1] = wp2;
        board[6][2] = wp3;
        board[6][3] = wp4;
        board[6][4] = wp5;
        board[6][5] = wp6;
        board[6][6] = wp7;
        board[6][7] = wp8;
        board[7][0] = wR1;
        board[7][1] = wN1;
        board[7][2] = wB1;
        board[7][3] = wQ;
        board[7][4] = wK;
        board[7][5] = wB2;
        board[7][6] = wN2;
        board[7][7] = wR2;

        Piece bp1 = new Pawn('b',"bp");
        Piece bp2 = new Pawn('b',"bp");
        Piece bp3 = new Pawn('b',"bp");
        Piece bp4 = new Pawn('b',"bp");
        Piece bp5 = new Pawn('b',"bp");
        Piece bp6 = new Pawn('b',"bp");
        Piece bp7 = new Pawn('b',"bp");
        Piece bp8 = new Pawn('b',"bp");
        Piece bR1 = new Rook('b',"bR");
        Piece bR2 = new Rook('b',"bR");
        Piece bK = new King('b',"bK");
        Piece bB1 = new Bishop('b',"bB");
        Piece bB2 = new Bishop('b',"bB");
        Piece bN1 = new Knight('b',"bN");
        Piece bN2 = new Knight('b',"bN");
        Piece bQ = new Queen('b',"bQ");
        board[1][0] = bp1;
        board[1][1] = bp2;
        board[1][2] = bp3;
        board[1][3] = bp4;
        board[1][4] = bp5;
        board[1][5] = bp6;
        board[1][6] = bp7;
        board[1][7] = bp8;
        board[0][0] = bR1;
        board[0][1] = bN1;
        board[0][2] = bB1;
        board[0][3] = bQ;
        board[0][4] = bK;
        board[0][5] = bB2;
        board[0][6] = bN2;
        board[0][7] = bR2;

        for(int i = 2;i < 6;i++)
        {
            for(int j = 0;j<8;j++)
            {
                board[i][j] = new Empty("  ");
            }
        }
        board[8][8] = new Empty(" ");
        int x = 7;
        for(int i = 0;i<8;i++)
        {
            board[i][8]= new Empty(numbers[x]);
            x--;
        }
        x = 0;
        for(int i = 0;i<8;i++)
        {
            board[8][i]= new Empty(" " + letters[x]);
            x++;
        }
    }

    public String toString(){
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
	            System.out.print(board[i][j].getName() + " ");
            }
            System.out.println();
        }
        return "";
    }
    
    public String check(int row1, int col1)
    {
    	int row2, col2;
    	if(board[row1][col1].getColor() == 'w')
    	{
    		row2 = bKing[0];
    		col2 = bKing[1];
    	}
    	else
    	{
    		row2 = wKing[0];
    		col2 = wKing[1];
    	}
    	String k = board[row1][col1].isValid(row1, col1, row2, col2, board);
    	return k;
    }
    
    public String checkMate(int row1, int col1)
    {
    	char color = board[row1][col1].getColor();
    	char kingColor;
    	
    	//want the opposite king of the piece
    	if (color == 'w')
    	{
    		kingColor = 'b';
    	}
    	else
    	{
    		kingColor = 'w';
    	}
    	
    	int[] hello = findLegal(color);
    	boolean[] checks = new boolean[9];
    	
    	//loop through the board
    	for(int i = 0; i < 8; i++)
    	{
    		for(int j = 0; j < 8; j++)
    		{
    			//find pieces that are same color
    			if (color == board[i][j].getColor())
    			{
    				//loop through the legal moves the king has and check if the piece can move that the legal moves
    				for(int w = 0; w < 16; w+=2)
    				{
    					
    				}
    			}
    		}
    	}
    	
    	return null;
    }
    
    //find the legal moves of the king COMPLETE THIS
    public int[] findLegal(char color)
    {
    	int [] hello = new int[16];
    	int row1, col1;
    	//want the opposite of the piece color
    	if (color == 'w')
    	{
    		row1 = bKing[0];
    		col1 = bKing[1];
    	}
    	else
    	{
    		row1 = wKing[0];
    		col1 = wKing[1];
    	}
    	
    	//checks if it will be out of bounds
    	if (row1 + 1 < 8 & col1 + 1 < 8)
    	{
	    	//checks if the king can move to a certain position 
	    	if (board[row1][col1].isValid(row1, col1, row1 + 1, col1 + 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 - 1;
	    		hello[1] = col1 - 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	
    	if (row1 - 1 > 0 & col1 - 1 > 0)
    	{
	    	if (board[row1][col1].isValid(row1, col1, row1 - 1, col1 - 1, board).equals("yes"))
	    	{
	    		hello[0] = row1 + 1;
	    		hello[1] = col1 + 1;
	    	}
	    	else
	    	{
	    		hello[0] = -1;
	    		hello[1] = -1;
	    	}
    	}
    	return hello;
    }
    
    public String getValid(int row1, int col1, int row2, int col2)
    {
    	return  board[row1][col1].isValid(row1, col1, row2, col2, board);
    }
    
    public char getColor(int i, int j)
    {
    	return board[i][j].getColor();
    }
    
    public void changePieces(int row, int col, int row2, int col2)
    {
    	board[row2][col2] = board[row][col];
    	board[row][col] = new Empty("  ");
    	if(board[row2][col2] instanceof King)
    	{
    		if (board[row2][col2].getColor() == 'w')
    		{
    			wKing[0] = row2;
    			wKing[1] = col2;
    		}
    		else
    		{
    			bKing[0] = row2;
    			bKing[1] = col2;
    		}
    	}
    }
}