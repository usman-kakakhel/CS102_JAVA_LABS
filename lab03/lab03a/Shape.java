//abstract class for shapes
public abstract class Shape implements Locatable
{
  //properties
  private int x;
  private int y;
  
  //constructors
  public Shape(int x, int y)
  {
    setLocation(x, y);
  }
  
  //methods
  
    /**
 * Calculates area of the shapes.
 * @return double area value.
 */
  public abstract double getArea();
  
    /**
 * Info of shape in to string method.
 * @return String with all info
 */
  public abstract String toString();
  
    /**
 * Changing location of the shape to a specific point.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 */
  public void setLocation(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
    /**
 * gives y location of the shape.
 * @return y location of the shape
 */
  public int getY()
  {
    return y;
  }
  
    /**
 * gives x location of the shape.
 * @return x location of the shape
 */
  public int getX()
  {
    return x;
  }
}