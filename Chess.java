package samp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Shah on 3/9/2017.
 */
public class Chess {

    public static void main(String[] args) throws IOException{

        Board br = new Board();
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean draw = false;
        boolean whiteTurn = true;
        boolean moveValue;
        br.toString();
        while (true){
            if(whiteTurn == true) {
                //System.out.print("White's move: ");
            	System.out.printf( "White's move:" );
            }
            else{
                //System.out.print("Blacks's move: ");
            	System.out.printf( "Black's move:" );
            }
            input = sc.nextLine();
            if(input.toLowerCase().equals("resign")){
                break;
            }
            else if(input.length() == 11){
                if(input.substring(6,11).equals("draw?")){
                    draw = true;
                }
            }
            else{
            	moveValue = game.move(br,input);
            	if(moveValue == false){
            		System.out.println("Invalid move try again");
            	}
            	
            	else{
            		whiteTurn = changeTurn(whiteTurn);
            		br.toString();
            	}
           }
       }
    }
    public static boolean changeTurn(boolean whiteTurn){
        if(whiteTurn==true){
            return false;
        }
        return true;
    }
}
