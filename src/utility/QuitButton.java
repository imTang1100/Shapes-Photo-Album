package utility;

import java.awt.event.*;

/**
 * The type Quit button.
 */
public class QuitButton implements ActionListener {

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
