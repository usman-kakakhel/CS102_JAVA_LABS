package cs102.ds;
import java.util.Iterator;

//List class
public class List
{
  //properties
  Node head;
  
  //constructors
  public List()
  {
    head = null;
  }
  
  //methods
  
  /**
   * Adds any String to the top of the list of nodes.
   */
  public void addToHead( String item)
  {
    Node myNode = new Node(item);
    myNode.nextNode = head;
    this.head = myNode;
  }
  
  /**
   * Adds any String to the end of the list before null.
   * @return String that has been added to the end.
   */
  public String  addToTail( String item)    // iterative method
  {
    Iterator myListIterator = iterator();
    Node newNode = new Node(item);
    Node myNode = null;
    
    while (myListIterator.hasNext())
    {
      myNode = (Node)myListIterator.next();
    }
    
    newNode.nextNode = null;
    if (myNode != null)
      myNode.nextNode = newNode;
    else
      this.head = newNode;
    
    return item;
  }
  
  /**
   * Remove the node at the top of the list
   * @return String of the Node that has been removed from the top.
   */
  public String  removeFromHead() 
  {
    if (head == null )
    {
      System.out.println("Empty");
    }
    else 
    {
      String a = head.data;
      head = head.nextNode;
      return a;
    }
    
    return null;
  }
  
  /**
   *Checks if the given list has any members available
   * @return boolean which confirms if head is null or not
   */
  public boolean isEmpty()
  {
    if (this.head == null)
    {
      return true;
    }
    else 
    {
      return false;
    }
  }
  
  /**
   * Gives the data at a given index.
   * @param index which is the location of the node in the list.
   * @return String is the data that has been stored at the given index of the node
   */
  public String  getData( int index)        // invalid index returns null
  {
    Iterator myListIterator = iterator();
    String data = "";
    int temp = -1;
    
    while (myListIterator.hasNext() && (temp < index))
    {
      data = ((Node)myListIterator.next()).data;
      temp++;
    }
    
    if (index > temp)
      return null;
    else 
      return data;
  }
  
  /**
   * Prints the list in one order
   */
  public void print()                    // iterative method
  {
    Iterator myListIterator = iterator();
    
    while (myListIterator.hasNext())
    {
      System.out.println(((Node)myListIterator.next()).data);
    }
  }
  
  /**
   * Prints the data in a reverse order.
   * @param index is the number of the index to be printed, used in recursion
   */
  public void printReverse(int index)             // recursive method
  {
    //finding max size
    if (index == -2)
    {
      Iterator iterator = iterator();
      while (iterator.hasNext())
      {
        iterator.next();
        index++;
      }
      index++;
      printReverse(index);
    }
    else
    {
      if (index >= 0)
      {
        System.out.println(getData(index));
        index--;
        printReverse(index);
      }
    }
  }
  
  /**
   * Gives a new iterator of this list class
   * @return Iterator which is the iterator of list.
   */
  public Iterator iterator()
  {
    return new ListIterator(this);
  }
  
  
  //inner CLass
  private class Node
  {
    //properties
    String data;
    Node nextNode;
    
    //constructors
    public Node(String data)
    {
      this.data = data;
    }
  }
  
  //inner class NodeIterator
  public class ListIterator implements Iterator
  {
    //properties
    List myList;
    Node head;
    
    //constructors
    
    public ListIterator(List myList)
    {
      this.myList = myList ;
      this.head = myList.head;
    }
    
    //methods
    
    /**
     * Returns anything in the List.
     * @return any Object that is present in the list.
     */
    public Object next()
    {
      Node toReturn = this.head;
      this.head = this.head.nextNode;
      return toReturn;
    }
    
    /**
     * Checks if the list has any item left.
     * @return boolean true or false depending on item left.
     */
    public boolean hasNext()
    {
      if (this.head != null) 
      {
        return true;
      }
      return false;
    }
    
    
  }
  
}