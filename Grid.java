import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Grid {
	
	public static final int MATRIX_WIDTH = 10;
    public static final int MATRIX_HEIGHT = 22;
    public static final int MATRIX_VISIBLE_HEIGHT= 20; 
    
    public Location[][] grid;
    public Timer timer = new Timer();
    
    //minoSink holds each 7 minos twice for a total of 14 minos, can be shuffled 
    public Piece[] minoSink = {new OMino(), new SMino(), new ZMino(), new LMino(), new JMino(),
    		new TMino(), new IMino(), new OMino(), new SMino(), new ZMino(), new LMino(), 
    		new JMino(), new TMino(), new IMino()};
    public List<Piece> queue;
    //current piece is the one that's in play and falling and stuff
    public Piece current;
    
    //y is distance from left, x is distance from top (both count from the 0,0 index of the piece) 
    public int leftOffset = 0; 
    public int topOffset = 0;
    
    public boolean shouldAddNew = false;
    
    
    public Grid()
    {
        grid = new Location[MATRIX_HEIGHT][MATRIX_WIDTH];
        for(int row = 0; row < MATRIX_HEIGHT; row++)
        {
            for(int col = 0; col < MATRIX_WIDTH; col++)
            {
                grid[row][col] = new Location();
            }
        }
    }
    
    /*public void incrementDown()
    {
    	timer.scheduleAtFixedRate(new TimerTask() {
    		  @Override
    		  public void run() {
    			  
    			  clearCurrentMino();
    			  moveDown();
    			  redrawMino(); 
    			  if(toppedOut())
    			  {
    				  System.out.println("Game over :c");
    				  shouldAddNew = false;
    			  }
    			  if(shouldAddNew)
    			  {
    				  addNewPiece();
    			  }
    		  }
    		}, 400, 400);
    } */
    
    public void addNewPiece() {
    	if(queue == null || queue.isEmpty())
    	{
    		queue = new ArrayList<Piece>(Arrays.asList(minoSink));
    		Collections.shuffle(queue); 
    	}
    	current = queue.get(0);
    	queue.remove(0);
    	shouldAddNew = false;
    	
    	//because 3 makes it centered
    	leftOffset = 3;
    	topOffset = 0;
    	Location[][] mino = current.getArray();
    	for(int i = 0; i < current.getHeight(); i++)
    	{
    		for(int j = 0; j < current.getWidth(); j++)
    		{
    			if(mino[i][j].getStatus() == 1)
    			{
    				grid[i][j+leftOffset] = mino[i][j];
    			}
    		}
    	}
    	
    }
    
    public List<Piece> getQueue()
    {
    	return queue;
    }
    
    public Location getLocation(int x, int y)
    {
    	return grid[x][y];
    }
    
    
    //will have to set offsets in moveLeft/Right and moveDown functions before redrawing 
    public void updateGrid() 
    {
    	Location[][] mino = current.getArray();
    	for(int i = 0; i < current.getHeight(); i++)
    	{
    		for(int j = 0; j < current.getWidth(); j++)
    		{
    			if(mino[i][j].getStatus() == 1)
    			{
    				grid[i+topOffset][j+leftOffset] = mino[i][j];
    			}
    		}
    	}
    }
    
    public void clearCurrentMino()
    {
    	Location[][] mino = current.getArray();
    	for(int i = 0; i < current.getHeight(); i++)
    	{
    		for(int j = 0; j < current.getWidth(); j++)
    		{
    			if(mino[i][j].getStatus() == 1)
    			{
    				grid[i+topOffset][j+leftOffset] = new Location();
    			}
    		}
    	}
    }
    
    public boolean toppedOut()
    {
    	return topOffset == 0 && illegalMoveDown();
    }
  
    public boolean bottomedOut()
    {
    	return MATRIX_VISIBLE_HEIGHT-1 == current.getLargestX() + topOffset;
    	/*System.out.println("top offset " + topOffset);
    	System.out.println("largest x value " +current.getLargestX());
    	System.out.println(topOffset+current.getLargestX());*/
     }
    
    public boolean illegalMoveDown()
    {
    	int[] xVals = current.getXVals();
    	//System.out.println(current.getXVals());
    	int[] yVals = current.getYVals();
    	//System.out.println(current.getYVals());
    	
    	for(int j = 0; j < 4; j++)
    	{
    		if(current.isRelevantXIndex(j))
    		{
    			if(grid[xVals[j]+topOffset+1][yVals[j]+leftOffset].getStatus() == 1)
    			{
    				return true;
    			}
    		}
    	}
    	return false; 
    }
    
    public boolean legalMoveRight()
    {
    	int[] xVals = current.getXVals();
    	int[] yVals = current.getYVals();
    	for(int i = 0; i < 4; i++)
    	{
    		if(current.isRelevantRightIndex(i))
	    	{
    			if(grid[xVals[i]+topOffset][yVals[i]+leftOffset+1].getStatus() == 1)
	    		{
	    			return false;
	   			}
    		}
    	}
    	return true;
    }
    
    public boolean legalMoveLeft()
    {
    	int[] xVals = current.getXVals();
    	int[] yVals = current.getYVals();
    	for(int i = 0; i < 4; i++)
    	{
    		if(current.isRelevantLeftIndex(i))
	    	{
    			if(grid[xVals[i]+topOffset][yVals[i]+leftOffset-1].getStatus() == 1)
	    		{
	    			return false;
	   			}
    		}
    	}
    	return true;
    }
    
    public void moveRight()
    {
    	
    	if(leftOffset < 9-current.getRightmostY() && legalMoveRight())
    	{
    		System.out.println("left offset: " + leftOffset);
        	System.out.println("rightmostY : " + current.getRightmostY());
    		leftOffset +=1;
    	}
    }
    
    public void moveLeft()
    {
    	if(leftOffset > (0-current.getLeftmostY()-1) && legalMoveLeft()) 
    	{
    		leftOffset -=1; 
    	}
    }
    
    public void moveDown()
    {
    	if(!bottomedOut() && !illegalMoveDown())
    	{
    		topOffset+=1; 
    	}
    	else 
    	{
    		shouldAddNew = true;
    	}
    }
    
    public void hardDrop()
    {
    	while(!bottomedOut() && !illegalMoveDown())
    	{
    		topOffset +=1;
    	}
    	shouldAddNew = true;
    }
    
    public void rotateCW()
    {
    	current.rotateCW();
    }
    
    public void rotateCCW()
    {
    	current.rotateCCW();
    }
    
    public void clearAllFilledRows()
    {
    	
    	for(int row = 0; row < MATRIX_VISIBLE_HEIGHT; row++)
    	{
    		int numFilled = 0;
    		for(int col = 0; col < MATRIX_WIDTH; col ++)
    		{
    			if(grid[row][col].getStatus() == 1)
    			{
    				numFilled+=1;
    			}
    			if(numFilled == 10)
    			{
    				System.out.println("we will pass in "+ row);
    				clearRow(row);
    			}
    		}
    	}
    	
    }	
    
    
    public void clearRow(int x)
    {
    	System.out.println("Supposed to clear row " + x);
    	Location[][] translated = new Location[MATRIX_HEIGHT][MATRIX_WIDTH];
    	
        for(int row = 0; row < MATRIX_HEIGHT; row++)
        {
            for(int col = 0; col < MATRIX_WIDTH; col++)
            {
                if(row == 0)
                {
                	translated[row][col] = new Location();
                }
                if(row > 0 && row <= x)
                {
                	translated[row][col] = grid[row-1][col];
                }
                
                if(row > x)
                {
                	translated[row][col] = grid[row][col];
                }
            }
        }
        
        grid = translated;
        
    }
}

