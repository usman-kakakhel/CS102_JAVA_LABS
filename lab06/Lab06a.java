import java.util.*;
/**
 * __Lab06a___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __17-04-2018__
 */ 

public class Lab06a
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner(System.in);
    final int STARTPLACE = 0;
    
    String line;
    System.out.println("Give line for e.");
    line = scan.nextLine();
    
    System.out.println("Number of e in this line is: " + findETimes(line, STARTPLACE));
  }
  
  /**
     * Finds number of e in the line.
     * @param line is the string in which we have to find the e.
     * @param start is the StartPlace on the line to start searching.
     * @return times which is the times e is repeated.
     */
  public static int findETimes(String line, int start)
  {
    int times = 0;
    
    if (line.indexOf('e', start) != -1)
    {
      times++;
      times = times + findETimes(line, line.indexOf('e', start) + 1);
    }
    return times;
  }
  
}