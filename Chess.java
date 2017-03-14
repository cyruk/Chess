package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/9/2017.
 */
public class Chess {

    public static void main(String[] args) throws IOException{

        Board br = new Board();
        Game game = new Game();
        //br.toString();
        br = game.swap(br,1,0,4,0);
        //System.out.println();
        //br.toString();
        br = game.swap(br,6,1,4,1);
        System.out.println();
        br.toString();
        br.board[4][1].ePos=true;
        br = game.move(br,"a4 b3");
        System.out.println();
        br.toString();
        br = game.move(br,"b3 b2");
        System.out.println();
        br.toString();
        br = game.move(br,"b2 a1");
        System.out.println();
        br.toString();
//        br = game.move(br,"g6 g7");
//      System.out.println();
        //br.toString();
        /*br = game.move(br,"b6 b7");
        System.out.println();
        br.toString();
        br = game.move(br,"b7 b8");
        System.out.println();
        br.toString();

        br = game.move(br,"b7 c8");
        System.out.println();
        br.toString();*/
    }
}
