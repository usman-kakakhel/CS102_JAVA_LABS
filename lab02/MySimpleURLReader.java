import cs1.SimpleURLReader;

//class SimpleURLReader

public class MySimpleURLReader extends SimpleURLReader
{
  //properties
  String url;
  
  //constructors
  public MySimpleURLReader(String url)
  {
    super(url);
    this.url = url;
  }
  
  //methods
  
  /**
   * returns the url String used to create the SimpleURLReader object.
   * @param i an example input parameter
   * @param s another example input 
   * @return the url required
   */
  public String getURL()
  {
    return url;
  }
  
  /**
   * returns the filename part of the url.
   * @return the url name required
   */
  public String getName()
  {
    String name = "";
    
      if (url.lastIndexOf( '/' ) != -1 )
        name =  url.substring(url.lastIndexOf( '/' ) + 1, url.length());

    return name;
  }
  
  
  /**
   * returns contents of the page without null.
   * @return the contents required
   */
  public String getPageContents()
  {
    return super.getPageContents().substring(4);
  }
  
  
  
  
}