package cs102.ds;

//List class
public class Stack
{
  //properties
  List myList;
  
  //constructors
  public Stack()
  {
    myList = new List();
  }
  
  //methods
  /**
   * Enters data in the list in question.
   * @param myDigit is the string to be added.
   */
  public void push(String myDigit)
  {
    myList.addToHead(myDigit);
  }
  
  
  /**
   * Removes the Node from the top of the stack.
   * @return String that is the data of the node that has been removed.
   */
  public String pop()
  {
    return myList.removeFromHead();
  }
  
  /**
   * Tells if the stack is empty or not.
   * @return boolean is the state of the emptiness of the stack.
   */
  public boolean isEmpty()
  {
    return myList.isEmpty();
  }
  
  
}