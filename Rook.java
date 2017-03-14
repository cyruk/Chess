package samp;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Shah on 3/2/2017.
 */
public class Rook extends Piece {
    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;

    public Rook(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }

    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        String dir = direction(row1,col1,row2,col2);

        if(dir.equals('i')){
            return "No";
        }
        else if(dir.equals('n')){
            for(int i = row1;i>=row2;i--){
                if(!(br.board[i][col2].getClass().isInstance(new Empty())) && (br.board[i][col2].color==color)){
                    return "No";
                }
            }
        }
        else if(dir.equals('s')){
            for(int i = row1;i<=row2;i++){
                if(!(br.board[i][col2].getClass().isInstance(new Empty()))&&br.board[i][col2].color==color){
                    return "No";
                }
            }
        }
        else if(dir.equals('e')){
            for(int i = col1;i<=col2;i++){
                if(!(br.board[row2][i].getClass().isInstance(new Empty()))&&br.board[i][col2].color==color){
                    return "No";
                }
            }
        }
        else if(dir.equals('w')){
            for(int i = col1;i>=col2;i--){
                if(!(br.board[row2][i].getClass().isInstance(new Empty()))&&br.board[i][col2].color==color){
                    return "No";
                }
            }
        }
        return "Yes";
    }

    public String direction(int row1,int col1, int row2, int col2){
        if(col1-col2 !=0 && row1-row2!=0){
            return "i";
        }
        if(col1-col2!=0){
            if(col1-col2 <0){
                return "e";
            }
            else if(col1-col2>0){
                return "w";
            }
        }
        else if(row1-row2 != 0){
            if(row1-row2 <0){
                return "n";
            }
            else if(row1-row2>0){
                return "s";
            }
        }
        return "";
    }
    public String getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
