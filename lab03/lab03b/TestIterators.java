import java.util.Scanner;
import java.util.Iterator;

/**
 * __Lab03b___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __13 - 03 - 2018__
 */ 
public class TestIterators
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    Iterator i, j;
    
    IntBag bag = new IntBag();
    bag.add(1);
    bag.add(25);
    bag.add(164);
    bag.add(14);
    bag.add(5465);
    
    i = bag.new IntBagIterator(bag);
    
    while ( i.hasNext() ) 
    {
      System.out.println( i.next() );
      
     // j = bag.new IntBagIterator(bag );
      j = bag.iterator();
      
      while ( j.hasNext() )
      {
        System.out.println( "--" + j.next() );
      }
    }
    
  }
}