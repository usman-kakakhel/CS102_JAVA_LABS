import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//View game here

public class Main 
{
  public static void main(String[] args)
  {
    JFrame game = new GameFrame();
    
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setVisible(true);
  }
}