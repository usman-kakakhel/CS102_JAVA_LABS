import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author:
// date:
public class CardGameTest
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    System.out.println( "Start of CardGameTest\n");
    
    // CONSTANTS
    
    // VARIABLES
    Card       c;
    Card       c1;
    Cards      cards;
    ScoreCard  scores;
    Player     p;
    CardGame   game;
    
    // PROGRAM CODE
    
    // test Card class
    c = new Card( 2);
    System.out.println( c);
    c1 = new Card( 2);
    System.out.println( c1);
    System.out.println(c.equals(c1));
    System.out.println(c.compareTo(c1));
    System.out.println();
    
    // test Cards class
    cards = new Cards( true);
    cards.addTopCard( c);
    cards.testOnlyPrint();  // remove method after testing!
    System.out.println();
    System.out.println();
    System.out.println();
    cards.shuffle();
    cards.testOnlyPrint();  // remove method after testing!
    
    // test ScoreCard class
    scores = new ScoreCard( 4);
    scores.update( 3, 1);
    scores.update( 1, 2);
    scores.update( 2, 2);
    scores.update( 0, 3);
    System.out.println( "\n" + scores );
    int[] tst = scores.getWinners();
    System.out.print( "Winner is player: ");
    for (int i : tst)
      System.out.println( i);
    
    
    // test Player class
    Player p1 = new Player("David");
    Player p2 = new Player("Derya");
    Player p3 = new Player("Deniz");
    Player p4 = new Player("Bombar");
    p1.add(c);
    p1.add(c1);
    System.out.println();
    System.out.println();
    System.out.println(p1.playCard());
    
    // test CardGame class too?
    CardGame maGame = new CardGame(p1,p2,p3,p4);
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(maGame.playTurn(p2,p2.playCard()));
    System.out.println(maGame.playTurn(p1,p1.playCard()));
    
    // Once you have all the bits working, complete the MyCardGame program
    // that provides a menu allowing any of the players to play their card,
    // an option to see the score card, and one to quit the game at any time.
    // When the game is over it should print out the winners.
    
    System.out.println( "\nEnd of CardGameTest\n" );
  }
  
} // end of class CardGameTest
