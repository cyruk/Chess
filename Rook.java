package chess;

import java.util.Objects;

/**
 * Created by Shah on 3/2/2017.
 */
public class Rook extends Piece {
    public char color;
    public boolean ePos;
    public String name;
    public  boolean moved;

    public Rook(char color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }

    public String isValid(int col1, int row1, int col2, int row2, Piece[][] board){
        String dir = direction(col1,row1,col2,row2);

        if(dir.equals('i')){
            return "No";
        }
        else if(dir.equals('n')){
            for(int i = row1;i>=row2;i--){
                if(!(board[i][col2].getClass().isInstance(new Empty(""))) && (board[i][col2].color==color)){
                    return "No";
                }
            }
        }
        else if(dir.equals('s')){
            for(int i = row1;i<=row2;i++){
                if(!(board[i][col2].getClass().isInstance(new Empty("")))&&board[i][col2].color==color){
                    return "No";
                }
            }
        }
        else if(dir.equals('e')){
            for(int i = col1;i<=col2;i++){
                if(!(board[row2][i].getClass().isInstance(new Empty("")))&&board[i][col2].color==color){
                    return "No";
                }
            }
        }
        else if(dir.equals('w')){
            for(int i = col1;i>=col2;i--){
                if(!(board[row2][i].getClass().isInstance(new Empty("")))&&board[i][col2].color==color){
                    return "No";
                }
            }
        }
        return "Yes";
    }

    public String direction(int col1,int row1, int col2, int row2){
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
    public char getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
