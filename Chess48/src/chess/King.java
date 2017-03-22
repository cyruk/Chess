package chess;
import java.io.IOException;

/**
 * Created by Shah on 3/8/2017.
 */
public class King extends Piece {
    public String color;
    public String name;
    public boolean moved;
    public int id;

    public King(String color, String name, int id) {
        this.color = color;
        this.name = name;
        moved = false;
        this.id = id;
    }

    public King(){}

    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException {
        String cl = br.board[row1][col1].getColor();
        //moving more than one spot down or up
        if (row1-row2>1||row2-row1>1){
            return "No";
        }
        //moving more than two spots to the left or to the right
        else if(col1-col2>2 || col2 -col1 >2){
            return "No";
        }
        //moving two spots to the left or to the right diagonally
        else if ((col1-col2==2 && row1!=row2)||(col2-col1==2 && row1!=row2)){
            return "No";
        }
        ////moving two spots to the left or right
        else if(col1-col2 == 2){
            //king has already moved
            if(br.board[row1][col1].moved==true){
                return "No";
            }
            //moving towards the left and pieces in the way?
            else if((!br.board[row1][col1-1].getClass().isInstance(new Empty()))
                    ||(!br.board[row1][col1-2].getClass().isInstance(new Empty()))
                    ||(!br.board[row1][col1-3].getClass().isInstance(new Empty()))){
                return "No";
            }

            // moving to the left and path is clear... is there a rook for castling?
            else if(br.board[row1][col1-4].getClass().isInstance(new Rook())){
                //has the rook already moved??
                if(br.board[row1][col1-4].moved==true) {
                    return "No";
                }
                //valid left castling
                return "lc";
            }
            return "No";
        }
        //king is moving to the right
        else if(col2-col1 ==2){
            //king has already moved
        	//System.out.println(br.board[row1][col1].moved);
            if(br.board[row1][col1].moved==true){
                return "No";
            }
            //moving towards the right and pieces in the way?
            else if((!br.board[row1][col1+1].getClass().isInstance(new Empty()))
                    ||(!br.board[row1][col1+2].getClass().isInstance(new Empty()))){
                return "No";
            }
            else if(br.board[row1][col1+3].getClass().isInstance(new Rook())){
                //has the rook already moved??
                if(br.board[row1][col1+3].moved==true) {
                    return "No";
                }
                //valid right castling
                return "rc";
            }
            return "No";
        }
        //Spot is within 1 and is empty
        else if(br.board[row2][col2].getClass().isInstance(new Empty())){
            return "FreeMove";
        }
        //Spot is is within 1 and is a friendly piece
        else if(!br.board[row2][col2].getClass().isInstance(new Empty()) && br.board[row2][col2].getColor().equals(cl)){
            return "No";
        }
        //Enemy piece for killing
        return "Kill";
    }

    public String[] possibleMoves(int kRow, int kCol){
    	int[] row = new int[8];
    	int[] col = new int[8];
        String[] validCoordinates = new String[8];
    	row[0] = kRow-1;
        row[1] = kRow-1;
        row[2] = kRow-1;
        row[3] = kRow+1;
        row[4] = kRow+1;
        row[5] = kRow+1;
        row[6] = kRow;
        row[7] = kRow;
        col[0] = kCol;
        col[1] = kCol-1;		
        col[2] = kCol+1;		
        col[3] = kCol;
        col[4] = kCol-1;
        col[5] = kCol+1;
        col[6] = kCol-1;
        col[7] = kCol+1;
        
        for(int i=0;i<8;i++){
        	if(row[i]<0 || row[i] >7||col[i]<0||col[i]>7 ){
        		validCoordinates[i] = "";
        	}
        	else{
        		validCoordinates[i] = "" + row[i] + col[i];
        	}
        }
        return validCoordinates;
    }
    public String getName(){
        return name;
    }
    public String getColor(){return color;}
    public int getId(){
        return id;
    }
}
