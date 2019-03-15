import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SOSStatusCanvasHolder extends JPanel
{
  //properties
  
  //constructor
  public SOSStatusCanvasHolder( SOSCanvas canvas, JLabel player1, JLabel player2, JRadioButton button1, JRadioButton button2, JButton restartButton) 
  {
    JPanel panel = new SOSStatusBar(player1, player2, button1, button2);
    
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    //this.add(this.getButton(restartButton));
    this.add(canvas);
    this.add(panel);
  }
  
//  /**
//   * Makes a panel with a restart button.
//   * @param restartButton as the button. 
//   * @return JPanel as the panel which has the restart button.
//   */
//  public JPanel getButton(JButton restartButton)
//  {
//    JPanel panel = new JPanel();
//    
//    panel.add(restartButton);
//    
//    return panel;
//  }
  
}
