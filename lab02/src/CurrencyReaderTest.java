import cs1.*;
import cs1.SimpleURLReader;
import java.util.Scanner;

/**
 * __Lab02a___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __date__
 */ 
public class CurrencyReaderTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      final String url = "http://tcmb.org.tr/kurlar/today.xml";

      // variables
      String line;

      // program code
      CurrencyReader myReader = new CurrencyReader(url);
      
      System.out.println(myReader.getCurrencies());
      
      //System.out.println(myReader.getChangedRates());

   }

}