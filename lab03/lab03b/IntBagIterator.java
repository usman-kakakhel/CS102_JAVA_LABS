import java.util.Iterator;

//Int bag iterator
public class IntBagIterator implements Iterator
{
  //properties
  IntBag aBag;
  int index;
  
  //constructors
  
  public IntBagIterator(IntBag aBag)
  {
    this.aBag = aBag;
    index = -1;
  }
  
  //methods
  
  public Object next()
  {
    index++;
    return (Integer)aBag.getValue(index);
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