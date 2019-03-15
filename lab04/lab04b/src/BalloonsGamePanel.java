import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import shapes.*;

//frame with the game layout

public class BalloonsGamePanel extends JPanel
{
  //properties
  private ShapeContainer balloons;
  private JLabel label;
  Timer myTimer;
  static final int INTERVAL = 250;
  static final int INITIAL_BALLOON_COUNT = 25;
  static final int TIME = 100;
  private int points;
  private int balloonCount;
  private int elapsedTime;
  private MouseListener mouseListener;
  private int mine;
  private boolean gameOver;
  
  //constructors
  public BalloonsGamePanel()
  {
    this.startGame();
  }
  //methods
  
  /**
   * Sets the starting values of all variables and initiates most of the stuff.  
   */
  public void startGame()
  {
    gameOver = false;
    balloonCount = INITIAL_BALLOON_COUNT;
    elapsedTime = 0;
    points = 0;
    balloons = new ShapeContainer();
    createComponents();
    this.setBackground(Color.yellow);
    setMine();
  }
  
  /**
   * Sets value of the mine to random.
   */
  public void setMine()
  {
    mine = (int)(Math.random() * 15);
  }
  
  /**
   * Creates some of the components used in the game such as balloons.
   */
  public void createComponents()
  {
    label = new JLabel("Points:  " + points + "       The time elapsed: " + elapsedTime);
    this.add(label);
    
    this.addBalloons();
    
    mouseListener = new MyMouseListener();
    this.addMouseListener(mouseListener);
    
    ActionListener listener = new TimeListener();
    myTimer = new Timer(INTERVAL, listener);
    myTimer.start();
  }
  
  /**
   * Adds balloons in the container that has been initiated.
   */
  public void addBalloons()
  {
    int x;
    int y;
    int z = 0;
    while (balloons.size() < balloonCount)
    {
      x = (int)(Math.random() * GameFrame.FRAME_WIDTH);
      y = (int)(Math.random() * GameFrame.FRAME_HEIGHT);
      if (z == mine)
      {
        balloons.add(new Balloon(x, y, true));
      }
      else
      {
        balloons.add(new Balloon(x, y, false));
      }
      z++;
    }
    
  }
  
  /**
   * Prints all the balloons on the panel.
   * @param g as the graphics which are used to draw stuff. 
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Iterator balloonsIterator = balloons.iterator();
    
    
    while( balloonsIterator.hasNext() )
    {
      Object a = balloonsIterator.next();
      
      if(((Drawable)a).getMine())
        ((Drawable)a).fill(g);
      else
        ((Drawable)a).draw(g);
    }
  }
  
  //inner class for growing ballons in specific time period.
  class TimeListener implements ActionListener
  {
    /**
     * Sets location of the shape.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void actionPerformed(ActionEvent event)
    {
      Iterator balloonsIterator = balloons.iterator();
      while( balloonsIterator.hasNext() )
      {
        ((Balloon)balloonsIterator.next()).grow();
      }
      balloons.deleteShapes();
      label.setText("Points:  " + points + "       The time elapsed: " + elapsedTime);
      balloonCount = 15;
      addBalloons();
      repaint();
      
      elapsedTime++;
      if (elapsedTime >= TIME)
        gameOver = true;
      
      if (gameOver) 
      {
        myTimer.stop();
        removeMouseListener(mouseListener);
        int finish = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Play Again", "Game Over", 0);
        if (finish == 0)
        {
          removeAll();
          startGame();
        }
        else
        {
          System.exit(0);
        }
      }
    }
  }
  
  //inner class for mouse action
  class MyMouseListener implements MouseListener
  {
    
    /**
     * Sets location of the shape.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mousePressed(MouseEvent event)
    {
      int x = event.getX();
      int y = event.getY();
      int a = balloons.selectAllAt(x, y);
      
      
      Iterator balloonsIterator = balloons.iterator();
      while( balloonsIterator.hasNext() )
      {
        Object b = balloonsIterator.next();
        if (((Selectable)b).getSelected())
        {
          if ((((Drawable)b).getMine()))
          {
            gameOver = true;
          }
        }
      }
      
      if (a >= 2)
        points = points + a;
    }
    
    /**
     * Is triggered on mouse release.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseReleased(MouseEvent event) {}
    
    /**
     * Is triggered on mouse clicked.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseClicked(MouseEvent event) {}
    
    /**
     * Is triggered on mouse entered.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseEntered(MouseEvent event) {}
    
    /**
     * Is triggered on mouse exited.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseExited(MouseEvent event) {}
  }
  
}

