package samp;

/**
 * Created by Shah on 3/8/2017.
 */
public class Game  {

    public Game(){

    }

    public Board move(Board br, String cr){
        int[] cor;
        cor = convert(cr);
        System.out.println(cor[3]);
        if(br.board[cor[0]][cor[1]] instanceof Pawn){

        }
        return br;
    }

    public int[] convert(String cdt){
        int[] cor = new int[4];
        switch (cdt.charAt(0)){
            case 'a':
                cor[0]=0;
                break;
            case 'b':
                cor[0]=1;
                break;
            case 'c':
                cor[0]=2;
                break;
            case 'd':
                cor[0]=3;
                break;
            case 'e':
                cor[0]=4;
                break;
            case 'f':
                cor[0]=5;
                break;
            case 'g':
                cor[0]=6;
                break;
            case 'h':
                cor[0]=7;
                break;
        }
        int[] rows = {7,6,5,4,3,2,1,0};
        int row = Character.getNumericValue(cdt.charAt(1));
        cor[1] = rows[row-1];
        switch (cdt.charAt(3)){
            case 'a':
                cor[2]=0;
                break;
            case 'b':
                cor[2]=1;
                break;
            case 'c':
                cor[2]=2;
                break;
            case 'd':
                cor[2]=3;
                break;
            case 'e':
                cor[2]=4;
                break;
            case 'f':
                cor[2]=5;
                break;
            case 'g':
                cor[2]=6;
                break;
            case 'h':
                cor[2]=7;
                break;
        }
        int row2 = Character.getNumericValue(cdt.charAt(4));
        cor[3] = rows[row2-1];
        return  cor;


    }




}
