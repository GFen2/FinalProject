package finalproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


//GAME OBJECT OF TYPE D REQUIRES A KEY LISTENER
public class Type_C_GameObject extends GameObject implements KeyListener {

  public Type_C_GameObject(int x, int y) {
    super(x, y);
    setDirection(Direction.NONE);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_C_Up.png"));
    imageList.add(new ImageIcon("images/Type_C_Down.png"));
    imageList.add(new ImageIcon("images/Type_C_Left.png"));
    imageList.add(new ImageIcon("images/Type_C_Right.png"));
    
    imageList.add(new ImageIcon("images/HType_C_Up.png"));
    imageList.add(new ImageIcon("images/HType_C_Down.png"));
    imageList.add(new ImageIcon("images/HType_C_Left.png"));
    imageList.add(new ImageIcon("images/HType_C_Right.png"));
    
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
      case Direction.RIGHT:
        setX(getX() - getVelocity());
        if (getX() < 0) {
          setX(0);
        }
        break;
      case Direction.LEFT:
        setX(getX() + getVelocity());
        if (getX() + iconWidth > canvasWidth) {
          setX((int)(canvasWidth - iconWidth));
        }
        break;
      
	default:
		break;
    }
    }
  //----------------------------------------------------- 
    if(getTemp() == false) {
    	
    		
    	if(dir == false) {
    		setX(getX() + getVelocity());
    		setDirection(Direction.LEFT);
    		if (getX() + iconWidth > canvasWidth) {
    	          dir = true;
    	          setDirection(Direction.RIGHT);
    	        }
    	}
            
            else if (dir == true) {
            	setX(getX() - getVelocity());
            	setDirection(Direction.RIGHT);
            	if (getX() < 0) {
                    dir = false;
                    setDirection(Direction.LEFT);
                  }
            }
    	}
    	
    
    
    
    

  }
  
  public void down(Canvas C) {
	  
  }

  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
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
    if (e.getKeyCode() == KeyEvent.VK_RIGHT && getTemp() == true) {
      setDirection(Direction.LEFT);
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT && getTemp() == true) {
      setDirection(Direction.RIGHT);
    }
   
  }

}
