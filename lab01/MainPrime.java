import java.util.Scanner;

/**
 * _Program for finding first 100 prime numbers___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __12-02-2018__
 */  
public class MainPrime
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // constants
    final int MAXARRAYSIZE = 10000;
    
    // variables
    IntBag primes = new IntBag(MAXARRAYSIZE);
    boolean check;
    int j;
    
    long startTime = System.nanoTime();
    
    // program code
    check = false;
    primes.add(2);
    j = 0;
    
    for(int i = 3; primes.size() < MAXARRAYSIZE; i++)
    {
      //(j < primes.size())
      while((Math.pow(primes.size(),0.5) > j) && (!check))
      {
        if(i % primes.getValue(j) == 0)
        {
          check = true;
        }
        j++;
      }
      if(!check)
      {
        primes.add(i);
      }
      check = false;
      j = 0;
    }
    
    //System.out.println(primes.toString());
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println((float)totalTime/1000000);
  }
  
}