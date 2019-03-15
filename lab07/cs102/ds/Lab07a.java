package cs102.ds;
import java.util.*;
/**
 * __Lab07a___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __07-May-2018__
 */ 

public class Lab07a
{
  public static void main( String[] args)
  {
    final int FOR_RECURSION = -2;
    List myList = new List();
    
    myList.addToHead("talal");
    myList.addToHead("usman");
    myList.addToHead("ali");
    myList.addToHead("rafi");
    System.out.println("print after adding at heads");
    myList.print();
    System.out.println("-------------------------------------");
    myList.addToTail("umer");
    myList.addToTail("saboor");
    System.out.println("print after adding at tails");
    myList.print();
    System.out.println("-------------------------------------");
    myList.removeFromHead();
    System.out.println("print after removing at head");
    myList.print();
    System.out.println("-------------------------------------");
     System.out.println("printing while using getData method");
    System.out.println(myList.getData(0));
    System.out.println(myList.getData(1));
    System.out.println(myList.getData(2));
    System.out.println(myList.getData(3));
    System.out.println(myList.getData(4));
    System.out.println(myList.getData(5));
    System.out.println("-------------------------------------");
    System.out.println("printing in reverse");
    myList.printReverse(FOR_RECURSION);
  }
}