import java.util.Scanner;

/**
 * __Lab03b___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __13 - 03 - 2018__
 */ 
public class ShapeTester
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // constants
    
    // variables
    int choice1;
    int choice2;
    int width;
    int height;
    int radius;
    int x;
    int y;
    boolean exit;
    boolean check;
    ShapeContainer myContainer;
    
    
    // program code
    x = 0;
    y = 0;
    exit = false;
    check = false;
    myContainer = new ShapeContainer();
    
    do
    {
      System.out.println( "For creating empty container enter 1.");
      System.out.println( "For adding shapes enter 2.");
      System.out.println( "For getting overall area enter 3.");
      System.out.println( "For getting information about all shapes, enter 4.");
      System.out.println( "For changing shape location, enter 5.");
      System.out.println( "For checking if location present in shape, enter 6.");
      System.out.println( "For deleting all selected shapes, enter 7.");
      System.out.println( "For exiting press any other number.");
      
      choice1 = scan.nextInt();
      
      if (choice1 == 1)
      {
        myContainer = new ShapeContainer();
        System.out.println( "Container emptied.");
      }
      else if (choice1 == 2)
      {
        System.out.println( "For making circle press 1.");
        System.out.println( "For making rectangle press 2.");
        System.out.println( "For making square press 3.");
        choice2 = scan.nextInt();
        
        if (choice2 == 1)
        {
          do
          {
            if(check)
              System.out.println( "radius entered is zero or negative, enter correct radius.");
            System.out.println( "enter radius");
            radius = scan.nextInt();
            check = true;
          }while (radius <= 0);
          check = false;
          System.out.println( "enter X axis location");
          x = scan.nextInt();
          System.out.println( "enter Y axis location");
          y = scan.nextInt();
          
          myContainer.add(new Circle(radius, x, y) );
          System.out.println();
        }
        else if(choice2 == 2)
        {
          do
          {
            if(check)
              System.out.println( "radius entered is zero or negative, enter correct radius.");
            System.out.println( "enter width");
            width = scan.nextInt();
            check = true;
          }while (width <= 0);
          check = false;
          do
          {
            if(check)
              System.out.println( "radius entered is zero or negative, enter correct radius.");
            System.out.println( "enter height");
            height = scan.nextInt();
            check = true;
          }while (height <= 0);
          check = false;
          System.out.println( "enter X axis location");
          x = scan.nextInt();
          System.out.println( "enter Y axis location");
          y = scan.nextInt();
          
          myContainer.add(new Rectangle(width, height, x ,y));
          System.out.println();
        }
        else if(choice2 == 3)
        {
          do
          {
            if(check)
              System.out.println( "radius entered is zero or negative, enter correct radius.");
            System.out.println( "enter side");
            width = scan.nextInt();
            check = true;
          }while (width <= 0);
          check = false;
          System.out.println( "enter X axis location");
          x = scan.nextInt();
          System.out.println( "enter Y axis location");
          y = scan.nextInt();
          
          myContainer.add(new Square(width, x ,y));
          System.out.println();
        }
      }
      else if(choice1 == 3)
      {
        System.out.println(myContainer.getArea());
        System.out.println();
      }
      else if(choice1 == 4)
      {
        System.out.println(myContainer.toString());
        System.out.println();
      }
      else if(choice1 == 5)
      {
        System.out.println( "Available shapes");
        System.out.println(myContainer.toString());
        System.out.println();
        System.out.println("Select number of shape to change its location." );
        choice2 = scan.nextInt();
        System.out.println( "enter X axis location");
        x = scan.nextInt();
        System.out.println( "enter Y axis location");
        y = scan.nextInt();
        myContainer.setLocation(choice2 - 1, x, y);
      }
      else if(choice1 == 6)
      {
        System.out.println( "Available shapes");
        System.out.println(myContainer.toString());
        System.out.println();
        System.out.println( "enter X axis location");
        x = scan.nextInt();
        System.out.println( "enter Y axis location");
        y = scan.nextInt();
        
        Selectable z = (Selectable)myContainer.contains(x, y);
        
        if ((z != null) && (z.getSelected()))
        {
          System.out.println( "These points lie in this shape:  " + z.toString());
          System.out.println( "shape is selected, press 1 to deselect any other button to leave.");
          choice2 = scan.nextInt();
          if (choice2 == 1)
          {
            z.setSelected(false);
          }
        }
        else if ((z != null) && (!z.getSelected()))
        {
          System.out.println( "These points lie in this shape:  " + z.toString());
          System.out.println( "shape is not selected, press 1 to select any other button to leave.");
          choice2 = scan.nextInt();
          if (choice2 == 1)
          {
            z.setSelected(true);
          }
        }
        else if (z == null)
        {
          System.out.println( "No shape is present on these points.");
        }
      }
      else if(choice1 == 7)
      {
        System.out.println( "Available shapes");
        System.out.println(myContainer.toString());
        System.out.println();
        myContainer.deleteShapes();
        System.out.println( "Shapes after removing");
        System.out.println(myContainer.toString());
        System.out.println();
      }
      else
      {
        exit = true;
      }
      
    }while (!exit);
  }
  
}