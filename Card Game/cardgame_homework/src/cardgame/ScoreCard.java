package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
  // properties
  int[] scores;
  
  // constructors
  public ScoreCard( int noOfPlayers)
  {
    scores = new int[noOfPlayers];
    
    // init all scores to zero
    for ( int i = 0; i < scores.length; i++)
      scores[i] = 0;
  }
  
  // methods
  public int getScore( int playerNo)
  {
    return scores[ playerNo];
  }
  
  public void update( int playerNo, int amount)
  {
    scores[playerNo] += amount;
  }
  
  public String toString()
  {
    String s;
    s = "\n"
      + "_____________\n"
      + "\nPlayer\tScore\n"
      + "_____________\n";
    
    for ( int playerNo = 0; playerNo < scores.length; playerNo++)
    {
      s = s + (playerNo+1) + "\t" + scores[playerNo] + "\n";
    }
    
    s += "_____________\n";
    return s;
  }
  
  public int[] getWinners()
  {
    int valid = 0;
    int temp = 0;
    for (int i = 0; i < scores.length; i++)
    {
      if (temp < scores[i])
      {
        temp = scores[i];
      }
    }
    for (int i = 0; i < scores.length; i++)
    {
      if (temp == scores[i])
      {
        valid++;
      }
    }
    int[] tmp = new int[valid];
    int j = 0;
    for (int i = 0; i < scores.length; i++)
    {
      if (temp == scores[i])
      {
        tmp[j] = i;
        j++;
      }
    }
    return tmp;
  }
  
  
} // end class ScoreCard
