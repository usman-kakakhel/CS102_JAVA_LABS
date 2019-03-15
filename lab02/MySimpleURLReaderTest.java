
/**
 * __MySimpleURLReaderTest___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __date__
 */ 
public class MySimpleURLReaderTest
{
  public static void main( String[] args)
  {
    
    // constants
    final String url = "http://www.cs.bilkent.edu.tr/~david/housman.txt";
    
    // variables
    
    
    // program code
    
    MySimpleURLReader reader = new MySimpleURLReader(url);
    
    
    System.out.println(reader.getName());
    System.out.println("-------------------------------------");
    System.out.println(reader.getURL());
    System.out.println("-------------------------------------");
    System.out.println(reader.getPageContents());
    
    
  }
  
}