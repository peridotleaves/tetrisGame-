//import java.awt.*;
public class Piece {
	// indices of each location 
	// {(0, 0), (0, 1), (0, 2), (0, 3)},   
	// {(1, 0), (1, 1), (1, 2), (1, 3)},
	// {(2, 0), (2, 1), (2, 2), (2, 3)}, 
	// {(3, 0), (3, 1), (3, 2), (3, 3)},  
	
	// {(0, 0), (0, 1), (0, 2)},   
	// {(1, 0), (1, 1), (1, 2)},
	// {(2, 0), (2, 1), (2, 2)}
	
	// {(0, 0), (0, 1)},   
	// {(1, 0), (1, 1)},
	// {(2, 0), (2, 1)}
	
	// {(0, 0), (0, 1), (0, 2)},   
	// {(1, 0), (1, 1), (1, 2)},

	public Location[][] mino; 
	public java.awt.Color color; 

	private int MAX_HEIGHT = 0;
	private int MAX_WIDTH = 0;
	
	/*public int x1;
	public int x2;
	public int x3;
	public int x4;
	public int y1;
	public int y2;
	public int y3;
	public int y4; */
	
	public int[] xVals;
	public int[] yVals;


	    public Piece(java.awt.Color color, int width, int height, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
	    {
	    	MAX_HEIGHT = height;
	    	MAX_WIDTH = width;
	    	
	    	xVals = new int[] {x1, x2, x3, x4};
	        yVals = new int[] {y1, y2, y3, y4};
	        
	    	//new 4x4 2d array of Locations
	        mino = new Location[MAX_HEIGHT][MAX_WIDTH];
	        for(int row = 0; row < MAX_WIDTH; row++)
	        {
	            for(int col = 0; col < MAX_HEIGHT; col++)
	            {
	                mino[row][col] = new Location();
	            }
	        }
	       // this.x1 = x1; this.x2 = x2; this.x3 = x3; this.x4 = x4;
	       // this.y1 = y1; this.y2 = y2; this.y3 = y3; this.y4 = y4;
	       
	        //fill the blocks where the mino is
	        mino[x1][y1].fill(color); 
	        mino[x2][y2].fill(color); 
	        mino[x3][y3].fill(color); 
	        mino[x4][y4].fill(color); 
	        
	        
	        
	        
	    }
	    
	   /* public void rotateCW()
	    {
	    	Location[][] rotated = new Location[MAX_HEIGHT][MAX_WIDTH];
	    	for(int i = 0; i < MAX_HEIGHT; i++)
	    	{
	    		for(int j = 0; j < MAX_WIDTH; j++)
	    		{
	    			rotated[i][j] = mino[MAX_WIDTH-1-j][i];
	    		}
	    	}
	    	mino = rotated; 
	    } */
	    
	    public void rotateCW()
	    {
	    	Location[][] rotated = new Location[MAX_WIDTH][MAX_HEIGHT];
	    	int k = 0;
	    	
	    	for(int i = 0; i < MAX_HEIGHT; i++)
	    	{
	    		for(int j = 0; j < MAX_WIDTH; j++)
	    		{
	    			rotated[i][j] = mino[MAX_WIDTH-1-j][i];
		    		if(rotated[i][j].getStatus() == 1)
	    			{
		    			xVals[k] = i;
		    			yVals[k] = j;
		    			k+=1;
	    			}

	    		}
	    	}
	    	
	    	
	    	mino = rotated; 
	    	
	    	
	    }
	    
	    /*public void rotateCCW()
	    {
	    	Location[][] rotated = new Location[MAX_HEIGHT][MAX_WIDTH];
	    	for(int i = 0; i < MAX_HEIGHT; i++)
	    	{
	    		for(int j = 0; j < MAX_WIDTH; j++)
	    		{
	    			rotated[i][j] = mino[j][MAX_HEIGHT-1-i];
	    		}
	    	}
	    	mino = rotated;
	    } */
	    
	    public void rotateCCW()
	    {
	    	Location[][] rotated = new Location[MAX_WIDTH][MAX_HEIGHT];
	    	int k = 0;
	    	for(int i = 0; i < MAX_HEIGHT; i++)
	    	{
	    		for(int j = 0; j < MAX_WIDTH; j++)
	    		{
	    			rotated[i][j] = mino[j][MAX_HEIGHT-1-i];
	    			if(rotated[i][j].getStatus() == 1)
	    			{
		    			xVals[k] = i;
		    			yVals[k] = j;
		    			k+=1;
	    			}
	    		}
	    	}
	    	mino = rotated;
	    }
	    
	    public int[] getXVals()
	    {
	    	return xVals;
	    }
	    
	    public int[] getYVals()
	    {
	    	return yVals;
	    }
	    
	    public boolean isRelevantXIndex(int j)
	    {
	    	
	    	int largestXVal = 0;
	    	for(int i = 0; i < 4; i++)
	        {
	        	if(xVals[i] > largestXVal)
	        	{
	        		largestXVal = xVals[i];
	        	}
	        }
	    	
	    	if(xVals[j] == largestXVal) { return true; } 
	    
	    	if(mino[xVals[j]+1][yVals[j]].getStatus() == 0)
	    	{
	    		return true;
	   		}
	    	
	    	return false; 
	    	
	    }
	    
	    public boolean isRelevantRightIndex(int j)
	    {
	    	if(yVals[j] == getRightmostY()) { return true; } 
		    
	    	if(mino[xVals[j]][yVals[j]+1].getStatus() == 0)
	    	{
	    		return true;
	   		}
	    	
	    	return false; 
	    }
	    
	    public boolean isRelevantLeftIndex(int j)
	    {
	    	if(yVals[j] == getLeftmostY()) { return true; } 
		    
	    	if(mino[xVals[j]][yVals[j]-1].getStatus() == 0)
	    	{
	    		return true;
	   		}
	    	
	    	return false; 
	    }
	    
	    public int getLargestX()
	    {
	    	int largestXVal = -1;
	    	for(int i = 0; i < 4; i++)
	    	{
	    		if(xVals[i] > largestXVal)
	    		{
	    			largestXVal = xVals[i];
	    		}
	    	}
	    	return largestXVal;
	    }
	    
	    
	    public int getLeftmostY()
	    {
	    	int leftmostY= 0;
	    	for(int i = 0; i < 4; i++)
	    	{
	    		if(yVals[i] < leftmostY) {leftmostY = yVals[i];}
	    	}
	    	return leftmostY;
	    }
	    
	    public int getRightmostY()
	    {
	    	int rightmostY = 0;
	    	for(int i = 0; i<4; i++) 
	    	{
	    		if(yVals[i] > rightmostY) {rightmostY = yVals[i];}
	    	}
	    	return rightmostY;
	    }
	    
	    public Location[][] getArray()
	    {
	        return mino;
	    }
	    
	    public int getHeight()
	    {
	    	return MAX_HEIGHT;
	    }
	    
	    public int getWidth()
	    {
	    	return MAX_WIDTH;
	    }
	    
	    public boolean isFilled(int x, int y)
	    {
	        return mino[x][y].isMino();
	    }
	    
	    public java.awt.Color getColor()
	    {
	        return color; 
	    }
    
}
