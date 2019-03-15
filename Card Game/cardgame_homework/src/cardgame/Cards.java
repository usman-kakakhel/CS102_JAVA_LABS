package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards
{
  final int NOOFCARDSINFULLPACK = 52;
  
  // properties
  Card[] cards;
  int    valid;  // number of cards currently in collection
  
  // constructors
  public Cards( boolean fullPack)
  {
    cards = new Card[ NOOFCARDSINFULLPACK ];
    valid = 0;
    
    if ( fullPack)
      createFullPackOfCards();
  }
  
  // methods
  public Card getTopCard()
  {
    Card tmp;
    if ( valid <= 0)
      return null;
    else
    {
      valid--;
      tmp = cards[valid];
      cards[valid] = null;
      return tmp;
    }
  }
  
  public boolean addTopCard( Card c)
  {
    if ( valid < cards.length)
    {
      cards[valid] = c;   // should this be cloned?
      valid++;
      return true;
    }
    return false;
  }
  
  private void createFullPackOfCards()
  {
    for (int i = 0; i < NOOFCARDSINFULLPACK; i++)
    {
      addTopCard( new Card(i) );
    }
  }
  
  public void shuffle()
  {
    int rnd;
    Card temp;
    for (int i = 0; i < valid; i++)
    {
      rnd = (int)(Math.random() * valid);
      temp = new Card(cards[rnd].cardNo);
      cards[rnd] = new Card(cards[i].cardNo);
      cards[i] = new Card(temp.cardNo);
    }
  }
  
  
  // For testOnly... remove from production version!
  public void testOnlyPrint()
  {
    for ( int i =0; i < valid; i++)
    {
      System.out.println( cards[i] );
    }
  }
  
} // end class Cards
