package shapes;
//interface selectable
public interface Selectable
{
    /**
 * Get value of bolean if shape is selected or not.
 * @return boolean value of selected
 */
  public boolean getSelected();
  
    /**
 * Toggle value of select on the shape.
 * @param a is the boolean to which we have to toggle.
 */
  public void setSelected(boolean a);
  
    /**
 * Whether point is contained in the shape or not.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 * @return shape which contains that point
 */
  public Shape contains(int x, int y);
}