package chess;
import java.util.Scanner;
import java.io.IOException;

public class Chess {

	public static void main(String args[])
	{
		Scanner hello = new Scanner(System.in);
		char winner = ' ';
		Game newGame = new Game();
		Player white = new Player('w');
		Player black = new Player('b');
		int turn = 1;
		String move = "";
		newGame.makeBoard();
		System.out.println();
		while(winner == ' ')
		{
			if (turn % 2 != 0)
			{
				System.out.print("white's move: ");
				move = hello.nextLine();
				System.out.println(newGame.move(white, move));
				System.out.println();
				newGame.makeBoard();
				System.out.println();
			}
			else
			{
				System.out.print("black's move: ");
				move = hello.nextLine();
				newGame.move(black, move);
				System.out.println();
				newGame.makeBoard();
				System.out.println();
			}
			turn++;
		}
	}
}
