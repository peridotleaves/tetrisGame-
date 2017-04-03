import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

//This is the pop up window thing with graphics and stuff 
public class JGrid extends JFrame implements KeyListener{

	public Grid grid;
    public Timer timer = new Timer();
	public int cellSize = 30;
	public static final int MATRIX_VISIBLE_HEIGHT= 20; 
	public static final int MATRIX_WIDTH = 10;
	JGrid self = this;
	JPanel panel;
	
	
	public JGrid()
	{
		grid = new Grid();
		
		setLayout( new BorderLayout());
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		Dimension panelSize = new Dimension(cellSize*MATRIX_WIDTH, cellSize*MATRIX_VISIBLE_HEIGHT);
		panel.setPreferredSize(panelSize);
		addKeyListener(this);
		panel.addKeyListener(this);
		
		pack();
		
		setVisible(true);
		
	}
	
	public void start()
	{
		grid.addNewPiece();
		drawJGrid();
		incrementDown();
	}
	
	private int locToPixels(int num)
	{
		return num*cellSize + cellSize/2;
	}
	
	public void drawJGrid()
	{
		Graphics2D graphicMagic = (Graphics2D)panel.getGraphics();
		
		for(int row = 0; row < MATRIX_VISIBLE_HEIGHT; row++)
		{
			for(int col = 0; col < MATRIX_WIDTH; col++)
			{
				Location loc = grid.getLocation(row, col);
				graphicMagic.setColor(loc.getColor());
				graphicMagic.fillOval(locToPixels(col), locToPixels(row), cellSize, cellSize);
				
			}
		}
	}
	
	public void incrementDown()
    {
    	timer.scheduleAtFixedRate(new TimerTask() {
    		  @Override
    		  public void run() {
    			  
    			  grid.clearCurrentMino();
    			  grid.moveDown();
    			  grid.updateGrid(); 
    			  drawJGrid();
    			  if(grid.toppedOut())
    			  {
    				  System.out.println("Game over :c");
    				  grid.shouldAddNew = false;
    				  
    			  }
    			  if(grid.shouldAddNew)
    			  {
    				  grid.clearAllFilledRows();
    				  grid.addNewPiece();
    			  }
    		  }
    		}, 400, 400);
    }
	
    
    public void keyTyped(KeyEvent e)
    {
    	
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
    
    	switch (e.getKeyCode())
    	{
    		case KeyEvent.VK_RIGHT: 
    								grid.clearCurrentMino();
    								grid.moveRight();
    								grid.updateGrid();
    								drawJGrid();
    								break;
    		case KeyEvent.VK_LEFT: 
									grid.clearCurrentMino();
									grid.moveLeft();
									grid.updateGrid();
									drawJGrid();
									break;
    		case KeyEvent.VK_DOWN: 
						    		grid.clearCurrentMino();
									grid.moveDown();
									grid.updateGrid();
									drawJGrid();
									break;
    		case KeyEvent.VK_UP:   
						    		grid.clearCurrentMino();
									grid.rotateCW();
									grid.updateGrid();
									drawJGrid();
									break;
    		case KeyEvent.VK_V:    
						    		grid.clearCurrentMino();
									grid.rotateCCW();
									grid.updateGrid();
									drawJGrid();
									break;
    		case KeyEvent.VK_SPACE: 
    								grid.clearCurrentMino();
									grid.hardDrop();
									grid.updateGrid();
									drawJGrid();
									break;						
		
    	}
    	
    	
    }
    
    public void keyReleased(KeyEvent e)
    {
    	
    }
	
}
