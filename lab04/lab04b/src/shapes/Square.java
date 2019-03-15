package shapes;
//Square class
public class Square extends Rectangle
{
//properties
  private int side;
  
  //constructor
  public Square(int side, int x, int y)
  {
    super(side, side, x, y);
    this.side = side;
  }
  
  //methods
  
  public String toString()
  {
    String info = "Shape : Square -- side : " + side + " -- Area : " + getArea() + " --Locations = X: " 
      + super.getX() + " and Y: " + super.getY() + " --Is selected: " + super.getSelected();  
    return info;
  }
  
}