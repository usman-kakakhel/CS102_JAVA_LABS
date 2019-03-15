import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import shapes.*;

//frame with the game layout

public class Balloon extends Circle implements Drawable
{
  //properties
  static final int INITIAL_RADIUS = 25;
  static final int MAX_RADIUS = 100;
  boolean mine;
  
  //constructors
  public Balloon(int x, int y, boolean mine)
  {
    super(INITIAL_RADIUS, x, y);
    this.mine = mine;
  }
  
  //methods
  
   /**
 * Draws the shape in which the method is implemented.
 * @param g is the graphics object from which any stuff is to be drawn.
 */
  public void draw( Graphics g)
  {
    int x = super.getX() - super.getRadius();
    int y = super.getY() - super.getRadius();
    int diameter = super.getRadius() * 2;
    //Color myColor = new Color(234,34,0);
    //g.setColor(myColor);
    setRandomColor( g);
    g.drawOval(x, y, diameter, diameter);
  }
  
  /**
 * Tells if balloon is mine.
 * @return g is the boolean mine.
 */
  public boolean getMine()
  {
    return mine;
  }
  
  /**
 * fills the shape in which the method is implemented.
 * @param g is the graphics object from which any stuff is to be drawn.
 */
  public void fill( Graphics g)
  {
    int x = super.getX() - super.getRadius();
    int y = super.getY() - super.getRadius();
    int diameter = super.getRadius() * 2;
    Color myColor = new Color(0,255,0);
    g.setColor(myColor);
    g.fillOval(x, y, diameter, diameter);
  }
  
  /**
 * Sets color for draw randomly.
 * @param g is the graphics object from which any stuff is to be drawn.
 */
  public void setRandomColor( Graphics g)
  {
    int r = (int)(Math.random() * 255) ;
    int gC = (int)(Math.random() * 255) ;
    int b = (int)(Math.random() * 255) ;
    Color myColor = new Color(r, gC, b);
    g.setColor(myColor);
  }
  
  /**
 * Increases size of balloon until max size.
 */
  public void grow()
  {
    super.setRadius(super.getRadius() + 1);
 if (super.getRadius() >= MAX_RADIUS)
    {
    super.setRadius(0);
    super.setSelected(true);
    }
  }
  
}

