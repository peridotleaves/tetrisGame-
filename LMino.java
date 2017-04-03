import java.awt.Color;

public class LMino extends Piece {
	public static final java.awt.Color L_COLOR= new Color(0X1300C2); //orange
	
	public LMino() {
		super(L_COLOR, 3,3, 0,0, 1,0, 2,0, 2,1);
		//super(L_COLOR, 3,3, 0,0, 0,1, 1,1, 2,1);
	}

}
