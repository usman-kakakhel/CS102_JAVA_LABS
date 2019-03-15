import java.util.*;
/**
 * __Lab06d___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __17-04-2018__
 */ 

public class Lab06d
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    System.out.println(getList(4, 0));
  }
  
  /**
     * Finds list of number which are in n number and are oredered.
     * @param n is the width of the numbers.
     * @param i is the numbers from which I add into list..
     * @return list is the lit of filtered numbers.
     */
  public static ArrayList<Integer> getList(int n, int i)
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> newList = new ArrayList<Integer>();
    String max = "1";
    String num = "";
    boolean check = true;
    for (int j = 0; j < n; j++)
    {
      max = max + "0";
    }
    if (i == 0)
    {
      String min = "1";
      for (int j = 0; j < n - 1; j++)
      {
        min = min + "0";
      }
      if (n > 1)
        i = Integer.parseInt(min);
    }
    
    if (i < Integer.parseInt(max))
    {
      int k = 0;
      num = i + "";
      while(k < num.length() - 1)
      {
        if (num.charAt(k + 1) <= num.charAt(k))
          check = false;
        k++;
      }
      if (check)
      list.add(i);
      newList = getList(n, i + 2);
      for (int j = 0; j < newList.size(); j++)
      {
        list.add(newList.get(j));
      }
    }
    return list;
  }
  
}