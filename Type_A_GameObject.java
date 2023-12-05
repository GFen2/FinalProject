package finalproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


//GAME OBJECT OF TYPE D REQUIRES A KEY LISTENER
public class Type_A_GameObject extends GameObject implements KeyListener {

  public Type_A_GameObject(int x, int y) {
    super(x, y);
    setDirection(Direction.NONE);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_A_Up.png"));
    imageList.add(new ImageIcon("images/Type_A_Down.png"));
    imageList.add(new ImageIcon("images/Type_A_Left.png"));
    imageList.add(new ImageIcon("images/Type_A_Right.png"));
    
    imageList.add(new ImageIcon("images/HType_A_Up.png"));
    imageList.add(new ImageIcon("images/HType_A_Down.png"));
    imageList.add(new ImageIcon("images/HType_A_Left.png"));
    imageList.add(new ImageIcon("images/HType_A_Right.png"));
    
  }
  boolean dir = false;
  public void move(Canvas c) {
    Icon icon = getCurrentImage();
    
   
    
    int  iconHeight   = icon.getIconHeight();
    int  iconWidth    = icon.getIconWidth();
    int  canvasHeight = (int)c.getSize().getHeight();
    int  canvasWidth  = (int)c.getSize().getWidth();
    
    //MOVE BLUE GAME OBJECT
    if(getTemp() == true) {
    switch (getDirection()) {
      case Direction.UP:
        setY(getY() - getVelocity());
        if (getY() < 0) {
          setY(0);
        }
        break;
      case Direction.DOWN:
        setY(getY() + getVelocity());
        if (getY() + iconHeight > canvasHeight) {
          setY((int)(canvasHeight - iconHeight));
        }
        break;
      
	default:
		break;
    }
    }
  //----------------------------------------------------- 
    if(getTemp() == false) {
    	
    	  	
    	if(dir == false) {
    		setY(getY() + getVelocity());
    		setDirection(Direction.DOWN);
    		if (getY() + iconHeight > canvasHeight) {
    				
    			  
    	          dir = true;
    	          setDirection(Direction.UP);
    	        }
    	}
            
            else if (dir == true) {
            	setDirection(Direction.UP);
            	setY(getY() - getVelocity());
            	if (getY() < 0) {
                    dir = false;
                    setDirection(Direction.DOWN);
                  }
            }
    	}
    	
    
    
    
    

  }
  
  public void down(Canvas C) {
	  
  }

  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
	  if (getTemp() == false) {
	  	switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        currentImage = 0;
	        break;
	      case Direction.DOWN:
	        currentImage = 1;
	        break;
	      case Direction.LEFT:
	        currentImage = 2;
	        break;
	      case Direction.RIGHT:
	        currentImage = 3;
	        break;
	    }
	  }
	    if (getTemp() == true) {
	    	switch (getDirection()) {
		      case Direction.NONE:
		        break;
		      case Direction.UP:
		        currentImage = 4;
		        break;
		      case Direction.DOWN:
		        currentImage = 5;
		        break;
		      case Direction.LEFT:
		        currentImage = 6;
		        break;
		      case Direction.RIGHT:
		        currentImage = 7;
		        break;
		    }
	    }
	  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() != KeyEvent.VK_TAB) {
      setDirection(Direction.NONE);
    }
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP && getTemp() == true) {
      setDirection(Direction.UP);
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN && getTemp() == true) {
      setDirection(Direction.DOWN);
    }
   
  }

}
