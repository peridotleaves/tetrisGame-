// import java.awt.*;

public class Tetromino {
	//for reference, the indices of the Pieces 
	// {(0, 0), (0, 1), (0, 2), (0, 3)},   
	// {(1, 0), (1, 1), (1, 2), (1, 3)},
	// {(2, 0), (2, 1), (2, 2), (2, 3)}, 
	// {(3, 0), (3, 1), (3, 2), (3, 3)},  
	//apology to anyone who has to read the indices of the Pieces :'c
	//I go from leftmost to rightmost, up to down, if that helps 

	// static colors and all possible forms of the 7 types of minos
	/*public static final java.awt.Color O_COLOR= new Color(0XF6ED00); //yellow mino
	public static final Piece[] O_FORMS= {new Piece(O_COLOR, 1,1, 1,2, 2,1, 2,2)};

	public static final java.awt.Color I_COLOR= new Color(0X01B5B8); //cyan mino
	public static final Piece[] I_FORMS = {new Piece(I_COLOR, 0,1, 1,1, 2,1, 3,1), new Piece(I_COLOR, 1,0, 1,1, 1,2, 1,3)};

	public static final java.awt.Color S_COLOR= new Color(0X11EB00); //green mino
	public static final Piece[] S_FORMS = {new Piece(S_COLOR, 1,2, 1,3, 2,1, 2,2), new Piece(S_COLOR, 0,1, 1,1, 1,2, 2,2)};

	public static final java.awt.Color Z_COLOR= new Color(0XCF1F00); //red mino
	public static final Piece[] Z_FORMS = {new Piece(Z_COLOR, 1,0, 1,1, 2,1, 2,2), new Piece(Z_COLOR, 0,2, 1,1, 1,2, 2,1)};

	public static final java.awt.Color L_COLOR= new Color(0X1300C2); //orange
	public static final Piece[] L_FORMS = {new Piece(L_COLOR, 0,1, 1,1, 2,1, 2,2), new Piece(L_COLOR, 2,1, 1,1, 1,2, 1,3),
	                                        new Piece(L_COLOR, 1,1, 1,2, 2,2, 3,2), new Piece(L_COLOR, 3,0, 3,1, 3,2, 2,2)};

	public static final java.awt.Color J_COLOR= new Color(0XCF8B00); //blue
	public static final Piece[] J_FORMS = {new Piece(J_COLOR, 0,2, 1,2, 2,2, 2,1), new Piece(J_COLOR, 1,1, 2,1, 2,2, 2,3),
	                                        new Piece(J_COLOR, 1,1, 1,2, 2,1, 3,1), new Piece(J_COLOR, 1,0, 1,1, 1,2, 2,2)};

	public static final java.awt.Color T_COLOR= new Color(0X7C0AC2); //purple
	public static final Piece[] T_FORMS = {new Piece(L_COLOR, 0,1, 1,1, 2,1, 2,2), new Piece(L_COLOR, 2,1, 1,1, 1,2, 1,3),
	                                        new Piece(L_COLOR, 1,1, 1,2, 2,2, 3,2), new Piece(L_COLOR, 3,0, 3,1, 3,2, 2,2)};
*/

	// the Mino class constructs pieces from the static final forms and stores them in static arrays to be accessed
	/* public static String minoName;
	public static java.awt.Color minoColor; 
	public static Piece[] rotations;
	public static int numForms;
	public static int counter = 0;

	    public Tetromino(String name)
	    {
	        switch(name) 
	        {
	            case "O": 
	                minoName = "O mino";
	                minoColor = O_COLOR;
	                rotations = O_FORMS;
	                numForms = 1;
	            case "I": 
	                minoName = "I mino";
	                minoColor = I_COLOR;
	                rotations = I_FORMS;
	                numForms = 2;
	            case "S": 
	                minoName = "S mino";
	                minoColor = S_COLOR;
	                rotations = S_FORMS;
	                numForms = 2;
	            case "Z": 
	                minoName = "Z mino";
	                minoColor = Z_COLOR;
	                rotations = Z_FORMS;
	                numForms = 2;
	            case "L": 
	                minoName = "L mino";
	                minoColor = L_COLOR;
	                rotations = L_FORMS;
	                numForms = 4;
	            case "J": 
	                minoName = "J mino";
	                minoColor = J_COLOR;
	                rotations = J_FORMS;
	                numForms = 4;
	            case "T": 
	                minoName = "T mino";
	                minoColor = T_COLOR;
	                rotations = T_FORMS;
	                numForms = 4;
	        }
	        
	    }
	    //returns mino name
	    public String getName()
	    {
	        return minoName;
	    }
	    
	    //returns color of mino
	    public java.awt.Color getMinoColor()
	    {
	        return minoColor;
	    }
	    
	    public Piece rotateRight()
	    {
	        counter++;
	        return rotations[counter%numForms];
	    } */


} 
