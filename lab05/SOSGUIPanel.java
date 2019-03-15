import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SOSGUIPanel extends JPanel
{
  //properties
  String name1;
  String name2;
  SOSCanvas canvas;
  JLabel player1;
  JLabel player2;
  JRadioButton button1;
  JRadioButton button2;
  JButton restartButton;
  MyMouseListener mouseListener;
  static final int FRAME_WIDTH = 530;
  static final int FRAME_HEIGHT = 620;
  
  
  //constructor
  public SOSGUIPanel( SOSCanvas canvas, String name1, String name2 ) 
  {
    this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    this.name1 = name1;
    this.name2 = name2;
    this.canvas = canvas;
    startGame();
  }
  
  /**
   * Starts playing the sos game.
   */
  public void startGame()
  {
    restartButton = new JButton("RESTART");
    
    button1 = new JRadioButton("s");
    button1.setFont(new Font("Calibri", Font.PLAIN, 20));
    button2 = new JRadioButton("o");
    button2.setFont(new Font("Calibri", Font.PLAIN, 20));
    
    player1 = new JLabel(name1 + " : " + canvas.getGame().getPlayerScore1());
    player1.setFont(new Font("Calibri", Font.PLAIN, 20));
    player1.setOpaque(true);
    player1.setBackground(Color.green);
    player2 = new JLabel(name2 + " : " + canvas.getGame().getPlayerScore2());
    player2.setFont(new Font("Calibri", Font.PLAIN, 20));
    button1.setSelected(true);
    player2.setOpaque(true);
    
    ButtonGroup group = new ButtonGroup();
    group.add(button1);
    group.add(button2);
    
    player2.setBackground(Color.white);
    //adding a mouse listener
    mouseListener = new MyMouseListener();
    this.addMouseListener(mouseListener);
    
    JPanel panel = new SOSStatusCanvasHolder(canvas, player1, player2, button1, button2, restartButton);
    
    this.add( panel );
  }
  
  
  //inner class for mouse action
  class MyMouseListener implements MouseListener
  {
    
    /**
     * Sets location of the shape.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mousePressed(MouseEvent event)
    {
      SOS theSOSGame = canvas.getGame();
      int x = event.getX();
      int y = event.getY();
      char a = '.';
      
      //calculating the character to send
      if ( button1.isSelected() )
      {
        a = button1.getText().charAt(0);
      }
      else if ( button2.isSelected() )
      {
        a = button2.getText().charAt(0);
      }
      //calculating the x and y to send
      x = (int)((x - 30) / (canvas.FRAME_WIDTH / theSOSGame.getDimension())) + 1;
      y = (int)((y - 30) / (canvas.FRAME_HEIGHT / theSOSGame.getDimension())) + 1;
      //play turn
      canvas.play(a, x, y);
      //change color of label with turn
      if (theSOSGame.getTurn() == 1)
      {
        player1.setBackground(Color.green);
        player2.setBackground(Color.white);
      }
      else if (theSOSGame.getTurn() == 2)
      {
        player1.setBackground(Color.white);
        player2.setBackground(Color.green);
      }
      //update points
      player1.setText(name1 + " : " + theSOSGame.getPlayerScore1());
      player2.setText(name2 + " : " + theSOSGame.getPlayerScore2());
      
      //give game over if game is over
      if (theSOSGame.isGameOver())
      {
        if (theSOSGame.getPlayerScore1() > theSOSGame.getPlayerScore2())
          JOptionPane.showMessageDialog(SOSGUIPanel.this, name1 + " is the Winner!", "GAME OVER", JOptionPane.WARNING_MESSAGE); 
        else if (theSOSGame.getPlayerScore1() < theSOSGame.getPlayerScore2())
          JOptionPane.showMessageDialog(SOSGUIPanel.this, name2 + " is the Winner!", "GAME OVER", JOptionPane.WARNING_MESSAGE); 
        else if (theSOSGame.getPlayerScore1() == theSOSGame.getPlayerScore2())
          JOptionPane.showMessageDialog(SOSGUIPanel.this, " It's a draw!", "GAME OVER", JOptionPane.WARNING_MESSAGE); 
      }
      
      
    }
    
    /**
     * Is triggered on mouse release.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseReleased(MouseEvent event) {}
    
    /**
     * Is triggered on mouse clicked.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseClicked(MouseEvent event) {}
    
    /**
     * Is triggered on mouse entered.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseEntered(MouseEvent event) {}
    
    /**
     * Is triggered on mouse exited.
     * @param event as the event that has been performed which is used to use some commands.
     */
    public void mouseExited(MouseEvent event) {}
  }
  
  
}
