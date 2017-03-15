package chess;

public class Game  {

	public static void main(String args[])
	{
		int[] hello = new int[4];
		hello = Game.convert("e2 e4");
		System.out.println(hello[0]);
		System.out.println(hello[1]);
		System.out.println(hello[2]);
		System.out.println(hello[3]);
	}
    public Game(){

    }

    public Board move(Board br, String cr){
        int[] cor = new int[4];
        cor = convert(cr);
        System.out.println(cor[3]);
        return br;
    }

    public static int[] convert(String cdt){
    	int[] cord = new int[4];
    	//row
		cord[0] = Character.getNumericValue(cdt.charAt(0)) - 10;
		System.out.println(cord[0] + "D");
		//column
		cord[1] = Math.abs(Character.getNumericValue(cdt.charAt(1)) - 8);
		//row
		cord[2] = Character.getNumericValue(cdt.charAt(3)) - 10;
		//column
		cord[3] = Math.abs(Character.getNumericValue(cdt.charAt(4)) - 8);
		return cord;
    }




}

