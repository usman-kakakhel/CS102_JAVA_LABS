package cs1;
import java.util.ArrayList;
//class SimpleURLReader

public class SuperHTMLFilteredReader extends HTMLFilteredReader
{
  //properties
  String url;
  final int HREFADDLOCATION = 6;
  
  //constructors
  public SuperHTMLFilteredReader(String url)
  {
    super(url);
    this.url = url;
  }
  
  //methods
  
  /**
   * return the value of overhead code size. 
   * @return the overhead code size
   */
  public double getOverhead()
  {
    double percentage = 0;
    
    percentage = (double)(super.getUnfilteredPageContents().length() - super.getPageContents().length());
    percentage = percentage / super.getUnfilteredPageContents().length();
    percentage = percentage * 100;
    
    return percentage;
  }

  /**
   * return the links present in the HTML contents. 
   * @return the overhead code size
   */
  public ArrayList<String> getLinks()
  {
    ArrayList<String> list = new ArrayList<String>();
    String data = super.getUnfilteredPageContents();
    int i = 0;
    
    while (data.indexOf("href=\"" , i) != -1)
    {
      list.add(data.substring(data.indexOf("href=\"" , i) + HREFADDLOCATION , data.indexOf("\"" , data.indexOf("href=\"" , i) + HREFADDLOCATION)));
      i = data.indexOf("href=\"" , i + 1) + 1;
    }
    
    return list;
  }
  
}