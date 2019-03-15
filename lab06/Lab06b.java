import java.util.*;
/**
 * __Lab06b___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __17-04-2018__
 */ 

public class Lab06b
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter decimal");
    //System.out.println(toBinary(scan.nextInt()));
    System.out.println(binarytoDenary ("1000", 0, 0));
  }
  /**
     * Turns decimal to binary.
     * @param decimal is the decimal to change.
     * @return binary is the binary converted.
     */
  public static String toBinary(int decimal)
  {
   String binary = "";
   binary = (decimal % 2) + binary;
   decimal = decimal / 2;
   if (decimal > 0)
     binary = toBinary(decimal) + binary;
   return binary;
  }
  
  public static int toDenary(String binary)
  {
    int denary = 0;
    
      if ((binary.length() >= 1) && (binary.charAt(0) == '1'))
      {
        denary = denary + (int)Math.pow(2, binary.length() - 1);
      }
      if (binary.length() >= 1)
        denary = denary + toDenary(binary.substring(1));
      return denary;
  }
  
  
  public static int binarytoDenary (String binary, int decimalVal, int count)
    {

        if (binary.length() < 1)
            return decimalVal;
        else if (binary.charAt(binary.length() - 1 ) == '0') {
            count++;
            return binarytoDenary(binary.substring(0, binary.length()-1 ), (decimalVal), count);
        }
        else
        {

            return binarytoDenary( binary.substring(0, binary.length()-1 ), (((int)Math.pow(2, count) + decimalVal) ), count++);

        }
  }
}