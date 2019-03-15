import cs1.*;
import cs1.SimpleURLReader;
import java.util.Scanner;

/**
 * __Lab02a___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __date__
 */ 
public class Lab02a
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      final String url = "http://www.cs.bilkent.edu.tr/~david/housman.txt";

      // variables
      String line;

      // program code
      SimpleURLReader myReader = new SimpleURLReader(url);
      
      line = myReader.getPageContents();
      
      System.out.println(line);


      System.out.println(myReader.getLineCount());
      
   }

}