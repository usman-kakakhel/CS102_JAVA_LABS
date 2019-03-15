package cs1;
//class SimpleURLReader

public class HTMLFilteredReader extends MySimpleURLReader
{
  //properties
  String url;
  
  //constructors
  public HTMLFilteredReader(String url)
  {
    super(url);
    this.url = url;
  }
  
  //methods
  
  /**
   * return only the text, without the html. 
   * @return the contents required
   */
  public String getPageContents()
  {
    String original = super.getPageContents();
    String altered = "";
    int open = 0;
    int close = -1;
    boolean check = false;
    
    for (int i = 0; i < original.length(); i++)
    {
      if (original.charAt(i) == '<')
      {
        check = true;
        open = i;
      }
      else if (original.charAt(i) == '>')
      {
        close = i;
      }
      
      if (check)
        altered = altered + original.substring(close + 1, open);
      
      check = false;
    }
    return altered;
  }

  
  /**
   * return the original page complete with html codes. 
   * @return the contents required
   */
  public String getUnfilteredPageContents()
  {
    return super.getPageContents();
  }
  
}