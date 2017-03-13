package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/1/2017.
 */
public class Pawn extends Piece {
    public String color;
    public boolean ePos;
    public String name;

    public Pawn(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
    }

    //checks if player move for pawn is valid, if not then returns false, otherwise returns true
    public String isValid(int row1, int col1, int row2, int col2, Piece[][] board)throws IOException{
        if(getColor() == "White"){
            //going backwards?
            if(row2 <=row1){
                return "No";
            }
            //moving more than one spot to the left or right?
            else if(col1-col2>1||col2-col1>1){
                return "No";
            }
            //made atleast one move and moving two spots forward?
            else if(row1>2&& row2-row1>1){
                return "No";
            }
            //has not moved and moving more than two spots forward in one turn?
            else if(row1==2&& row2-row1>2 ){
                return "No";
            }
            //moving two spots as first move, and not moving straight
            else if(row1==2 && (row2-row1>=2 && col1 !=col2)){
                return "No";
            }
            //desired spot not empty
            if(board[col1][row2] !=null){
                if(board[col1][row2].color=="White"|| col2 == col1){
                    return "No";
                }
                //black piece there for killing
                return "Kill";
            }
            //moving onto an empty spot
            else if(board[col1][row2] == null){
                if(col2==col1){
                    //promotion
                    if(row2==8){
                        return "Pro";
                    }
                    else if(row1==2 && row2-row1==2 && board[col1][row2-1]!=null ){
                        return "No";
                    }
                    return "Yes";
                }
                else if(row1 ==5&& board[col1][row1].ePos==true){
                    return "Epos";
                }
                return "No";
            }
        }
        else if(getColor() == "Black"){
            //going backwards?
            if(row2 >=row1){
                return "No";
            }
            //moving more than one spot to the left or right?
            else if(col2-col1>1||col1-col2>1){
                return "No";
            }
            //made atleast one move and moving two spots forward?
            else if(row1<7&& row1-row2>1){
                return "No";
            }
            //has not moved and moving more than two spots forward in one turn?
            else if(row1==7&& row1-row2>2 ){
                return "No";
            }

            //moving two spots as first move, and not moving straight
            else if(row1==7 && (row1-row2>=2 && col1 !=col2)){
                return "No";
            }
            //desired spot not empty
            if(board[col1][row2] !=null){
                if(board[col1][row2].color=="White"|| col2 == col1){
                    return "No";
                }
                //black piece there for killing
                return "Kill";
            }
            //moving onto an empty spot
            else if(board[col1][row2] == null){
                if(col2==col1){
                    //promotion
                    if(row2==8){
                        return "Pro";
                    }
                    else if(row1==2 && row2-row1==2 && board[col1][row2-1]!=null ){
                        return "No";
                    }
                    return "Yes";
                }
                else if(row1 ==4&& board[col1][row1].ePos==true){
                    return "Epos";
                }
                return "No";
            }
        }

        return "Yes";
    }

    public String getColor(){
        return color;
    }

    public String getName(){
        return name;
    }
}
