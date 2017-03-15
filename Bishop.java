 samp;

import java.io.IOException;

/**
 * Created by Shah on 3/9/2017.
 */
public class Bishop extends Piece {

    public String color;
    public boolean ePos;
    public String name;
    public  boolean moved;

    public Bishop(String color, String name){
        this.color = color;
        this.name = name;
        ePos = false;
        moved = false;
    }
    public Bishop(){}
    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        String dir = direction(row1,col1,row2,col2);
        int i,j;
        String cl = br.board[row1][col1].getColor();
        if(dir.equals("invalid")){
            return "No";
        }

        else if(dir.equals("ne")){
            for(i=row1-1;i>row2;i--){
                for(j = col1+1;j<col2;j++){
                    if(!(br.board[i][j].getClass().isInstance(new Empty()))){
                        return "No";
                    }
                }
            }
        }
        else if(dir.equals("nw")){
            for(i=row1-1;i>row2;i--){
                for(j = col1-1;j>col2;j--){
                    if(!(br.board[i][j].getClass().isInstance(new Empty()))){
                        return "No";
                    }
                }
            }
        }
        else if(dir.equals("se")){
            for(i=row1+1;i<row2;i++){
                for(j = col1+1;j<col2;j++){
                    if(!(br.board[i][j].getClass().isInstance(new Empty()))){
                        return "No";
                    }
                }
            }
        }
        else if(dir.equals("sw")){
            for(i=row1+1;i<row2;i++){
                for(j = col1-1;j>col2;j--){
                    if(!(br.board[i][j].getClass().isInstance(new Empty()))){
                        return "No";
                    }
                }
            }
        }
        if((br.board[row2][col2].getClass().isInstance(new Empty()))) {
            return "FreeMove";
        }
        else if(br.board[row2][col2].getColor().equals(cl)){
            return "No";
        }
        return "Kill";

    }

    public String direction(int row1,int col1, int row2, int col2){
        double slope = (row2-row1)/(col2-col1);
        double dX = col2-col1;
        double dY = row2-row1;
        if(slope != 1.0 && slope != -1.0){
            return "invalid";
        }
        if(dY>0&& dX<0){
            return "sw";
        }
        else if(dY<0 &&dX<0){
            return "nw";
        }
        else if(dY>0&&dX>0){
            return "se";
        }
        else if(dY<0&&dX>0){
            return "ne";
        }

        return "invalid";
    }
    public String getName(){
        return name;
    }
    public String getColor(){return color;}
}

