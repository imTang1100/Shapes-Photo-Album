package utility;

import java.awt.event.*;
import java.util.HashMap;

import views.swing.GraphicalView;
import views.swing.View;

/**
 * The type Abstract button.
 */
public class AbstractButton implements ActionListener {

  private GraphicalView graphicalView;
  private View view;
  private HashMap hashMap;

  /**
   * Instantiates a new Abstract button.
   */
  public AbstractButton() {}

  /**
   * Instantiates a new Abstract button.
   *
   * @param view          the view
   * @param graphicalView the graphical view
   */
  public AbstractButton(View view, GraphicalView graphicalView) {
    this.view = view;
    this.graphicalView = graphicalView;
    this.hashMap = view.getController().getModel().getSnapShots().getHashMap();
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {

  }

  /**
   * Gets graphical view.
   *
   * @return the graphical view
   */
  public GraphicalView getGraphicalView() {
    return graphicalView;
  }

  /**
   * Gets view.
   *
   * @return the view
   */
  public View getView() {
    return this.view;
  }

  /**
   * Gets hash map.
   *
   * @return the hash map
   */
  public HashMap getHashMap() {
    return hashMap;
  }
}
