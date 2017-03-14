package samp;

/**
 * Created by Shah on 3/8/2017.
 */
public class Empty extends Piece {
    public String name;

    public Empty(String name){
        this.name = name;
    }

    public Empty(){
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
