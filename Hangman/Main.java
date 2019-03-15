import java.util.Scanner;
import java.io.*;


/**
 * Hangman class
 * @author Mian Usman Naeem Kakakhel 
 * @section 3
 * @version 8/2/2018
 */

public class Main
{
  public static void main ( String []args ) throws FileNotFoundException
  {
    Scanner scan = new Scanner(System.in);

      Hangman hangmanGame;
      hangmanGame = new Hangman();
      int tryResult;
      Character letter;
      System.out.println("These all are the letters you can use :" + hangmanGame.getAllLetters());
      
      do
      {
        System.out.println(hangmanGame.getMaxAllowedIncorrectTries() - hangmanGame.getNumOfIncorrectTries() + " : Number of wrong tries left");
        System.out.println("Word to be guessed : " + hangmanGame.getKnownSoFar());
        System.out.println("Words that cannot be used again : " + hangmanGame.getUsedLetters());
        System.out.println("Enter the Letter for the Secret Word ");
        tryResult = hangmanGame.tryThis(scan.next().toLowerCase().charAt(0));
        
        if ( tryResult == -1)
        {
          System.out.println("You choosed the wrong letter!");
        }
        else if ( tryResult == -2)
        {
          System.out.println("That letter is used!");
        }
      } while (!hangmanGame.isGameOver());
      
      if (hangmanGame.hasLost())
      {
        System.out.println("You lost.");
      }
      else
      {
        System.out.println("You WON.");
      }
      
      System.out.println("Word to be guessed : " + hangmanGame.getKnownSoFar());
    }
  }

