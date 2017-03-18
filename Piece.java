package samp;

import java.io.IOException;

/**
 * Created by Shah on 3/1/2017.
 */
public class Piece{

    public String color;
    public boolean ePos;
    public String name;
    public boolean moved;
    public int id;

    public String isValid(int row1, int col1, int row2, int col2, Board br) throws IOException{return "";}
    public String getName(){
        return name;
    }
    public String getColor(){return color;}
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String[] possibleMoves(){
    	String[] arr = new String[0];
    	return arr;
    }
}

