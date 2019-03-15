package cs102.ds;
import java.util.*;
/**
 * __Lab07b___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __07-May-2018__
 */ 

public class Lab07b
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    //properties
    String input;
    Stack myStack;
    
    //code
    myStack = new Stack();
    input = scan.nextLine();
    
    for (int i = 0; i < input.length(); i++)
    {
      if ((input.charAt(i) >= '0') && (input.charAt(i) <= '9'))
      {
        myStack.push("" + input.charAt(i));
      }
      else
      {
        int a = Integer.parseInt(myStack.pop());
        int b = Integer.parseInt(myStack.pop());
        int c = 0;
        if (input.charAt(i) == '+')
          c = b + a;
        else if (input.charAt(i) == '-')
          c = b - a;
        else  if (input.charAt(i) == '*')
          c = b * a;
        else  if (input.charAt(i) == '/')
          c = b / a;
        
        myStack.push("" + c);
      }
    }
    System.out.println(myStack.pop());
    
  }
}