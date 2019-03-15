import cs1.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * __Lab02e___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __date__
 */ 
public class Lab02e
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // constants
    
    
    // variables
    int op1;
    int op2;
    ArrayList<MySimpleURLReader> list;
    String url;
    
    // program code
    
    list = new ArrayList<MySimpleURLReader>();
    url = "";
    op1 = 0;
    op2 = -1;
    
    while (op1 != 3)
    {
      System.out.println("1- To enter poem url to add");
      System.out.println("2- List all poems in the collection");
      System.out.println("3- To exit");
      op1 = scan.nextInt();
      System.out.println();
      if (op1 == 1)
      {
        System.out.println("Enter url.");
        url = scan.nextLine();
        url = scan.nextLine();
        
        if (url.lastIndexOf(".") != -1)
        {
          if (url.substring(url.lastIndexOf(".") , url.lastIndexOf(".") + 4).equals(".txt"))
            list.add(new MySimpleURLReader(url));
          else
            list.add(new HTMLFilteredReader(url));
        }
        
        System.out.println();
      }
      else if (op1 == 2)
      {
        if (list.size() == 0)
        {
          System.out.println("No poem in there yet.");
        }
        while (op2 != list.size() && list.size() > 0)
        {
          for (int i = 0; i < list.size(); i++)
          {
            System.out.println(i + 1 + " - " + list.get(i).getName());
          }
          System.out.println();
          System.out.println("Enter poem number to display. Enter last poem + 1 to exit.");
          op2 = scan.nextInt() - 1;
          
          if (op2 < list.size() && op2 >= 0)
            System.out.println(list.get(op2).getPageContents());
        }
        System.out.println();
        op2 = -1;
      }
    }
    
    
  }
  
}