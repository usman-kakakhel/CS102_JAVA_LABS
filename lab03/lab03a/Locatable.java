//interface locatable
public interface Locatable
{
  /**
 * gives x location of the shape.
 * @return x location of the shape
 */
  public int getX();
  
  /**
 * gives y location of the shape.
 * @return y location of the shape
 */
  public int getY();
  
  /**
 * Changing location of the shape to a specific point.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 */
  public void setLocation( int x, int y );
}