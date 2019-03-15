import java.util.Iterator;

//Int bag iterator
public class ShapeContainerIterator implements Iterator
{
  //properties
  ShapeContainer aBag;
  int index;
  
  //constructors
  
  public ShapeContainerIterator(ShapeContainer aBag)
  {
    this.aBag = aBag;
    index = -1;
  }
  
  //methods
  
  public Object next()
  {
    index++;
    return (Shape)aBag.getShape(index);
  }
  
  public boolean hasNext()
  {
    if (index < aBag.size() - 1)
      return true;
    else 
    {
      return false;
    }
  }
  
  
}