
/**
 * __SuperHTMLFilteredReaderTest___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __date__
 */ 
public class SuperHTMLFilteredReaderTest
{
  public static void main( String[] args)
  {
    
    // constants
    final String url = "http://www.cs.bilkent.edu.tr/~david/index.html";
    
    // variables
    
    
    // program code
    
    SuperHTMLFilteredReader reader = new SuperHTMLFilteredReader(url);
    
    System.out.println("over head of the text.");
    System.out.println(reader.getOverhead() + "%");
    System.out.println("------------------------");
    System.out.println("links in the code.");
    System.out.println(reader.getLinks());
    
  }
  
}