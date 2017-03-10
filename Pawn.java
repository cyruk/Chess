package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/1/2017.
 */
public class Pawn extends Piece {
    public String color;
    public boolean ePos;
    public String name = "Pawn";

    public Pawn(String color){
        this.color = color;
        ePos = false;
    }

    //checks if player move for pawn is valid, if not then returns false, otherwise returns true
    public String isValid(int initX, int initY, int x, int y, Piece[][] board)throws IOException{
        if(getColor() == "White"){
            //going backwards?
            if(y <=initY){
                return "No";
            }
            //moving more than one spot to the left or right?
            else if(initX-x>1||x-initX>1){
                return "No";
            }
            //made atleast one move and moving two spots forward?
            else if(initY>2&& y-initY>1){
                return "No";
            }
            //has not moved and moving more than two spots forward in one turn?
            else if(initY==2&& y-initY>2 ){
                return "No";
            }
            //moving two spots as first move, and not moving straight
            else if(initY==2 && (y-initY>=2 && x !=initX)){
                return "No";
            }
            //desired spot not empty
            if(board[x][y] !=null){
                if(board[x][y].color=="White"|| initX == x){
                    return "No";
                }
                //black piece there for killing
                return "Kill";
            }
            //moving onto an empty spot
            else if(board[x][y] == null){
                if(initX==x){
                    //promotion
                    if(y==8){
                        return "Pro";
                    }
                    else if(initY==2 && y-initY==2 && board[x][y-1]!=null ){
                        return "No";
                    }
                    return "Yes";
                }
                else if(initY ==5&& board[x][initY].ePos==true){
                    return "Epos";
                }
                return "No";
            }
        }
        else if(getColor() == "Black"){
            //going backwards?
            if(y >=initY){
                return "No";
            }
            //moving more than one spot to the left or right?
            else if(initX-x>1||x-initX>1){
                return "No";
            }
            //made atleast one move and moving two spots forward?
            else if(initY<7&& initY-y>1){
                return "No";
            }
            //has not moved and moving more than two spots forward in one turn?
            else if(initY==7&& initY-y>2 ){
                return "No";
            }

            //moving two spots as first move, and not moving straight
            else if(initY==7 && (initY-y>=2 && x !=initX)){
                return "No";
            }
            //desired spot not empty
            if(board[x][y] !=null){
                if(board[x][y].color=="White"|| initX == x){
                    return "No";
                }
                //black piece there for killing
                return "Kill";
            }
            //moving onto an empty spot
            else if(board[x][y] == null){
                if(initX==x){
                    //promotion
                    if(y==8){
                        return "Pro";
                    }
                    else if(initY==2 && y-initY==2 && board[x][y-1]!=null ){
                        return "No";
                    }
                    return "Yes";
                }
                else if(initY ==4&& board[x][initY].ePos==true){
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
