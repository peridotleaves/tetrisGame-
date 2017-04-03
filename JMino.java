import java.awt.Color;

public class JMino extends Piece {
	public static final java.awt.Color J_COLOR= new Color(0XCF8B00); //blue

	public JMino() {
		super(J_COLOR, 3,3, 0,1, 1,1, 2,1, 2,0);
		//super(J_COLOR, 3,3, 0,1, 0,2, 1,1, 2,1);
	}

}
