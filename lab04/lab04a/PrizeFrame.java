import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//frame with the game layout

public class PrizeFrame extends JFrame
{
  //properties
  private JLabel status;
  private ArrayList<JButton> buttons;
  private JPanel panelButtons;
  private JPanel panelStatus;
  private int prizeKey;
  private int mineKey;
  private int turns;
  private boolean gameOver;
  
  private static final int FRAME_WIDTH = 500;
  private static final int FRAME_HEIGHT = 500;
  
  private static final int PANEL_COLUMN = 4;
  private static final int PANEL_ROW = 4;
  
  
  //constructors
  public PrizeFrame()
  {
    startGame();
  }
  //methods
  
  /**
   * Starts the game.
   */
  public void startGame()
  {
    panelButtons = new JPanel();
    panelStatus = new JPanel();
    System.out.println("shutut");
    turns = 0;
    createComponents();
    setKeys();
    gameOver = false;
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
  }
  
  /**
   * Sets the key which will hide the prize.
   */
  public void setKeys()
  {
    mineKey = (int)(Math.random() *(PANEL_ROW * PANEL_COLUMN));
    
    prizeKey = (int)(Math.random() *(PANEL_ROW * PANEL_COLUMN));
    if (mineKey == prizeKey)
    {
      this.setKeys();
    }
  }
  
  /**
   * Create all the components to be added onto the panel.
   */
  public void createComponents()
  {
    System.out.println("yut");
    buttons = new ArrayList<JButton>();
    for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
    {
      
      buttons.add(new JButton("!"));
    }
    
    
    status = new JLabel("Number of guesses are: " + turns);
    status.setFont(new Font("Serif", Font.PLAIN, 20));
    
    panelButtons.setLayout(new GridLayout(PANEL_COLUMN, PANEL_ROW));
    
    panelStatus.add(status);
    for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
    {
      buttons.get(i).addActionListener(new ButtonListener());
      panelButtons.add(buttons.get(i));
    }
    
    add(panelStatus, BorderLayout.NORTH);
    add(panelButtons, BorderLayout.CENTER);
    panelButtons.updateUI();
  }
  
  //inner class for button prize hide.
  
  class ButtonListener implements ActionListener
  {
    
    /**
     * performs the function which is enabled on click on button.
     * @param event is the event that has occured.
     */
    public void actionPerformed(ActionEvent event)
    {
      if (!gameOver)
      {
        Object srcButton = event.getSource();
        
        for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
        {
          if (srcButton.equals(buttons.get(i)))
          {
            buttons.get(i).setEnabled(false);
            turns++;
            status.setText("Number of guesses are: " + turns);
            if (i == prizeKey)
            {
              buttons.get(i).setBackground(Color.yellow);
              setAllButtonsDisabled();
              status.setText("You got it in " + turns + " attempts!");
              gameOver = true;
            }
            else if(i == mineKey)
            {
              buttons.get(i).setBackground(Color.red);
              setAllButtonsDisabled();
              status.setText("You lost and you made " + turns + " attempts!");
              gameOver = true;
            }
          }
        }
      }
      
      if (gameOver)
      {
        if(JOptionPane.showConfirmDialog(PrizeFrame.this, "Play Again", "Game Over", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION);
        {
          // System.out.println("dgrg");
          
          
         // setAllButtonsEnabled();
         // setAllButtonsDefaultColor();
          panelButtons.removeAll(); 

             
          PrizeFrame.this.startGame();
          
        }
      }
      
    }
    /**
     * Sets color all buttons to default.
     */
    public void setAllButtonsDefaultColor()
    {
      for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
      {
        buttons.get(i).setBackground(null);
      }
    }
    
    /**
     * Disables all buttons when game is over.
     */
    public void setAllButtonsDisabled()
    {
      for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
      {
        buttons.get(i).setEnabled(false);
      }
    }
    
    /**
     * Enables all buttons when game starts.
     */
    public void setAllButtonsEnabled()
    {
      for (int i = 0; i < (PANEL_ROW * PANEL_COLUMN); i++)
      {
        buttons.get(i).setEnabled(true);
      }
    }
    
  }
  
}