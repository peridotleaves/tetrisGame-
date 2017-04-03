import java.awt.Color;

public class SMino extends Piece {
	public static final java.awt.Color S_COLOR= new Color(0X11EB00); //green mino
	
	public SMino() {
		super(S_COLOR, 3,3, 0,1, 0,2, 1,0, 1,1);
		//super(S_COLOR, 3,3, 2,0, 2,1, 1,1, 1,2);
	}

}
