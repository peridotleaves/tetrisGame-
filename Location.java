import java.awt.Color;

/**
 * 
 */

/**
 * @author arianneli
 *
 */
//import java.awt.Color.*;
public class Location {
	//The location class deals with each of the single unit boxes on the player matrix
	public static final int FILLED = 1; 
	public static final int UNFILLED = 0; 
	public boolean isMino;

	//class attributes are
	public java.awt.Color spaceColor = Color.GRAY; 
	public int occupied;

	    public Location()
	    {
			occupied = UNFILLED;
			isMino = false;
	    }

	    public boolean isMino()
	    {
	    	return isMino; 
	    }
	    
	    public int getStatus()
	    {
	    	return occupied;
	    }
	    
	    public void setColor(java.awt.Color color)
	    {
	    	spaceColor = color;
	    }
	    
	    public void unfill()
	    {
	        occupied = UNFILLED;
	    }
	    
	    public void fill(java.awt.Color color)
	    {
	        occupied = FILLED;
	        spaceColor = color;
	        isMino = true;
	    }
	    
	    public java.awt.Color getColor()
	    {
	        return spaceColor;
	    }

}
