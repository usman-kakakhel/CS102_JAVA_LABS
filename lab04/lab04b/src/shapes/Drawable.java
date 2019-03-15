package shapes;
import java.awt.*;

//interface Drawable
public interface Drawable
{
  /**
 * Draws the shape in which the method is implemented.
 * @param g is the graphics object from which any stuff is to be drawn.
 */
  public void draw( Graphics g);
  
  
   /**
 * fills the shape in which the method is implemented.
 * @param g is the graphics object from which any stuff is to be drawn.
 */
  public void fill( Graphics g);
  
  /**
 * Whether shape is mine.
 * @return boolean if shape is mine
 */
  public boolean getMine();
}