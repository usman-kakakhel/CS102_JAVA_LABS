package shapes;
import java.awt.*;

//Circle class
public class Circle extends Shape implements Selectable
{
  //properties
  private int radius;
  final double PI =  3.14159;
  boolean selected;
  
  //constructor
  public Circle (int radius, int x, int y)
  {
    super(x, y);
    this.radius = radius;
    selected = false;
  }

  //methods
  
  /**
 * The to String methods.
 * @return String which has all info
 */
  public String toString()
  {
    String info = "Shape : Circle -- radius : " + radius + " -- Area : " + getArea() + " --Locations = X: " + super.getX() + " and Y: " + super.getY()
       + " --Is selected: " + selected;  
    return info;
  }
  
  /**
 * Gives the radius of circle.
 * @return String which has all info
 */
  public int getRadius()
  {
    return radius;
  }
  
  /**
 * Sets the radius of circle.
 * @param x which sets to radius
 */
  public void setRadius(int x)
  {
    radius = x;
  }
  
  /**
 * Calculates area of the shapes.
 * @return double area value.
 */
  public double getArea()
  {
    return Math.pow((double)radius, 2) * PI;
  }
  
  /**
 * Whether point is contained in the shape or not.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 * @return shape which contains that point
 */
  public Shape contains(int x, int y) {
        int dX = (x - this.getX()) * (x - this.getX());
        int dY = (y - this.getY()) * (y - this.getY());
        
        if (dX + dY <= this.radius * this.radius)
          return this;
        return null;
    }
  
  /**
 * Get value of bolean if shape is selected or not.
 * @return boolean value of selected
 */
  public boolean getSelected()
  {
   return selected;
  }
  
  /**
 * Toggle value of select on the shape.
 * @param a is the boolean to which we have to toggle.
 */
  public void setSelected(boolean a)
  {
    selected = a;
  }
  
 
  
}