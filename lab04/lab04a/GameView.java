import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//View game here

public class GameView 
{
  public static void main(String[] args)
  {
    JFrame game = new PrizeFrame();
    
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setVisible(true);
  }
}