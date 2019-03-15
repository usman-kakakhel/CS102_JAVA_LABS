import java.util.Scanner;

/**
 * _Program for manipulating IntBag Class___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __12-02-2018__
 */  
public class TestFindAll
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // constants
    final int MAXARRAYSIZE = 5;
    
    // variables
    IntBag collection;
    IntBag locationCollection;
    int choice;
    int value;
    int testValue;
    boolean collectionCreated;
    boolean testValuePresent;
    boolean testValueCalculated;
    
    // program code
    collectionCreated = false;
    testValuePresent = false;
    testValueCalculated = false;
    choice = 0;
    collection = new IntBag();
    locationCollection = new IntBag();
    testValue = 0;
    
    while (!(choice == 9))
    {
      System.out.println("Please enter number of choice for these commands.");
      System.out.println("-------------------------------------------------------");
      System.out.println(" 1 - Create a new empty collection.");
      System.out.println(" 2 - Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)");
      System.out.println(" 3 - Print the collection of values.");
      System.out.println(" 4 - Add a value to the collection of values at a specified location.");
      System.out.println(" 5 - Remove the value at a specified location from the collection of values.");
      System.out.println(" 6 - Read a single test value.");
      System.out.println(" 7 - Compute the set of locations of the test value within the collection.");
      System.out.println(" 8 - Print the set of locations.");
      System.out.println(" 9 - Quit the program.");
      
      choice = scan.nextInt();
      
      if (choice == 1)
      {
        collection = new IntBag(MAXARRAYSIZE);
        collectionCreated = true;
      }
      else if ((choice == 2) && (collectionCreated))
      {
        do
        {
          System.out.println(" Enter value");
          value = scan.nextInt();
          if (value >= 0)
            collection.add(value);
          if (collection.size() >= MAXARRAYSIZE)
            System.out.println("You cant add anymore because array is full.");
        }while ((value >= 0) && (collection.size() < MAXARRAYSIZE));
      }
      else if ((choice == 3) && (collectionCreated))
      {
        System.out.println(collection.toString());
      }
      else if ((choice == 4) && (collectionCreated))
      {
        System.out.println(" Enter value");
        value = scan.nextInt();
        System.out.println(" Enter location in array to store this value.");
        collection.add(value,scan.nextInt());
      }
      else if ((choice == 5) && (collectionCreated))
      {
        System.out.println(" Enter location in array to remove value from.");
        collection.remove(scan.nextInt());
      }
      else if ((choice == 6) && (collectionCreated))
      {
        System.out.println(" Enter test value.");
        testValue = scan.nextInt();
        testValuePresent = true;
      }
      else if ((choice == 7) && (collectionCreated) && (testValuePresent))
      {
        locationCollection = collection.findAll(testValue);
        testValueCalculated = true;
      }
      else if ((choice == 8) && (collectionCreated) && (testValueCalculated))
      {
        System.out.println(locationCollection.toString());
      }
      else if (choice == 9)
      {
      }
      else 
      {
        System.out.println("wrong option.");
      }
    }
  }
}